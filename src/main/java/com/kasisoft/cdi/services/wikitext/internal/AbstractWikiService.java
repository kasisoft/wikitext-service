package com.kasisoft.cdi.services.wikitext.internal;

import static com.kasisoft.cdi.services.wikitext.internal.Messages.*;

import com.kasisoft.cdi.services.wikitext.*;

import org.eclipse.mylyn.wikitext.parser.*;
import org.eclipse.mylyn.wikitext.parser.builder.*;
import org.eclipse.mylyn.wikitext.parser.markup.*;

import java.io.*;

import lombok.extern.slf4j.*;

import lombok.experimental.*;

import lombok.*;

/**
 * Base implementation for all services that are supposed to transform markup of a certain type into the corresponding
 * html code.
 *  
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(of = "name")
@EqualsAndHashCode(of = "name")
public abstract class AbstractWikiService implements HtmlService, Serializable {

  private static final HtmlConfig DEFAULT_CONFIG  = new HtmlConfig();
  
  MarkupParser   parser;
  String         name;
  
  public AbstractWikiService( @NonNull MarkupLanguage language ) {
    parser = new MarkupParser( language );
    name   = language.getName();
  }
  
  @Override
  public String buildHtml( HtmlConfig config, @NonNull String markup ) {
    try {
      if( config == null ) {
        config = DEFAULT_CONFIG;
      }
      StringWriter        writer     = new StringWriter();
      HtmlDocumentBuilder docbuilder = new HtmlDocumentBuilder( new CustomXmlStreamWriter( config, writer ) );
      docbuilder.setEmitAsDocument( config.isHtmlWrapper() );
      synchronized( parser ) {
        /** 
         * @todo [03-Nov-2014:KASI]   Check whether the parse is expensive or not so we might use multiple instances to
         *                            prevent blocks.
         */
        parser.setBuilder( docbuilder );
        parser.parse( markup );
      }
      return writer.toString();
    } catch( Exception ex ) {
      log.debug( conversion_error.format( name, ex.getLocalizedMessage() ), ex );
      if( config.getEmbedErrorContent() != null ) {
        return config.getEmbedErrorContent().apply( ex );
      } else {
        return null;
      }
    }
  }
  
} /* ENDCLASS */

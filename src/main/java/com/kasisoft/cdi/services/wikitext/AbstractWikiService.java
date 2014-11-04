package com.kasisoft.cdi.services.wikitext;

import static com.kasisoft.cdi.services.wikitext.internal.Messages.*;

import com.kasisoft.cdi.services.wikitext.internal.*;
import com.kasisoft.libs.common.util.*;

import org.eclipse.mylyn.wikitext.core.parser.*;
import org.eclipse.mylyn.wikitext.core.parser.builder.*;
import org.eclipse.mylyn.wikitext.core.parser.markup.*;

import java.io.*;

import lombok.*;
import lombok.extern.slf4j.*;

/**
 * Base implementation for all services that are supposed to transform markup of a certain type into the corresponding
 * html code.
 *  
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Slf4j
public abstract class AbstractWikiService implements Serializable {

  private static final HtmlConfig DEFAULT_CONFIG  = new HtmlConfig();
  
  private MarkupParser   parser;
  private String         name;
  
  public AbstractWikiService( @NonNull MarkupLanguage language ) {
    parser = new MarkupParser( language );
    name   = language.getName();
  }
  
  /**
   * Builds the HTML code from the supplied markup.
   * 
   * @param config      Some configuration options for the markup generation. Maybe <code>null</code>.
   * @param markup      The markup which will be converted into HTML. Not <code>null</code>.
   * 
   * @return   The converted HTML code. Not <code>null</code>.
   */
  public String buildHtml( HtmlConfig config, @NonNull String markup ) {
    try {
      if( config == null ) {
        config = DEFAULT_CONFIG;
      }
      StringWriter        writer     = new StringWriter();
      HtmlDocumentBuilder docbuilder = new CustomHtmlDocumentBuilder( config, writer );
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
      if( config.getErrorContent() == null ) {
        return defaultErrorMarkup( ex );
      } else {
        return config.getErrorContent();
      }
    }
  }
  
  private String defaultErrorMarkup( Exception ex ) {
    StringWriter writer = new StringWriter();
    try( PrintWriter printer = new PrintWriter( writer ) ) {
      ex.printStackTrace( printer );
    }
    StringFBuilder builder = new StringFBuilder();
    builder.appendF( "<h1>Error</h1>\n" );
    builder.appendF( "<p><![CDATA[%s]]></p>\n", writer.toString() );
    return builder.toString();
  }
  
} /* ENDCLASS */

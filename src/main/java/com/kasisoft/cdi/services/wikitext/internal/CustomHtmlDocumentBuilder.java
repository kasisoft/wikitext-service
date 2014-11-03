package com.kasisoft.cdi.services.wikitext.internal;

import com.kasisoft.cdi.services.wikitext.*;

import org.eclipse.mylyn.wikitext.core.parser.builder.*;
import org.eclipse.mylyn.wikitext.core.util.*;

import java.io.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class CustomHtmlDocumentBuilder extends HtmlDocumentBuilder {

  private HtmlConfig    config;
  
  public CustomHtmlDocumentBuilder( HtmlConfig htmlConfig, Writer out ) {
    super( createWriter( htmlConfig, out, false ) );
    config = htmlConfig;
  }

  public CustomHtmlDocumentBuilder( HtmlConfig htmlConfig, Writer out, boolean formatting ) {
    super( createWriter( htmlConfig, out, formatting ) );
    config = htmlConfig;
  }

  @Override
  protected void emitHead() {
    if( ! config.isBodyContentOnly() ) {
      super.emitHead();
    }
  }

  private static XmlStreamWriter createWriter( HtmlConfig htmlConfig, Writer out, boolean formatting ) {
    XmlStreamWriter xmlWriter = new CustomXmlStreamWriter( htmlConfig, out );
    if( formatting ) {
      xmlWriter = new FormattingXMLStreamWriter( xmlWriter );
    }
    return xmlWriter;
  }
  
} /* ENDCLASS */

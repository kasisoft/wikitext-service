package com.kasisoft.cdi.services.wikitext;

import com.kasisoft.libs.common.text.*;

import java.util.function.*;

import java.io.*;

import lombok.experimental.*;

import lombok.*;

/**
 * Configuration type which allows to refine the generation of the html markup. 
 * 
 * @author daniel.kasmeroglu@kasisoft.net
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public final class HtmlConfig {

  // generate html wrapper (html-head-body) around the content
  boolean                       htmlWrapper       = false;
  
  // this function generates the html content for a specific exception. by default
  // it creating a headline with the stacktrace in a paragraph. if set to null 
  // the HtmlService will return null as well.
  Function<Exception, String>   embedErrorContent = HtmlConfig::defaultErrorMarkup;
  
  // disable the generation of IDs for heading elements
  boolean                       disableHeadingIds = true;
  
  private static String defaultErrorMarkup( Exception ex ) {
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

package com.kasisoft.cdi.services.wikitext;


/**
 * Service api for Html generators. 
 * 
 * @author daniel.kasmeroglu@kasisoft.net
 */
public interface HtmlService {

  /**
   * Builds the HTML code from the supplied markup.
   * 
   * @param config      Some configuration options for the markup generation. Maybe <code>null</code>.
   * @param markup      The markup which will be converted into HTML. Not <code>null</code>.
   * 
   * @return   The converted HTML code. Not <code>null</code>.
   */
  String buildHtml( HtmlConfig config, String markup );
  
} /* ENDINTERFACE */

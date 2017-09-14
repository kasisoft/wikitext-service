package com.kasisoft.cdi.services.wikitext;

import com.kasisoft.cdi.services.wikitext.internal.*;
import com.kasisoft.cdi.weldex.*;

import lombok.experimental.*;

import lombok.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class AbstractWikiServiceTest<T extends AbstractWikiService> {

  private static final String WRAPPER = ""
    + "<?xml version='1.0' encoding='utf-8' ?>"
    + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
    + "<head>"
    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"
    + "</head>"
    + "<body>"
    + "%s"
    + "</body>"
    + "</html>";
  
  Class<T>   type;
  T          wikiService;
  
  protected AbstractWikiServiceTest( @NonNull Class<T> clazz ) {
    type        = clazz;
    wikiService = CdiContext.component( type );
  }
  
  protected String buildHtml( HtmlConfig config, String markup ) {
    return wikiService.buildHtml( config, markup );
  }
  
  protected String htmlWrap( String content ) {
    return String.format( WRAPPER, content );
  }
  
} /* ENDCLASS */

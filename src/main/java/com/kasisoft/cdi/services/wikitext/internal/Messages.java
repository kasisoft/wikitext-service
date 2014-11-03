package com.kasisoft.cdi.services.wikitext.internal;

import com.kasisoft.libs.common.i18n.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class Messages {

  @I18N("Failed to convert %s markup. Cause: %s")
  public static I18NFormatter     conversion_error;
  
  static {
    I18NSupport.initialize( Messages.class );
  }
  
} /* ENDCLASS */

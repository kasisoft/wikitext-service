package com.kasisoft.cdi.services.wikitext;

import lombok.*;
import lombok.experimental.*;

/**
 * Configuration type which allows to refine the generation of the html markup. 
 * 
 * @author daniel.kasmeroglu@kasisoft.net
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public final class HtmlConfig {

  // generate only the content which would go into the body
  boolean   bodyContentOnly   = false; // true;
  
  // the content to be used in case of an unexpected error while parsing. a null value means to generate 
  // a html description of the error.
  String    errorContent      = null;
  
  // disable the generation of IDs for heading elements
  boolean   disableHeadingIds = false; // true
  
} /* ENDCLASS */

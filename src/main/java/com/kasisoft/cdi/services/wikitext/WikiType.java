package com.kasisoft.cdi.services.wikitext;

import com.kasisoft.cdi.services.wikitext.internal.*;
import com.kasisoft.cdi.weldex.*;

import java.util.function.*;

import lombok.experimental.*;

import lombok.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum WikiType implements Supplier<HtmlService> {

  confluence ( ConfluenceWikiService . class ),
  markdown   ( MarkdownWikiService   . class ),
  mediawiki  ( MediaWikiService      . class ),
  textile    ( TextileWikiService    . class ),
  trac       ( TracWikiService       . class ),
  twiki      ( TWikiService          . class );
  
  Class<? extends AbstractWikiService>   clazz;
  HtmlService                            instance;
  
  WikiType( Class<? extends AbstractWikiService> type ) {
    clazz = type;
  }

  @Override
  public synchronized HtmlService get() {
    if( instance == null ) {
      instance = CdiContext.component( clazz );
    }
    return instance;
  }
  
} /* ENDENUM */

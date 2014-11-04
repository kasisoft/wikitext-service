package com.kasisoft.cdi.services.wikitext;

import javax.ejb.*;
import javax.ejb.Singleton;
import javax.inject.*;

import java.io.*;

import lombok.*;
import lombok.experimental.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class GenericWikiService implements Serializable {

  @Inject
  ConfluenceWikiService   confluenceService;

  @Inject
  MarkdownWikiService     markdownService;

  @Inject
  MediaWikiService        mediawikiService;
  
  @Inject
  TextileWikiService      textileService;
  
  @Inject
  TracWikiService         tracService;
  
  @Inject
  TWikiService            twikiService;
  
  /**
   * Returns the wiki service associated with the supplied wiki type.
   * 
   * @param type   The type of the desired service. Not <code>null</code>.
   * 
   * @return   The desired wiki service. Not <code>null</code> 
   */
  public <T extends AbstractWikiService> T getWikiService( @NonNull WikiType type ) {
    switch( type ) {
    case confluence       : return (T) confluenceService;
    case markdown         : return (T) markdownService;
    case mediawiki        : return (T) mediawikiService;
    case textile          : return (T) textileService;
    case trac             : return (T) tracService;
    default /* twiki */   : return (T) twikiService;
    }
  }

} /* ENDCLASS */

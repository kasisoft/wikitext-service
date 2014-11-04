package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.tracwiki.core.*;

import javax.ejb.*;
import javax.ejb.Singleton;
import javax.inject.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Named @Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class TracWikiService extends AbstractWikiService {
  
  public TracWikiService() {
    super( new TracWikiLanguage() );
  }

} /* ENDCLASS */

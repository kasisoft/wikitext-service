package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.tracwiki.core.*;

import javax.ejb.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class TracWikiService extends AbstractWikiService {
  
  public TracWikiService() {
    super( new TracWikiLanguage() );
  }

} /* ENDCLASS */

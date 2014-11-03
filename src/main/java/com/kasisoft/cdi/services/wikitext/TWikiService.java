package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.twiki.core.*;

import javax.ejb.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class TWikiService extends AbstractWikiService {
  
  public TWikiService() {
    super( new TWikiLanguage() );
  }

} /* ENDCLASS */

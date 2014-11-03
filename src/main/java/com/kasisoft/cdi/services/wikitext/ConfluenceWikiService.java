package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.confluence.core.*;

import javax.ejb.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ConfluenceWikiService extends AbstractWikiService {
  
  public ConfluenceWikiService() {
    super( new ConfluenceLanguage() );
  }

} /* ENDCLASS */

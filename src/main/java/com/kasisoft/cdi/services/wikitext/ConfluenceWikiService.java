package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.confluence.core.*;

import javax.ejb.*;
import javax.ejb.Singleton;
import javax.inject.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Named @Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ConfluenceWikiService extends AbstractWikiService {
  
  public ConfluenceWikiService() {
    super( new ConfluenceLanguage() );
  }

} /* ENDCLASS */

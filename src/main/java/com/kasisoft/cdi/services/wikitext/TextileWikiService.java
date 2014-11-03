package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.textile.core.*;

import javax.ejb.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class TextileWikiService extends AbstractWikiService {
  
  public TextileWikiService() {
    super( new TextileLanguage() );
  }

} /* ENDCLASS */

package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.mediawiki.core.*;

import javax.ejb.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class MediaWikiService extends AbstractWikiService {
  
  public MediaWikiService() {
    super( new MediaWikiLanguage() );
  }

} /* ENDCLASS */

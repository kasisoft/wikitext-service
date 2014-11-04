package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.textile.core.*;

import javax.ejb.*;
import javax.ejb.Singleton;
import javax.inject.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Named @Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class TextileWikiService extends AbstractWikiService {
  
  public TextileWikiService() {
    super( new TextileLanguage() );
  }

} /* ENDCLASS */

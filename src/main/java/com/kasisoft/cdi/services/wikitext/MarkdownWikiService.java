package com.kasisoft.cdi.services.wikitext;

import org.eclipse.mylyn.wikitext.markdown.core.*;

import javax.ejb.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class MarkdownWikiService extends AbstractWikiService {
  
  public MarkdownWikiService() {
    super( new MarkdownLanguage() );
  }

} /* ENDCLASS */

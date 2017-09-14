package com.kasisoft.cdi.services.wikitext;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class MarkdownWikiServiceTest extends AbstractWikiServiceTest<MarkdownWikiService> {

  public MarkdownWikiServiceTest() {
    super( MarkdownWikiService.class );
  }
  
  private static final String EXPECTED = ""
    + "<h1>My first headline</h1>"
    + "<p>This is what it's all about.</p>"
    + "<h2>My sub headline</h2>"
    + "<p>Sub paragraph</p>"
    + "<h1>My second headline</h1>"
    + "<p>Unordered list elements:</p>"
    + "<ul>"
    + "<li>First item</li>"
    + "<li>Second item</li>"
    + "<li>Third item</li>"
    + "</ul>"
    + "<h1>My third headline</h1>"
    + "<p>Ordered list elements:</p>"
    + "<ol>"
    + "<li>First item</li>"
    + "<li>Second item</li>"
    + "<li>Third item</li>"
    + "</ol>"
    + "<h1>Stylings</h1>"
    + "<p><em>my italic text</em></p>"
    + "<p><strong>my bold text</strong></p>"
    + "<blockquote><p>citation</p></blockquote>"
    + "<p><code>monospaced text</code></p>"
    ;
  
  private static final String MARKUP = ""
    + "# My first headline\n"
    + "This is what it's all about.\n\n"
    + "## My sub headline\n"
    + "Sub paragraph\n\n"
    + "# My second headline\n"
    + "Unordered list elements:\n\n"
    + "* First item\n"
    + "* Second item\n"
    + "* Third item\n\n"
    + "# My third headline\n"
    + "Ordered list elements:\n\n"
    + "1. First item\n"
    + "2. Second item\n"
    + "3. Third item\n\n"
    + "# Stylings\n"
    + "*my italic text*\n\n"
    + "**my bold text**\n\n"
    + "> citation\n\n"
    + "`monospaced text`\n"
    ;
  
  @Test
  public void buildHtml() {
    String html = buildHtml( null, MARKUP );
    assertThat( html, is( EXPECTED ) );
  }

  @Test
  public void buildHtmlWithWrapper() {
    HtmlConfig config = new HtmlConfig();
    config.setHtmlWrapper( true );
    String     html   = buildHtml( config, MARKUP );
    assertThat( html, is( htmlWrap( EXPECTED ) ) );
  }
  
} /* ENDCLASS */

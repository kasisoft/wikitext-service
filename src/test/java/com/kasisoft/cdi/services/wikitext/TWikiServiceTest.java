package com.kasisoft.cdi.services.wikitext;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class TWikiServiceTest extends AbstractWikiServiceTest<TWikiService> {

  public TWikiServiceTest() {
    super( TWikiService.class );
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
    + "<li>Second item"
    + "<ul>"
    + "<li>Inner item</li>"
    + "</ul>"
    + "</li>"
    + "<li>Third item</li>"
    + "</ul>"
    + "<h1>My third headline</h1>"
    + "<p>Ordered list elements:</p>"
    + "<ol>"
    + "<li>First item</li>"
    + "<li>Second item"
    + "<ol>"
    + "<li>Inner item</li>"
    + "</ol>"
    + "</li>"
    + "<li>Third item</li>"
    + "</ol>"
    + "<h1>Stylings</h1>"
    + "<p><i>my italic text</i></p>"
    + "<p><b>my bold text</b></p>"
    + "<p><u>inserted text</u></p>"
    + "<p><del>deleted text</del></p>"
    + "<p><sup>superscript text</sup></p>"
    + "<p><sub>subscript text</sub></p>"
    + "<p><cite>citation</cite></p>"
    + "<p><tt>monospaced text</tt></p>"
    ;
  
  private static final String MARKUP = ""
    + "---+My first headline\n"
    + "This is what it's all about.\n"
    + "---++My sub headline\n"
    + "Sub paragraph\n"
    + "---+My second headline\n"
    + "Unordered list elements:\n"
    + "   * First item\n"
    + "   * Second item\n"
    + "      * Inner item\n"
    + "   * Third item\n"
    + "---+My third headline\n"
    + "Ordered list elements:\n"
    + "   1. First item\n"
    + "   1. Second item\n"
    + "      1. Inner item\n"
    + "   1. Third item\n"
    + "---+Stylings\n"
    + "_my italic text_\n\n"
    + "*my bold text*\n\n"
    + "<u>inserted text</u>\n\n"
    + "<del>deleted text</del>\n\n"
    + "<sup>superscript text</sup>\n\n"
    + "<sub>subscript text</sub>\n\n"
    + "<cite>citation</cite>\n\n"
    + "=monospaced text=\n"
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

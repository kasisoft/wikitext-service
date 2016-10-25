package com.kasisoft.cdi.services.wikitext;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.kasisoft.cdi.weldex.*;

import org.testng.annotations.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class ConfluenceWikiServiceTest {

  private AbstractWikiService   wikiService;
  
  @BeforeSuite
  public void init() {
    wikiService = CdiContext.component( ConfluenceWikiService.class );
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
    + "<p>"
    + "<em>my italic text</em>"
    + "<br/>"
    + "<strong>my bold text</strong>"
    + "<br/>"
    + "<u>inserted text</u>"
    + "<br/>"
    + "<del>deleted text</del>"
    + "<br/>"
    + "<sup>superscript text</sup>"
    + "<br/>"
    + "<sub>subscript text</sub>"
    + "<br/>"
    + "<cite>citation</cite>"
    + "<br/>"
    + "<tt>monospaced text</tt>"
    + "</p>";
  
  private static final String MARKUP = ""
    + "h1. My first headline\n"
    + "This is what it's all about.\n"
    + "h2. My sub headline\n"
    + "Sub paragraph\n"
    + "h1. My second headline\n"
    + "Unordered list elements:\n"
    + "* First item\n"
    + "* Second item\n"
    + "** Inner item\n"
    + "* Third item\n"
    + "h1. My third headline\n"
    + "Ordered list elements:\n"
    + "# First item\n"
    + "# Second item\n"
    + "## Inner item\n"
    + "# Third item\n"
    + "h1. Stylings\n"
    + "_my italic text_\n"
    + "*my bold text*\n"
    + "+inserted text+\n"
    + "-deleted text-\n"
    + "^superscript text^\n"
    + "~subscript text~\n"
    + "??citation??\n"
    + "{{monospaced text}}\n"
    ;
  
  @Test
  public void buildHtml() {
    String html = wikiService.buildHtml( null, MARKUP );
    assertThat( html, is( EXPECTED ) );
  }
  
} /* ENDCLASS */

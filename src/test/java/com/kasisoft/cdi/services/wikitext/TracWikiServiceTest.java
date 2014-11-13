package com.kasisoft.cdi.services.wikitext;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class TracWikiServiceTest {

  private AbstractWikiService   wikiService;
  
  @BeforeSuite
  public void init() {
    wikiService = new TracWikiService();
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
    + "<p><del>deleted text</del></p>"
    + "<p><sup>superscript text</sup></p>"
    + "<p><sub>subscript text</sub></p>"
    + "<blockquote><p>citation</p></blockquote>"
    + "<blockquote><p>monospaced text</p></blockquote>"
    ;
  
  private static final String MARKUP = ""
    + "=My first headline=\n"
    + "This is what it's all about.\n\n"
    + "==My sub headline==\n"
    + "Sub paragraph\n\n"
    + "=My second headline=\n"
    + "Unordered list elements:\n"
    + "* First item\n"
    + "* Second item\n"
    + " * Inner item\n"
    + "* Third item\n"
    + "=My third headline=\n"
    + "Ordered list elements:\n"
    + "1. First item\n"
    + "2. Second item\n"
    + " 1. Inner item\n"
    + "3. Third item\n"
    + "=Stylings=\n"
    + "''my italic text''\n\n"
    + "'''my bold text'''\n\n"
    + "~~deleted text~~\n\n"
    + "^superscript text^\n\n"
    + ",,subscript text,,\n\n"
    + "> citation\n\n"
    + "  monospaced text\n"
    ;
  
  @Test
  public void buildHtml() {
    String html = wikiService.buildHtml( null, MARKUP );
    assertThat( html, is( EXPECTED ) );
  }
  
} /* ENDCLASS */

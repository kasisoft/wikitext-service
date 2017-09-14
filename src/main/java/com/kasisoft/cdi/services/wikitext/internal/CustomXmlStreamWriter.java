package com.kasisoft.cdi.services.wikitext.internal;

import com.kasisoft.cdi.services.wikitext.*;

import org.eclipse.mylyn.wikitext.util.*;

import java.util.*;

import java.io.*;

import lombok.experimental.*;

import lombok.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomXmlStreamWriter extends DefaultXmlStreamWriter {

  private static Set<String> HEADINGS = Collections.unmodifiableSet( new HashSet<>( Arrays.<String>asList( "h1", "h2", "h3", "h4", "h5", "h6", "h7" ) ) );
  
  HtmlConfig      config;
  Stack<String>   elements;
  
  public CustomXmlStreamWriter( HtmlConfig htmlConfig, Writer out ) {
    super( out );
    config    = htmlConfig;
    elements  = new Stack<>();
  }

  @Override
  public void writeStartElement( String localName ) {
    elements.push( localName );
    super.writeStartElement( localName );
  }
  
  @Override
  public void writeEmptyElement( String localName ) {
    elements.push( localName );
    super.writeEmptyElement( localName );
  }

  @Override
  public void writeStartElement( String namespaceURI, String localName ) {
    elements.push( localName );
    super.writeStartElement( namespaceURI, localName );
  }

  @Override
  public void writeEmptyElement( String namespaceURI, String localName ) {
    elements.push( localName );
    super.writeEmptyElement( namespaceURI, localName );
  }
  
  @Override
  public void writeStartElement( String prefix, String localName, String namespaceURI ) {
    elements.push( localName );
    super.writeStartElement( prefix, localName, namespaceURI );
  }

  @Override
  public void writeEmptyElement( String prefix, String localName, String namespaceURI ) {
    elements.push( localName );
    super.writeEmptyElement( prefix, localName, namespaceURI );
  }

  @Override
  public void writeEndElement() {
    elements.pop();
    super.writeEndElement();
  }
  
  @Override
  public void writeAttribute( String localName, String value ) {
    if( ! skipAttribute( localName ) ) {
      super.writeAttribute( localName, value );
    }
  }

  @Override
  public void writeAttribute( String namespaceURI, String localName, String value ) {
    if( ! skipAttribute( localName ) ) {
      super.writeAttribute( namespaceURI, localName, value );
    }
  }

  @Override
  public void writeAttribute( String prefix, String namespaceURI, String localName, String value ) {
    if( ! skipAttribute( localName ) ) {
      super.writeAttribute( prefix, namespaceURI, localName, value );
    }
  }

  private boolean skipAttribute( String attributeName ) {
    if( config.isDisableHeadingIds() && "id".equals( attributeName ) ) {
      String localName = elements.peek();
      return HEADINGS.contains( localName );
    }
    return false;
  }
  
} /* ENDCLASS */

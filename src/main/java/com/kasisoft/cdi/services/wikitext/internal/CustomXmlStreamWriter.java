package com.kasisoft.cdi.services.wikitext.internal;

import com.kasisoft.cdi.services.wikitext.*;

import org.eclipse.mylyn.wikitext.core.util.*;

import java.util.*;

import java.io.*;

/**
 * @author daniel.kasmeroglu@kasisoft.net
 */
public class CustomXmlStreamWriter extends DefaultXmlStreamWriter {

  private HtmlConfig      config;
  private Stack<String>   elements;
  
  public CustomXmlStreamWriter( HtmlConfig htmlConfig, Writer out ) {
    super( out );
    config    = htmlConfig;
    elements  = new Stack<>();
  }

  @Override
  public void writeStartDocument() {
    if( ! config.isBodyContentOnly() ) {
      super.writeStartDocument();
    }
  }

  @Override
  public void writeStartDocument( String version ) {
    if( ! config.isBodyContentOnly() ) {
      super.writeStartDocument( version );
    }
  }

  @Override
  public void writeStartDocument( String encoding, String version ) {
    if( ! config.isBodyContentOnly() ) {
      super.writeStartDocument( encoding, version );
    }
  }

  @Override
  public void writeStartElement( String localName ) {
    elements.push( localName );
    if( ! isSkippedElement( localName ) ) {
      super.writeStartElement( localName );
    }
  }

  @Override
  public void writeStartElement( String namespaceURI, String localName ) {
    elements.push( localName );
    if( ! isSkippedElement( localName ) ) {
      super.writeStartElement( namespaceURI, localName );
    }
  }

  @Override
  public void writeStartElement( String prefix, String localName, String namespaceURI ) {
    elements.push( localName );
    if( ! isSkippedElement( localName ) ) {
      super.writeStartElement( prefix, namespaceURI, localName );
    }
  }

  @Override
  public void writeEndElement() {
    String localName = elements.pop();
    if( ! isSkippedElement( localName ) ) {
      super.writeEndElement();
    }
  }
  
  @Override
  public void writeAttribute( String localName, String value ) {
    String elementName = elements.peek();
    if( ! isSkippedElement( elementName ) ) {
      if( ! isSkippedAttribute( localName ) ) {
        super.writeAttribute( localName, value );
      }
    }
  }

  @Override
  public void writeAttribute( String namespaceURI, String localName, String value ) {
    String elementName = elements.peek();
    if( ! isSkippedElement( elementName ) ) {
      if( ! isSkippedAttribute( localName ) ) {
        super.writeAttribute( namespaceURI, localName, value );
      }
    }
  }

  @Override
  public void writeAttribute( String prefix, String namespaceURI, String localName, String value ) {
    String elementName = elements.peek();
    if( ! isSkippedElement( elementName ) ) {
      if( ! isSkippedAttribute( localName ) ) {
        super.writeAttribute( prefix, namespaceURI, localName, value );
      }
    }
  }

  private boolean isSkippedAttribute( String attributeName ) {
    if( config.isDisableHeadingIds() && "id".equals( attributeName ) ) {
      String localName = elements.peek();
      if( "h1".equals( localName ) || "h2".equals( localName ) || "h3".equals( localName ) || 
          "h4".equals( localName ) || "h5".equals( localName ) || "h6".equals( localName ) ||
          "h7".equals( localName )
      ) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isSkippedElement( String localName ) {
    if( config.isBodyContentOnly() ) {
      if( "html".equals( localName ) || "body".equals( localName ) ) {
        return true;
      }
    }
    return false;
  }

} /* ENDCLASS */

package com.springapp.mvc.syncmodel;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StaXParser
{
    static final String DATE = "date";

    static final String ITEM = "item";

    static final String MODE = "mode";

    static final String UNIT = "unit";

    static final String CURRENT = "current";

    static final String INTERACTIVE = "interactive";

    @SuppressWarnings( { "unchecked", "null" } )
    public List<SyncDataSet> readConfig( InputStream in )
    {
        List<SyncDataSet> items = new ArrayList<SyncDataSet>();
        try
        {
            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            //      InputStream in = new FileInputStream(configFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader( in );
            // Read the XML document
            SyncDataSet item = null;

            while ( eventReader.hasNext() )
            {
                XMLEvent event = eventReader.nextEvent();

                if ( event.isStartElement() )
                {
                    StartElement startElement = event.asStartElement();
                    // If we have a item element we create a new item
                    if ( startElement.getName().getLocalPart() == ("dataSet") )
                    {
                        //            System.out.println("reaeched here1");
                        item = new SyncDataSet();
                        // We read the attributes from this tag and add the date
                        // attribute to our object
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while ( attributes.hasNext() )
                        {
                            Attribute attribute = attributes.next();
                            //              System.out.println(attribute);
                            if ( attribute.getName().toString().equals( "name" ) )
                            {
                                item.setName( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "code" ) )
                            {
                                item.setCode( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "href" ) )
                            {
                                item.setHref( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "id" ) )
                            {
                                item.setId( attribute.getValue() );
                            }

                        }
                    }

                }
                // If we reach the end of an item element we add it to the list
                if ( event.isEndElement() )
                {
                    EndElement endElement = event.asEndElement();
                    if ( endElement.getName().getLocalPart() == ("dataSet") )
                    {
                        items.add( item );
                    }
                }

            }
        }
        catch ( XMLStreamException e )
        {
            e.printStackTrace();
        }
        return items;
    }

    @SuppressWarnings( { "unchecked", "null" } )
    public List<SyncDataElement> readDe(InputStream html )
    {
        List<SyncDataElement> items = new ArrayList<SyncDataElement>();
        try
        {
            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            XMLEventReader eventReader = inputFactory.createXMLEventReader(html);

            //      InputStream in = new FileInputStream(configFile);
            // Read the XML document
            SyncDataElement item = null;

            while ( eventReader.hasNext() )
            {
                XMLEvent event = eventReader.nextEvent();

                if ( event.isStartElement() )
                {
                    StartElement startElement = event.asStartElement();

                    if ( startElement.getName().getLocalPart() == ("dataElement") == true )
                    {

                        item = new SyncDataElement();

                        //        	  System.out.println("wasup");
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while ( attributes.hasNext() )
                        {
                            Attribute attribute = attributes.next();
                            //                    System.out.println(attribute);
                            if ( attribute.getName().toString().equals( "name" ) )
                            {
                                item.setName( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "code" ) )
                            {
                                item.setCode( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "href" ) )
                            {
                                item.setHref( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "id" ) )
                            {
                                item.setId( attribute.getValue() );
                            }

                        }

                    }

                }
                // If we reach the end of an item element we add it to the list
                if ( event.isEndElement() )
                {
                    EndElement endElement = event.asEndElement();
                    if ( endElement.getName().getLocalPart() == ("dataElement") )
                    {
                        items.add( item );
                    }
                }

            }
        }
        catch ( XMLStreamException e )
        {
            e.printStackTrace();
        }

        return items;
    }

    @SuppressWarnings( { "unchecked", "null" } )
    public List<SyncDataSet> readDS( String html )
    {
        List<SyncDataSet> items = new ArrayList<SyncDataSet>();
        try
        {
            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream stream = new ByteArrayInputStream( html.getBytes( "UTF-8" ) );

            //      InputStream in = new FileInputStream(configFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader( stream );
            // Read the XML document
            SyncDataSet item = null;

            while ( eventReader.hasNext() )
            {
                XMLEvent event = eventReader.nextEvent();

                if ( event.isStartElement() )
                {
                    StartElement startElement = event.asStartElement();

                    if ( startElement.getName().getLocalPart() == ("dataSet") == true )
                    {

                        item = new SyncDataSet();

                        //        	  System.out.println("wasup");
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while ( attributes.hasNext() )
                        {
                            Attribute attribute = attributes.next();
                            //                    System.out.println(attribute);
                            if ( attribute.getName().toString().equals( "name" ) )
                            {
                                item.setName( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "code" ) )
                            {
                                item.setCode( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "href" ) )
                            {
                                item.setHref( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "id" ) )
                            {
                                item.setId( attribute.getValue() );
                            }

                        }

                    }

                }
                // If we reach the end of an item element we add it to the list
                if ( event.isEndElement() )
                {
                    EndElement endElement = event.asEndElement();
                    if ( endElement.getName().getLocalPart() == ("dataSet") )
                    {
                        items.add( item );
                    }
                }

            }
        }
        catch ( XMLStreamException e )
        {
            e.printStackTrace();
        }
        catch ( UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        return items;
    }

    @SuppressWarnings( { "unchecked", "null" } )
    public List<SyncDisaggregation> readDisaggregation( String html )
    {
        List<SyncDisaggregation> items = new ArrayList<SyncDisaggregation>();
        try
        {
            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream stream = new ByteArrayInputStream( html.getBytes( "UTF-8" ) );

            //      InputStream in = new FileInputStream(configFile);
            XMLEventReader eventReader = inputFactory.createXMLEventReader( stream );
            // Read the XML document
            SyncDisaggregation item = null;

            while ( eventReader.hasNext() )
            {
                XMLEvent event = eventReader.nextEvent();

                if ( event.isStartElement() )
                {
                    StartElement startElement = event.asStartElement();

                    if ( startElement.getName().getLocalPart() == ("categoryCombo") == true )
                    {

                        item = new SyncDisaggregation();

                        //        	  System.out.println("wasup");
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while ( attributes.hasNext() )
                        {
                            Attribute attribute = attributes.next();
                            //                    System.out.println(attribute);
                            if ( attribute.getName().toString().equals( "name" ) )
                            {
                                item.setName( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "href" ) )
                            {
                                item.setHref( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "id" ) )
                            {
                                item.setId( attribute.getValue() );
                            }
                            if ( attribute.getName().toString().equals( "code" ) )
                            {
                                item.setCode( attribute.getValue() );
                            }
                            if ( item.code == null )
                            {
                                item.setCode( item.getId() );
                            }

                        }

                    }

                }
                // If we reach the end of an item element we add it to the list
                if ( event.isEndElement() )
                {
                    EndElement endElement = event.asEndElement();
                    if ( endElement.getName().getLocalPart() == ("categoryCombo") )
                    {
                        items.add( item );
                    }
                }

            }
        }
        catch ( XMLStreamException e )
        {
            e.printStackTrace();
        }
        catch ( UnsupportedEncodingException e )
        {
            e.printStackTrace();
        }
        return items;
    }
}
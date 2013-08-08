package com.springapp.mvc.syncmodel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class xml {






    public static void main(String args[]) {

        Date dNow = new Date( );
        Date period = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
        SimpleDateFormat pr = new SimpleDateFormat("yyyyMM") ;
        System.out.println("Complete Date: " + ft.format(dNow)) ;
        System.out.println("The period: " + pr.format(period));

        try {


            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("dataValueset");

            Attr xmlns= doc.createAttribute("xmlns");
            xmlns.setValue("http://dhis2.org/schema/dxf/2.0");
            rootElement.setAttributeNode(xmlns);

            Attr dataset= doc.createAttribute("dataSet");
            dataset.setValue("UpS2bTVcClZ");
            rootElement.setAttributeNode(dataset);

            Attr cDate= doc.createAttribute("completeDate");
            cDate.setValue(ft.format(dNow));
            rootElement.setAttributeNode(cDate);

            Attr period1 = doc.createAttribute("period");
            period1.setValue(pr.format(period));
            rootElement.setAttributeNode(period1);

            Attr orgunit= doc.createAttribute("orgUnit");
            orgunit.setValue("FzcHzyclcGl");
            rootElement.setAttributeNode(orgunit);
            doc.appendChild(rootElement);


            ////////////////////////////////////////////////////////////

            Element staff = doc.createElement("dataValue");
            rootElement.appendChild(staff);

            // set attribute to staff element
            Attr dElement = doc.createAttribute("dataElement");
            dElement.setValue("uHM6lzLXDBd");
            staff.setAttributeNode(dElement);

            staff.setAttribute("categoryOptionCombo", "wBWcFk7k1qY");
            staff.setAttribute("value", "8");

             /////////////////////////////////////////////////////////////////

            Element kip = doc.createElement("dataValue");
            rootElement.appendChild(kip);

            // set attribute to staff element
            Attr deme = doc.createAttribute("dataElement");
            deme.setValue("uHM6lzLXDBd");
            kip.setAttributeNode(deme);

            kip.setAttribute("categoryOptionCombo", "K4WLOEhtcvC");
            kip.setAttribute("value", "10");


            ///////////////////////////////////////////////////

            Element sammi =doc.createElement("dataValue");
            rootElement.appendChild(sammi);

            sammi.setAttribute("dataElement","BQmcVE8fex4");
            sammi.setAttribute("categoryOptionCombo","wBWcFk7k1qY");
            sammi.setAttribute("value","88");

            ////////////////////////////////////////////////////////////

            Element mueni =doc.createElement("dataValue");
            rootElement.appendChild(mueni);
            mueni.setAttribute("dataElement","BQmcVE8fex4");
            mueni.setAttribute("categoryOptionCombo","K4WLOEhtcvC");
            mueni.setAttribute("value","65");

            //////////////////////////////////////////



            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/dubdabasoduba/git/xmljava/test.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }


    }

}

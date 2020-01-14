package com.rr27.tskTask.utills;

import org.springframework.stereotype.Component;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

@Component
public class SimpleXmlParser {

    public HashMap<String, Integer> parsing(String filename) throws ParserConfigurationException {

        HashMap<String, Integer> hm = new HashMap<>();

        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(filename));

            while (xmlr.hasNext()){
                xmlr.next();
                if (xmlr.isStartElement()){
                    if (xmlr.getLocalName().equals("domain")){
                        xmlr.next();
                        hm.put(xmlr.getText(), hm.getOrDefault(xmlr.getText(),0)+1);
                    }
                }
            }
        }catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return hm;
    }


}

package com.rr27.tskTask.services;

import com.rr27.tskTask.utills.SimpleXmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

@Service
public class YandexAPITempDomainService {

    private SimpleXmlParser xmlParser;
    private HashMap<String, Integer> hm;

    @Autowired
    public void setXmlParser(SimpleXmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @PostConstruct
    public void init(){
        hm = new HashMap<>();
    }

    public HashMap<String, Integer> getDomainMap(String response, String filename){

        try(FileOutputStream out = new FileOutputStream(filename)){
            out.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            hm = xmlParser.parsing(filename);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return hm;
    }

}

package com.rr27.tskTask.utills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class YandexAPISender {

    private SimpleXmlParser xmlParser;

    @Autowired
    public void setXmlParser(SimpleXmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }


    public HashMap<String, Integer> send(String url) throws IOException {

        HashMap<String, Integer> hm = new HashMap<>();

        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
        urlConnection.setRequestMethod("GET");

        //из-за ограничения попыток в API пришлось оставить рабочий вариант с промежуточной записью в файл
        //а не парсить по входному потоку
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        try(FileOutputStream out = new FileOutputStream("parse.xml")){
            while ((inputLine = br.readLine()) != null) {
                out.write(inputLine.getBytes());
            }
        }
        try {
//            hm = xmlParser.parsing(urlConnection.getInputStream());
            hm = xmlParser.parsing("parse.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        for (Map.Entry x : hm.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }

        return hm;
    }
}

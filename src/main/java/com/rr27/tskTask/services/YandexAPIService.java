package com.rr27.tskTask.services;

import com.rr27.tskTask.utills.YandexAPISender;
import com.rr27.tskTask.utills.SimpleURLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YandexAPIService {

    private YandexAPISender sender;
    private SimpleURLBuilder builder;

    @Autowired
    public void setSender(YandexAPISender sender) {
        this.sender = sender;
    }

    @Autowired
    public void setBuilder(SimpleURLBuilder builder) {
        this.builder = builder;
    }


    public HashMap<String, Integer> getResponseFromAPI(List<String> query) throws IOException {

        HashMap<String, Integer> hm = new HashMap<>();
        for (String s: query) {
            try {
                //это, конечно, та еще игрушка сатаны, но помогла API не падать на 2 запросах в течении секунды
                //многопоточность решила бы эту проблему скорее всего, но я хочу уже показать результат, а для себя доделаю
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String url = builder.getURL(s);
            HashMap<String, Integer> oneQuery = sender.send(url);

            for (Map.Entry<String, Integer> x: oneQuery.entrySet()) {
                hm.put(x.getKey(), hm.getOrDefault(x.getKey(), 0)+x.getValue());
            }
        }

        return hm;
    }

}

package com.rr27.tskTask.controllers;

import com.rr27.tskTask.services.YandexAPITempDomainService;
import com.rr27.tskTask.utills.QueryResult;
import com.rr27.tskTask.utills.SimpleURLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/temp")
public class SearchTempController {

    private RestTemplate restTemplate;
    private SimpleURLBuilder builder;
    private YandexAPITempDomainService yandexService;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setBuilder(SimpleURLBuilder builder) {
        this.builder = builder;
    }

    @Autowired
    public void setYandexService(YandexAPITempDomainService yandexService) {
        this.yandexService = yandexService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<QueryResult> getRestList(@RequestParam(name = "query", required = true) List<String> query) throws IOException {

        HashMap<String, Integer> hm = new HashMap<>();

        for (String s: query) {
            String url = builder.getURL(s);
            String response = (String) restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
            HashMap<String, Integer> oneQuery = yandexService.getDomainMap(response, "parse.xml");

            for (Map.Entry<String, Integer> x: oneQuery.entrySet()) {
                hm.put(x.getKey(), hm.getOrDefault(x.getKey(), 0)+x.getValue());
            }
        }

        List<QueryResult> list = new ArrayList<>();
        for (Map.Entry<String, Integer> x: hm.entrySet()) {
            QueryResult qr = new QueryResult(x);
            list.add(qr);
        }

        return list;
    }
}

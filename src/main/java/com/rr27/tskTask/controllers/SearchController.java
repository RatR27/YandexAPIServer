package com.rr27.tskTask.controllers;

import com.rr27.tskTask.utills.QueryResult;
import com.rr27.tskTask.services.YandexAPIService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    private YandexAPIService yandexAPIService;

    @Autowired
    public void setYandexAPIService(YandexAPIService yandexAPIService) {
        this.yandexAPIService = yandexAPIService;
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<QueryResult> getList(@RequestParam (name = "query", required = true) List<String> query) throws IOException {

        HashMap<String, Integer> hm = yandexAPIService.getResponseFromAPI(query);
        List<QueryResult> list = new ArrayList<>();
        for (Map.Entry<String, Integer> x: hm.entrySet()) {
            QueryResult qr = new QueryResult(x);
            list.add(qr);
        }

        return list;
    }
}

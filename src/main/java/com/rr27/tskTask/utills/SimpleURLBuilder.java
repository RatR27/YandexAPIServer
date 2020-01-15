package com.rr27.tskTask.utills;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleURLBuilder {

    //не подтянулись значения из пропертис, но и своим данными светить не буду)
    @Value("${yandex.api.key}")
    private static String key;

    @Value("${yandex.api.user}")
    private static String user;

    private static StringBuilder url = new StringBuilder("https://yandex.com/search/xml" +
            "?l10n=en" +
            "&sortby=tm.order%3Dascending" +
            "&filter=strict" +
            "&maxpassages=1" +
            "&groupby=attr%3D%22%22.mode%3Dflat.groups-on-page%3D10.docs-in-group%3D1"+
            "&page=1");

    static {
        url.append("&user="+user);
        url.append("&key="+key);
        url.append("&query=");
    }

    public String getURL(String query){

        url.replace(url.indexOf("query=")+6, url.capacity(), query);
        System.out.println(url);

        return url.toString();
    }
}

package com.rr27.tskTask.utills;

import java.util.Map;

public class QueryResult {

    private String domain;
    private int requestQuantity;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public QueryResult(Map.Entry<String, Integer> entry) {
        this.domain = entry.getKey();
        this.requestQuantity = entry.getValue();
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "domain='" + domain + '\'' +
                ", requestQuantity=" + requestQuantity +
                '}';
    }
}

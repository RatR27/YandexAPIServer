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

    public QueryResult() {
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "domain='" + domain + '\'' +
                ", requestQuantity=" + requestQuantity +
                '}';
    }
}

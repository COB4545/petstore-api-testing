package com.petstore.testing;

public enum WebServiceEndPoints {
    ORDER("http://petstore.swagger.io/v2/store/order");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
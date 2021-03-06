package com.petstore.testing;

public enum WebServiceEndPoints {
    ORDER("https://petstore.swagger.io/v2");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

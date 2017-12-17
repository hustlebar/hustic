package com.hustlebar.hustic.util;

import org.apache.http.client.HttpClient;

public class HusticClientWrapper {
    private final HttpClient httpClient;
    private String baseUri;

    public HusticClientWrapper(HttpClient httpClient, String baseUri) {
        this.httpClient = httpClient;
        this.baseUri = baseUri;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public String getBaseUri() {
        return baseUri;
    }
}

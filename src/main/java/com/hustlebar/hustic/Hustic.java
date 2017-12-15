package com.hustlebar.hustic;

import com.hustlebar.hustic.util.HusticClientWrapper;
import org.apache.http.client.HttpClient;

public class Hustic {
    private final HusticClientWrapper hClientWrapper;

    public Hustic(HttpClient httpClient, String baseUri) {
        this.hClientWrapper = new HusticClientWrapper(httpClient, baseUri);
    }

    public void prepareGet(String index, String type) {

    }
}

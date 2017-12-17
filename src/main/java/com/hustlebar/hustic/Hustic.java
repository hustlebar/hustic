package com.hustlebar.hustic;

import com.hustlebar.hustic.get.GetRequestBuilder;
import com.hustlebar.hustic.util.HusticClientWrapper;
import org.apache.http.client.HttpClient;

public class Hustic {
    private final HusticClientWrapper wrapper;

    public Hustic(HttpClient httpClient, String baseUri) {
        this.wrapper = new HusticClientWrapper(httpClient, baseUri);
    }

    public void get(String index, String type, String id) {
        new GetRequestBuilder(wrapper)
                .build(index, type, id)
                .execute();
    }
}

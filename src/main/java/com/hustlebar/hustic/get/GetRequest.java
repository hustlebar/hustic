package com.hustlebar.hustic.get;

import com.hustlebar.hustic.base.HusticResponse;
import com.hustlebar.hustic.base.HusticResponseBuilder;
import com.hustlebar.hustic.util.HusticClientWrapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.net.URI;

public class GetRequest {
    private HusticClientWrapper wrapper;
    private String path;

    public GetRequest(HusticClientWrapper wrapper, String path) {
        this.wrapper = wrapper;
        this.path = path;
    }

    public HusticResponse execute() {
        final HttpClient client = wrapper.getHttpClient();
        HusticResponse hResponse = null;
        try {
            final HttpResponse response = client.execute(new HttpGet(this.path));
            hResponse = HusticResponseBuilder.build(response);
        } catch (IOException ioe) {

        }

        return hResponse;
    }
}

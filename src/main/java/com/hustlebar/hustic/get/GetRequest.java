package com.hustlebar.hustic.get;

import com.hustlebar.hustic.util.HusticClientWrapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

public class GetRequest {
    private HusticClientWrapper wrapper;
    private String path;

    public GetRequest(HusticClientWrapper wrapper, String path) {
        this.wrapper = wrapper;
        this.path = path;
    }

    public GetResponse execute() {
        final HttpClient client = wrapper.getHttpClient();
        GetResponse getResponse = null;
        try {
            getResponse = client.execute(new HttpGet(this.path),
                    new GetResponseHandler());
        } catch (IOException ioe) {
            //TODO: Tham
        }

        return getResponse;
    }
}

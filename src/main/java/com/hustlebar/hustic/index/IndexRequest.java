package com.hustlebar.hustic.index;

import com.hustlebar.hustic.util.HusticClientWrapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import javax.json.JsonObject;
import java.io.IOException;

public class IndexRequest {
    private HusticClientWrapper wrapper;
    private String path;
    private JsonObject data;

    public IndexRequest(HusticClientWrapper wrapper, String path, JsonObject data) {
        this.wrapper = wrapper;
        this.path = path;
        this.data = data;
    }

    public IndexResponse execute() {
        final HttpClient client = wrapper.getHttpClient();
        IndexResponse indexResponse = null;
        try {
            final HttpPut httpPut = new HttpPut(this.path);
            httpPut.setEntity(new StringEntity(this.data.toString(),
                    ContentType.APPLICATION_JSON));

            System.out.println(this.data.toString());

            indexResponse = client.execute(httpPut, new IndexResponseHandler());
        } catch (IOException ioe) {
            //TODO: Tham
        }

        return indexResponse;
    }
}

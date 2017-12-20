package com.hustlebar.hustic;

import com.hustlebar.hustic.delete.DeleteRequestBuilder;
import com.hustlebar.hustic.delete.DeleteResponse;
import com.hustlebar.hustic.get.GetRequestBuilder;
import com.hustlebar.hustic.get.GetResponse;
import com.hustlebar.hustic.index.IndexRequestBuilder;
import com.hustlebar.hustic.search.SearchRequestBuilder;
import com.hustlebar.hustic.search.SearchResponse;
import com.hustlebar.hustic.util.HusticClientWrapper;
import org.apache.http.client.HttpClient;

import javax.json.JsonObject;

/**
 * @author tham
 */

public class Hustic {
    private final HusticClientWrapper wrapper;

    public Hustic(HttpClient httpClient, String baseUri) {
        this.wrapper = new HusticClientWrapper(httpClient, baseUri);
    }

    public GetResponse get(String index, String type, String id) {
        return new GetRequestBuilder(wrapper)
                .build(index, type, id)
                .execute();
    }

    public void index(String index, String type, JsonObject data) {
        new IndexRequestBuilder(wrapper)
            .build(index, type, data)
            .execute();
    }

    public DeleteResponse delete(String index, String type, String id) {
        return new DeleteRequestBuilder(wrapper)
                .build(index, type, id)
                .execute();
    }

    public SearchResponse all(String index, String type) {
        return new SearchRequestBuilder(wrapper)
                .build(index, type, null)
                .execute();
    }

    public SearchResponse search(String index, String type, JsonObject searchJson) {
        return new SearchRequestBuilder(wrapper)
                .build(index, type, searchJson)
                .execute();
    }
}

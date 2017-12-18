package com.hustlebar.hustic.index;

import com.hustlebar.hustic.get.GetRequest;
import com.hustlebar.hustic.util.HusticClientWrapper;

import javax.json.JsonObject;

import static com.hustlebar.hustic.util.HusticUrlBuilder.buildIndex;

public class IndexRequestBuilder {
    private HusticClientWrapper wrapper;

    public IndexRequestBuilder(HusticClientWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public IndexRequest build(String index, String type, JsonObject data) {
        final String uri = buildIndex(wrapper, index, type);

        System.out.println(uri);

        final IndexRequest request = new IndexRequest(wrapper, uri, data);
        return request;
    }
}

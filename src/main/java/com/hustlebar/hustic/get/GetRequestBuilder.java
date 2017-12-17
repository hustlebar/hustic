package com.hustlebar.hustic.get;

import com.hustlebar.hustic.util.HusticClientWrapper;

import java.net.URI;

import static com.hustlebar.hustic.util.HusticUrlBuilder.buildGet;

public class GetRequestBuilder {
    private HusticClientWrapper wrapper;

    public GetRequestBuilder(HusticClientWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public GetRequest build(String index, String type, String id) {
        final String uri = buildGet(wrapper, index, type, id);

        final GetRequest request = new GetRequest(wrapper, uri);
        return request;
    }
}

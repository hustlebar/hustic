package com.hustlebar.hustic.get;

import com.hustlebar.hustic.util.HusticClientWrapper;

public class GetRequestBuilder {
    private HusticClientWrapper wrapper;

    public GetRequestBuilder(HusticClientWrapper wrapper,
                             String index, String type, String id) {
        this.wrapper = wrapper;
    }

    public GetRequest build(){
        return new GetRequest();
    }
}

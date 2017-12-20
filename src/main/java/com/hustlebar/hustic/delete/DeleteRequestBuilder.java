package com.hustlebar.hustic.delete;

import com.hustlebar.hustic.util.HusticClientWrapper;

import static com.hustlebar.hustic.util.HusticUrlBuilder.buildGet;

/**
 * @author tham
 */

public class DeleteRequestBuilder {
    private HusticClientWrapper wrapper;

    public DeleteRequestBuilder(HusticClientWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public DeleteRequest build(String index, String type, String id) {
        final String uri = buildGet(wrapper, index, type, id);

        final DeleteRequest request = new DeleteRequest(wrapper, uri);
        return request;
    }
}

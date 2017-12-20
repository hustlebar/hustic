package com.hustlebar.hustic.search;

import com.hustlebar.hustic.index.IndexRequest;
import com.hustlebar.hustic.util.HusticClientWrapper;

import javax.json.JsonObject;

import static com.hustlebar.hustic.util.HusticUrlBuilder.buildIndex;
import static com.hustlebar.hustic.util.HusticUrlBuilder.buildSearch;

/**
 * @author tham
 */

public class SearchRequestBuilder {
    private HusticClientWrapper wrapper;

    public SearchRequestBuilder(HusticClientWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public SearchRequest build(String index, String type, JsonObject searchJson) {
        final String uri = buildSearch(wrapper, index, type);

        final SearchRequest request = new SearchRequest(wrapper, uri, searchJson);
        return request;
    }
}

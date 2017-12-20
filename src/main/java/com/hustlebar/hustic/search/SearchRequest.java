package com.hustlebar.hustic.search;

import com.hustlebar.hustic.util.HusticClientWrapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import javax.json.JsonObject; /**
 * @author tham
 */

public class SearchRequest {
    private HusticClientWrapper wrapper;
    String uri;
    JsonObject searchJson;

    public SearchRequest(HusticClientWrapper wrapper, String uri,
                         JsonObject searchJson) {
        this.wrapper = wrapper;
        this.uri = uri;
        this.searchJson = searchJson;
    }

    public SearchResponse execute() {
        final HttpClient client = wrapper.getHttpClient();

        SearchResponse searchResponse = null;
        try {
            final HttpPost httpPost = new HttpPost(uri);
            searchResponse = client.execute(httpPost, new SearchResponseHandler());
        } catch (Exception ex) {
            //Handle exception
        }
        
        return searchResponse;
    }
}

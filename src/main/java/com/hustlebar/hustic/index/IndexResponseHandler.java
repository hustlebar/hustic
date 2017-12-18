package com.hustlebar.hustic.index;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;

/**
 * @author tham
 */

public class IndexResponseHandler implements ResponseHandler<IndexResponse> {
    @Override
    public IndexResponse handleResponse(HttpResponse httpResponse) throws IOException {
        System.out.println("response here: " + httpResponse.getStatusLine().getStatusCode());
        System.out.println(httpResponse.getStatusLine().getReasonPhrase());
        return null;
    }
}

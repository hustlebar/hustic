package com.hustlebar.hustic.delete;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;

/**
 * @author tham
 */

public class DeleteResponseHandler implements ResponseHandler<DeleteResponse> {

    @Override
    public DeleteResponse handleResponse(HttpResponse httpResponse) throws IOException {
        return null;
    }
}

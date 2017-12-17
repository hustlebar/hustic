package com.hustlebar.hustic.base;

import org.apache.http.HttpResponse;

/**
 * @author tham
 */

public class HusticResponseBuilder {
    public static final HusticResponse build(HttpResponse httpResponse) {
        return null;
    }

    public static final HusticResponse build(HusticException husticException) {
        final HusticResponse hResponse = new HusticResponse(500,
                "Error while communicating the server");
        hResponse.setHasException(true);
        hResponse.setException(husticException);

        return hResponse;
    }
}

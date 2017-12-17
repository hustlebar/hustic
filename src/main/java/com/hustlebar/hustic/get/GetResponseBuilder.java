package com.hustlebar.hustic.get;

import com.hustlebar.hustic.base.HusticResponse;
import org.apache.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;


/**
 * @author tham
 */

public class GetResponseBuilder {
    public static final HusticResponse build(HttpResponse httpResponse) {
        final int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            return null;
        }

        Json.createObjectBuilder().build();

        JsonbBuilder.create()
            .fromJson();
        return null;
    }
}

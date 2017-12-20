package com.hustlebar.hustic.search;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

import javax.json.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

/**
 * @author tham
 */

public class SearchResponseHandler implements ResponseHandler<SearchResponse> {
    @Override
    public SearchResponse handleResponse(HttpResponse httpResponse) throws IOException {
        final int code = httpResponse.getStatusLine().getStatusCode();
        final SearchResponse searchResponse = new SearchResponse(code);

        if (code != 200) {
            // add error into the response
            return searchResponse;
        }

        final InputStream stream = httpResponse.getEntity().getContent();
        final JsonObject responseJson = Json.createReader(stream).readObject();
        searchResponse.setDatas(getDatas(responseJson));

        return searchResponse;
    }

    private JsonArray getDatas(JsonObject responseJson) {
        final JsonObject hitsJson = responseJson.getJsonObject("hits");
        final int total = hitsJson.getInt("total");

        final JsonArrayBuilder datasBuilder = Json.createArrayBuilder();

        if (total == 0) {
            return datasBuilder.build();
        }

        final JsonArray hitsChildren = hitsJson.getJsonArray("hits");
        for (int i = 0; i < hitsChildren.size(); i++) {
            datasBuilder.add(getData(hitsChildren.getJsonObject(i)));
        }

        return datasBuilder.build();
    }

    private JsonObject getData(JsonObject responseJson) {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

        Set<Map.Entry<String, JsonValue>> entries = responseJson.getJsonObject("_source").entrySet();
        for (Map.Entry<String, JsonValue> entry : entries) {
            jsonBuilder.add(entry.getKey(), entry.getValue());
        }

        jsonBuilder.add("id", Json.createValue(responseJson.getString("_id")));

        return jsonBuilder.build();
    }
}

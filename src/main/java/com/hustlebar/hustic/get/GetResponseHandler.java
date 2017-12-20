package com.hustlebar.hustic.get;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public class GetResponseHandler implements ResponseHandler<GetResponse> {
    @Override
    public GetResponse handleResponse(HttpResponse httpResponse) throws IOException {
        int code = httpResponse.getStatusLine().getStatusCode();
        GetResponse getResponse = new GetResponse(code);
        if (code != 200) {

        }

        InputStream content = httpResponse.getEntity().getContent();
        JsonObject responseJson = Json.createReader(content).readObject();
        boolean isFound = responseJson.getBoolean("found");
        if (!isFound) {
            return getResponse;
        }

        getResponse.setData(getData(responseJson));
        return getResponse;
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

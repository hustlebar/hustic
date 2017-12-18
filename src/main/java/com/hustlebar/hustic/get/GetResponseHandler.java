package com.hustlebar.hustic.get;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;

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


        getResponse.setData(responseJson.getJsonObject("_source"));
        return getResponse;
    }
}

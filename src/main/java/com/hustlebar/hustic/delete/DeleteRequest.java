package com.hustlebar.hustic.delete;

import com.hustlebar.hustic.get.GetResponse;
import com.hustlebar.hustic.get.GetResponseHandler;
import com.hustlebar.hustic.util.HusticClientWrapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

/**
 * @author tham
 */

public class DeleteRequest {
    private HusticClientWrapper wrapper;
    private String uri;

    public DeleteRequest(HusticClientWrapper wrapper, String uri) {
        this.wrapper = wrapper;
        this.uri = uri;
    }

    public DeleteResponse execute() {
        final HttpClient client = wrapper.getHttpClient();
        DeleteResponse deleteResponse = null;
        try {
            deleteResponse = client.execute(new HttpDelete(this.uri),
                    new DeleteResponseHandler());
        } catch (IOException ioe) {
            //TODO: Tham
        }

        return deleteResponse;
    }
}

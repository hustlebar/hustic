package com.hustlebar.hustic;

import com.hustlebar.hustic.get.GetResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class HusticTest {
    private static final String BASE_PATH = "http://localhost:9200";
    private static final String ID = "1";

    @Test
    public void testGet() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Hustic hustic = new Hustic(httpClient, BASE_PATH);
        GetResponse getResponse = hustic.get("users", "user", ID);
        System.out.println(getResponse.getData());
    }
}

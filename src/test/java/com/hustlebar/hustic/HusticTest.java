package com.hustlebar.hustic;

import com.hustlebar.hustic.get.GetResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import javax.json.Json;
import java.io.StringReader;

public class HusticTest {
    private static final String BASE_PATH = "http://localhost:9200";
    private static final String ID = "1";

    private static final String indexData = "{\n" +
            "    \"name\": \"Tham\",\n" +
            "    \"email\": \"tham@gmail.com\",\n" +
            "    \"city\": \"Chennai\"\n" +
            "}";

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    @Test
    public void testGet() {
        Hustic hustic = new Hustic(httpClient, BASE_PATH);
        GetResponse getResponse = hustic.get("users", "user", ID);
        System.out.println(getResponse.getData());
    }

    @Test
    public void testIndex() {
        Hustic hustic = new Hustic(httpClient, BASE_PATH);
        hustic.index("users", "user",
                Json.createReader(new StringReader(indexData)).readObject());
    }
}

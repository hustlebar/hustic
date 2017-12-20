package com.hustlebar.hustic;

import com.hustlebar.hustic.delete.DeleteResponse;
import com.hustlebar.hustic.get.GetResponse;
import com.hustlebar.hustic.search.SearchResponse;
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

    private static final String searchData = "{\n" +
            "    \"query\": {\n" +
            "        \"match\" : {\n" +
            "            \"city\" : \"chennai\"\n" +
            "        }\n" +
            "    }\n" +
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

    @Test
    public void testDelete() {
        Hustic hustic = new Hustic(httpClient, BASE_PATH);
        final DeleteResponse deleteResponse =
                hustic.delete("users", "user", "cba2d737-efab-4c9d-93d9-825521b2fd2f");
        System.out.println("Response code: " + deleteResponse.getCode());
    }

    @Test
    public void testAll() {
        Hustic hustic = new Hustic(httpClient, BASE_PATH);
        final SearchResponse searchResponse =
                hustic.all("users", "user");
        System.out.println(searchResponse.getDatas());
    }

    @Test
    public void testSearch() {
        Hustic hustic = new Hustic(httpClient, BASE_PATH);
        final SearchResponse searchResponse =
                hustic.search("users", "user",
                        Json.createReader(
                                new StringReader(searchData)).readObject());
        System.out.println(searchResponse.getDatas());
    }
}

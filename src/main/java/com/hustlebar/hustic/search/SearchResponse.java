package com.hustlebar.hustic.search;

import javax.json.JsonArray;

/**
 * @author tham
 */

public class SearchResponse {
    private int code;
    private JsonArray datas;

    public SearchResponse(int code) {
        this(code, null);
    }

    public SearchResponse(int code, JsonArray datas) {
        this.code = code;
        this.datas = datas;
    }

    public int getCode() {
        return code;
    }

    public JsonArray getDatas() {
        return datas;
    }

    public void setDatas(JsonArray datas) {
        this.datas = datas;
    }
}

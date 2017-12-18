package com.hustlebar.hustic.index;

import javax.json.JsonObject;

public class IndexResponse {
    private int code;
    private JsonObject data;

    public IndexResponse(int code) {
        this(code, null);
    }

    public IndexResponse(int code, JsonObject data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }
}

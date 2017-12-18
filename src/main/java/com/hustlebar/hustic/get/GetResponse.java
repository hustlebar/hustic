package com.hustlebar.hustic.get;

import javax.json.JsonObject;

public class GetResponse {
    private int code;
    private JsonObject data;

    public GetResponse(int code) {
        this(code, null);
    }

    public GetResponse(int code, JsonObject data) {
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

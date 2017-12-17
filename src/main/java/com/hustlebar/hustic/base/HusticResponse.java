package com.hustlebar.hustic.base;

import com.hustlebar.hustic.base.HusticException;

/**
 * @author tham
 */

public class HusticResponse {
    private int code;
    private String response;

    private boolean hasException = false;
    private HusticException exception;

    public HusticResponse(int code, String response) {
        this.code = code;
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public String getResponse() {
        return response;
    }

    public void setHasException(boolean hasException) {
        this.hasException = hasException;
    }

    public boolean hasException() {
        return hasException;
    }

    public void setException(HusticException exception) {
        this.exception = exception;
    }

    public HusticException getException() {
        return exception;
    }
}

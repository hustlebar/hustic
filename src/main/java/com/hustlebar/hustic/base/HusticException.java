package com.hustlebar.hustic.base;

public class HusticException extends Exception {
    private int code = 500;

    public HusticException() {
        super("Error while communicating to the server");
    }

    public HusticException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

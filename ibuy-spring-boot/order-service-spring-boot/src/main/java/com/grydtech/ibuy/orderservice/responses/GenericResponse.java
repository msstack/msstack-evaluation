package com.grydtech.ibuy.orderservice.responses;

public class GenericResponse {
    private int status;
    private String message;

    public GenericResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

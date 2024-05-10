package com.jasi.rentagame.dto;

import lombok.Data;

@Data
public class ApiResponse {
    private Meta meta;
    private Object data;

    public ApiResponse(String message, Object data) {
        this.meta = new Meta(message);
        this.data = data;
    }
}

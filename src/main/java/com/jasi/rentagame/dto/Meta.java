package com.jasi.rentagame.dto;

import java.text.SimpleDateFormat;

import lombok.Data;

@Data
public class Meta {
    private String timestamp;
    private String message;

    public Meta(String message) {
        this.timestamp = new SimpleDateFormat("HH:mm:ss dd:MM:YYYY").format(System.currentTimeMillis());
        this.message = message;
    }
}

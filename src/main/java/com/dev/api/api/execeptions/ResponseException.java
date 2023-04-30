package com.dev.api.api.execeptions;

import java.time.LocalDate;

public class ResponseException {
    private LocalDate timestamp;
    private String message;
    private String details;

    public ResponseException() {
    }

    public ResponseException(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}

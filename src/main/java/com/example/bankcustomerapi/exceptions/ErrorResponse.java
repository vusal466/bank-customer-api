package com.example.bankcustomerapi.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        Object errors,
        LocalDateTime timestamp
) {
    public ErrorResponse(int status, String message, LocalDateTime timestamp) {
        this(status, message, null, timestamp);
    }
}
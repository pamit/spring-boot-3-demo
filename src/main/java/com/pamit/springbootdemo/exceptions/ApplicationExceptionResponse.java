package com.pamit.springbootdemo.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ApplicationExceptionResponse {
    private String details;
    private List<String> messages;
    private LocalDateTime timestamp;

    public ApplicationExceptionResponse(String details, List<String> messages, LocalDateTime timestamp) {
        this.details = details;
        this.messages = messages;
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> message) {
        this.messages = messages;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

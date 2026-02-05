package com.notificationSystem.NotificationSystem.dto;

public class NotificationRequest {
    java.lang.String message;
    String type;

    public java.lang.String getMessage() {
        return message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public NotificationRequest(java.lang.String message, String type) {
        this.message = message;
        this.type = type;
    }
}

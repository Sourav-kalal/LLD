package com.notificationSystem.NotificationSystem.dto;

public class NotificationResponse {
    String type;
    String status;
    String ErrorMessage;

    public NotificationResponse(String type, String status, String errorMessage) {
        this.type = type;
        this.status = status;
        this.ErrorMessage = errorMessage;
    }
    public NotificationResponse(String type, String status) {
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

}

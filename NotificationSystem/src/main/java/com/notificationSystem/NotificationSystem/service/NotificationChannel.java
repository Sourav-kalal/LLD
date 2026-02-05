package com.notificationSystem.NotificationSystem.service;

import com.notificationSystem.NotificationSystem.dto.NotificationRequest;

public interface NotificationChannel {
    Boolean supports(String type);
    String notify(NotificationRequest notificationRequest);
}

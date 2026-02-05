package com.notificationSystem.NotificationSystem.service.notificationChannels;

import com.notificationSystem.NotificationSystem.dto.NotificationRequest;
import com.notificationSystem.NotificationSystem.service.NotificationChannel;
import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements NotificationChannel {
    @Override
    public Boolean supports(String type) {
        return "SMS".equalsIgnoreCase(type);
    }

    @Override
    public String notify(NotificationRequest notificationRequest) {
        return "SMS sent";
    }
}

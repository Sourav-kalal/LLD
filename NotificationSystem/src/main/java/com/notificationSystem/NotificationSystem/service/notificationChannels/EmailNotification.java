package com.notificationSystem.NotificationSystem.service.notificationChannels;

import com.notificationSystem.NotificationSystem.dto.NotificationRequest;
import com.notificationSystem.NotificationSystem.service.NotificationChannel;
import org.springframework.stereotype.Component;

import java.lang.String;

@Component
public class EmailNotification implements NotificationChannel {

    @Override
    public Boolean supports(String type) {
        return  "Email".equalsIgnoreCase(type);
    }

    @Override
    public String notify(NotificationRequest notificationRequest) {
        return "Email sent";
    }
}

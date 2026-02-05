package com.notificationSystem.NotificationSystem.service.notificationChannels;

import com.notificationSystem.NotificationSystem.dto.NotificationRequest;
import com.notificationSystem.NotificationSystem.service.NotificationChannel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationSelector {

    List<NotificationChannel> notificationChannels;
    public  NotificationSelector(List<NotificationChannel> notificationChannelList) {
        this.notificationChannels = notificationChannelList;
    }

    public NotificationChannel select(String type) {
        return this.notificationChannels.stream()
                .filter(c -> c.supports(type))
                .findFirst()
                .orElse(null);
    }
}

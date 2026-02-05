package com.notificationSystem.NotificationSystem.service;

import com.notificationSystem.NotificationSystem.dto.NotificationRequest;
import com.notificationSystem.NotificationSystem.dto.NotificationResponse;
import com.notificationSystem.NotificationSystem.service.notificationChannels.NotificationSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    NotificationSelector notificationSelector;

    NotificationServiceImpl(NotificationSelector notificationSelector) {
        this.notificationSelector = notificationSelector;
    }


    @Override
    public List<NotificationResponse> send(List<NotificationRequest> notificationRequests) {
        List<NotificationResponse> response = new ArrayList<>();
        for (NotificationRequest notificationRequest : notificationRequests) {
            NotificationChannel notificationChannel = notificationSelector.select(notificationRequest.getType());
            if (notificationChannel != null) {
                NotificationResponse successNotification = new NotificationResponse(notificationRequest.getType(),"SUCCESS");
                response.add(successNotification);
            }else{
                NotificationResponse noChannelNotificationRequest = new NotificationResponse(notificationRequest.getType(),"FAILURE","No Channel found");
                response.add(noChannelNotificationRequest);
            }
        }
        return response;
    }
}

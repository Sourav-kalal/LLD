package com.notificationSystem.NotificationSystem.service;

import com.notificationSystem.NotificationSystem.dto.NotificationRequest;
import com.notificationSystem.NotificationSystem.dto.NotificationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {
    public List<NotificationResponse> send(List<NotificationRequest> notificationRequests);
}

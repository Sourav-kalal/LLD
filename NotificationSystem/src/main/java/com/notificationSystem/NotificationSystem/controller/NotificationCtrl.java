package com.notificationSystem.NotificationSystem.controller;

import com.notificationSystem.NotificationSystem.dto.NotificationRequest;
import com.notificationSystem.NotificationSystem.dto.NotificationResponse;
import com.notificationSystem.NotificationSystem.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationCtrl {

    NotificationService notificationService;

    public NotificationCtrl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @PostMapping("/send")
    @ResponseBody
    public ResponseEntity<List<NotificationResponse>> sendAllNotifications(@RequestBody List<NotificationRequest> notificationRequests) {
        List<NotificationResponse> response = notificationService.send(notificationRequests);
        return new ResponseEntity<>( response, HttpStatus.OK);
    }

}

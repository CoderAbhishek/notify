package com.avinod.settingsmodule.controller;

import com.avinod.settingsmodule.entity.Notifications;
import com.avinod.settingsmodule.entity.User;
import com.avinod.settingsmodule.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    public NotificationController() {
    }

//    @GetMapping("/all")
//    public List<Notifications> getAllNotifications() {
//        return this.notificationService.getAllNotifications();
//    }

    @GetMapping("/user/{id}")
    public List<Notifications> getNotificationsByUserId(@PathVariable(value = "id") int userId){
        return this.notificationService.getNotificationsByUserId(userId);
    }

    @PostMapping("/add/{id}")
    public User createNotification(@PathVariable(value = "id") int userId, @RequestBody Notifications notification){
        return this.notificationService.createNotification(userId, notification);
    }

    @PutMapping("/{id}")
    public Notifications updateNotification(@RequestBody Notifications notification, @PathVariable (value = "id") int notificationId){
        return this.notificationService.updateNotification(notification, notificationId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notifications> deleteNotification(@PathVariable ("id") int userId){
        return this.notificationService.deleteNotification(userId);
    }
}

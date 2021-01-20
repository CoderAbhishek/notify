package com.avinod.settingsmodule.service;

import com.avinod.settingsmodule.entity.Notifications;
import com.avinod.settingsmodule.entity.User;
import com.avinod.settingsmodule.exception.ResourceNotFoundException;
import com.avinod.settingsmodule.repository.NotificationRepository;
import com.avinod.settingsmodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    public NotificationService() {
    }

//    public List<Notifications> getAllNotifications(){
//        return this.notificationRepository.findAll();
//    }

//    public Notifications getNotificationsByUserId(int userId){
//        return this.notificationRepository
//                .findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+userId));
//    }
    public List<Notifications> getNotificationsByUserId(int userId){
        User user = this.userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+userId));
        return user.getNotifications();
    }

//    public Notifications createNotification(Notifications notification){
//        return this.notificationRepository.save(notification);
//    }
    public User createNotification(int userId, Notifications notification){
        User user = this.userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+userId));
        user.getNotifications().add(userId,notification);
        return this.userRepository.save(user);
//        return this.notificationRepository.save(notification);
    }

    public Notifications updateNotification(Notifications notification, int notificationId){
        Notifications currentNotification = this.notificationRepository
                .findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
        currentNotification.setRead(notification.isRead());
        return this.notificationRepository.save(currentNotification);
    }

//    public ResponseEntity<Notifications> deleteNotification(int notificationId){
//        Notifications currentNotification = this.notificationRepository
//                .findById(notificationId)
//                .orElseThrow(() -> new ResourceNotFoundException("Notification not found"));
//        this.notificationRepository.delete(currentNotification);
//        return ResponseEntity.ok().build();
//    }
    public ResponseEntity<Notifications> deleteNotification(int userId){
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+userId));
        user.getNotifications().clear();
        this.userRepository.save(user);
        return ResponseEntity.ok().build();
    }

}

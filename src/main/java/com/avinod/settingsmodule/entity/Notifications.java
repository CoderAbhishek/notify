package com.avinod.settingsmodule.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notificationId")
    private int notificationId;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "description")
    private String message;

    @Column(name = "is_read")
    private boolean isRead;

    @Column(name = "created_at")
    private Date createdAt;

    public Notifications() {
    }

    public Notifications(User user, String message, Date createdAt) {
        this.user = user;
        this.message = message;
        this.createdAt = createdAt;
        this.isRead = false;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

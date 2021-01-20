package com.avinod.settingsmodule.repository;

import com.avinod.settingsmodule.entity.Notifications;
import com.avinod.settingsmodule.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications, Integer> {

    Notifications findByUser(User user);
}

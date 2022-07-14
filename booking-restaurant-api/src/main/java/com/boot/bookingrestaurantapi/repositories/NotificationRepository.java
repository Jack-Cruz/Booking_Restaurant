package com.boot.bookingrestaurantapi.repositories;

import com.boot.bookingrestaurantapi.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findByTemplateCode(String templateCode);
}

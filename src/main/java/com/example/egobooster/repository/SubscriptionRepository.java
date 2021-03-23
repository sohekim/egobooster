package com.example.egobooster.repository;

import com.example.egobooster.domain.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

 boolean existsByEmail(String email);
}

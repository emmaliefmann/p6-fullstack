package com.openclassrooms.mddapi.repositories;

import com.openclassrooms.mddapi.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}

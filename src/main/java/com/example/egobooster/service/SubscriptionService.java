package com.example.egobooster.service;

import com.example.egobooster.domain.dto.SubscriptionDto;
import com.example.egobooster.domain.entity.Subscription;
import java.util.List;

public interface SubscriptionService {

  boolean save(SubscriptionDto dto);

  List<Subscription> findAll();

}

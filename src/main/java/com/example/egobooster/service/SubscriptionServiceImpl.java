package com.example.egobooster.service;

import com.example.egobooster.domain.converter.SubscriptionConverter;
import com.example.egobooster.domain.dto.SubscriptionDto;
import com.example.egobooster.repository.SubscriptionRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

  final SubscriptionRepository subscriptionRepository;

  @Override
  public boolean save(SubscriptionDto dto) {
    if (subscriptionRepository.existsByEmail(dto.getEmail())) {
      return false;
    }
    dto.setUpdateDate(LocalDateTime.now());
    subscriptionRepository.save(SubscriptionConverter.ofDto(dto));
    return true;
  }
}

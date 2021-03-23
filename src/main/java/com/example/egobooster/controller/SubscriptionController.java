package com.example.egobooster.controller;

import com.example.egobooster.domain.dto.SubscriptionDto;
import com.example.egobooster.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

  final SubscriptionService subscriptionService;

  @PostMapping
  public ResponseEntity<String> save(@RequestBody SubscriptionDto subscriptionDto) {
    if (!subscriptionService.save(subscriptionDto)) {
      return new ResponseEntity<>("subscription already exist", HttpStatus.SEE_OTHER);
    } else {
      return new ResponseEntity<>("subscription saved", HttpStatus.CREATED);
    }
  }

}

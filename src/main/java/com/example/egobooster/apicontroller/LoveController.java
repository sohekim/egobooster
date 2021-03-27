package com.example.egobooster.apicontroller;

import com.example.egobooster.domain.redis.RedisLove;
import com.example.egobooster.service.LoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/love")
public class LoveController {

  final LoveService loveService;

  @PutMapping
  public ResponseEntity<RedisLove> save() {
    RedisLove love = loveService.love();
    return new ResponseEntity<>(love, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Integer> getCount() {
    return new ResponseEntity<>(loveService.getCount(), HttpStatus.OK);
  }

}

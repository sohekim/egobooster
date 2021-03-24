package com.example.egobooster.controller;

import com.example.egobooster.domain.redis.RedisBatch;
import com.example.egobooster.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/batch")
public class BatchController {

  final BatchService batchService;

  @PutMapping("/increment")
  public ResponseEntity<RedisBatch> executeBatch() {
    RedisBatch redisBatch = batchService.executeBatch();
    return new ResponseEntity<>(redisBatch, HttpStatus.OK);
  }

  @GetMapping("/count")
  public ResponseEntity<Integer> getBatchNum() {
    return new ResponseEntity<>(batchService.getCount(), HttpStatus.OK);
  }

  @PutMapping("/clear")
  public ResponseEntity<Integer> clearBatch() {
    batchService.clear();
    return new ResponseEntity<>(batchService.getCount(), HttpStatus.OK);
  }

}

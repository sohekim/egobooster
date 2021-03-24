package com.example.egobooster.service;

import com.example.egobooster.domain.redis.RedisBatch;

public interface BatchService {

  RedisBatch executeBatch();

  Integer getCount();

  void clear();

}

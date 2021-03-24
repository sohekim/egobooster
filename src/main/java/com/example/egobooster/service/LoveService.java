package com.example.egobooster.service;
import com.example.egobooster.domain.redis.RedisLove;

public interface LoveService {

  RedisLove love();

  int getCount();

}

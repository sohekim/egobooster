package com.example.egobooster.service;

import com.example.egobooster.domain.redis.RedisLove;
import com.example.egobooster.repository.LoveRedisRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoveServiceImpl implements LoveService {

  final LoveRedisRepository loveRedisRepository;

  @Override
  public RedisLove love() {
    Optional<RedisLove> optionalLove = loveRedisRepository.findById(1L);
    if (optionalLove.isEmpty()) {
      loveRedisRepository.save(new RedisLove(1L, 1));
      optionalLove = loveRedisRepository.findById(1L);
    }
    RedisLove love = optionalLove.get();
    love.setCount(love.getCount() + 1);
    loveRedisRepository.save(love);
    return love;
  }

  @Override
  public int getCount() {
    Optional<RedisLove> optionalLove = loveRedisRepository.findById(1L);
    if (optionalLove.isEmpty()) {
      loveRedisRepository.save(new RedisLove(1L, 1));
    } else {
      RedisLove love = optionalLove.get();
      return love.getCount();
    }
    return 0;
  }
}

package com.example.egobooster.service;

import com.example.egobooster.domain.redis.RedisBatch;
import com.example.egobooster.repository.BatchRedisRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

  final BatchRedisRepository batchRedisRepository;

  private RedisBatch addBatchIfNotExist() {
    Optional<RedisBatch> optionalBatchNum = batchRedisRepository.findById(1L);
    if (optionalBatchNum.isEmpty()) {
      batchRedisRepository.save(new RedisBatch(1L, 1));
      optionalBatchNum = batchRedisRepository.findById(1L);
    }
    if (optionalBatchNum.get().getCount() == null) {
      optionalBatchNum.get().setCount(0);
    }

    return optionalBatchNum.get();
  }

  @Override
  public RedisBatch executeBatch() {
    RedisBatch redisBatch = addBatchIfNotExist();
    redisBatch.setCount(redisBatch.getCount() + 1);
    batchRedisRepository.save(redisBatch);
    return redisBatch;
  }

  @Override
  public RedisBatch setBatch(Integer num) {
    RedisBatch redisBatch = addBatchIfNotExist();
    redisBatch.setCount(num);
    batchRedisRepository.save(redisBatch);
    return redisBatch;
  }

  @Override
  public Integer getCount() {
    Optional<RedisBatch> optionalRedisBatch = batchRedisRepository.findById(1L);
    if (optionalRedisBatch.isPresent()) {
      RedisBatch redisBatch = optionalRedisBatch.get();
      return redisBatch.getCount();
    }
    return 0;
  }

  @Override
  public void clear() {
    Optional<RedisBatch> optionalRedisBatch = batchRedisRepository.findById(1L);
    if (optionalRedisBatch.isPresent()) {
      RedisBatch redisBatch = optionalRedisBatch.get();
      redisBatch.setCount(1);
      batchRedisRepository.save(redisBatch);
    }
  }
}

package com.example.egobooster.repository;

import com.example.egobooster.domain.redis.RedisBatch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRedisRepository extends CrudRepository<RedisBatch, Long> {

}

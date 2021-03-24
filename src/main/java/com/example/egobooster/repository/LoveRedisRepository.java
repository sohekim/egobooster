package com.example.egobooster.repository;

import com.example.egobooster.domain.redis.RedisLove;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoveRedisRepository extends CrudRepository<RedisLove, Long> {

}

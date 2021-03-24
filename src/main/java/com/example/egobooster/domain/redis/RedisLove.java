package com.example.egobooster.domain.redis;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("love")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RedisLove {

  @Id
  private Long id;
  private Integer count;

}

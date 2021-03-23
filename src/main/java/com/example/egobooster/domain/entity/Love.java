package com.example.egobooster.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "love")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Love {

  // 1. 굳이 얘를 entity 로 빼 ? 근데 안빼면 대안이 모지 Sohee entity?
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  private Integer count;
}

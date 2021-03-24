package com.example.egobooster.domain.entity;

import com.example.egobooster.domain.dto.SubscriptionDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "subscription")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String email;
  private LocalDateTime updateDate;

  protected Subscription(SubscriptionDto dto) {
    this.email = dto.getEmail();
    this.updateDate = dto.getUpdateDate();
  }

  public static Subscription ofDto(SubscriptionDto dto) {
    return new Subscription(dto);
  }

}

package com.example.egobooster.domain.dto;

import com.example.egobooster.domain.entity.Subscription;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubscriptionDto {

  private Long id;
  private String email;
  private LocalDateTime updateDate;

  protected SubscriptionDto(Subscription entity) {
    this.id = entity.getId();
    this.email = entity.getEmail();
    this.updateDate = entity.getUpdateDate();
  }

  public static SubscriptionDto ofEntity (Subscription entity) {
    return new SubscriptionDto(entity);
  }
}

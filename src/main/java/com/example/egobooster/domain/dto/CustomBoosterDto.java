package com.example.egobooster.domain.dto;

import com.example.egobooster.domain.entity.Booster;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomBoosterDto {

  private Long id;
  private String text;
  private LocalDateTime updateDate;
  private String gifter;
  private String giftee;

  public CustomBoosterDto(Booster entity) {
    this.id = entity.getId();
    this.text = entity.getText();
    this.updateDate = entity.getUpdateDate();
    this.gifter = null;
    this.giftee = null;
  }

  public static CustomBoosterDto ofEntity(Booster entity) {
    return new CustomBoosterDto(entity);
  }

}
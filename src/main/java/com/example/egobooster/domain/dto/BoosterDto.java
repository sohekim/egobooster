package com.example.egobooster.domain.dto;

import com.example.egobooster.domain.entity.Booster;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoosterDto {

  private Long id;
  private String text;
  private LocalDateTime updateDate;

  public BoosterDto(Booster entity) {
    this.id = entity.getId();
    this.text = entity.getText();
    this.updateDate = entity.getUpdateDate();
  }

  public static BoosterDto ofEntity(Booster entity) {
    return new BoosterDto(entity);
  }

}
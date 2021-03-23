package com.example.egobooster.domain.dto;

import com.example.egobooster.domain.entity.Love;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoveDto {

  private Integer count;

  protected LoveDto(Love entity) {
    this.count = entity.getCount();
  }

  public static LoveDto ofEntity(Love entity) {
    return new LoveDto(entity);
  }

}

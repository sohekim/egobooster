package com.example.egobooster.domain.entity;

import com.example.egobooster.domain.dto.BoosterDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "booster")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Booster {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String text;
  private LocalDateTime updateDate;

  protected Booster(BoosterDto boosterDto) {
    this.text = boosterDto.getText();
    this.updateDate = boosterDto.getUpdateDate();
  }

  public static Booster ofDto(BoosterDto boosterDto) {
    return new Booster(boosterDto);
  }
}

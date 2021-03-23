package com.example.egobooster.domain.converter;

import com.example.egobooster.common.BaseConverter;
import com.example.egobooster.domain.dto.BoosterDto;
import com.example.egobooster.domain.entity.Booster;
import java.util.Collection;
import java.util.List;

public class BoosterConverter extends BaseConverter<BoosterDto, Booster> {

  public BoosterConverter() {
    super(Booster::ofDto, BoosterDto::ofEntity);
  }

  public static BoosterDto ofEntity(Booster booster) {
    BoosterConverter boosterConverter = new BoosterConverter();
    return boosterConverter.convertFromEntity(booster);
  }

  public static Booster ofDto(BoosterDto boosterDto) {
    BoosterConverter boosterConverter = new BoosterConverter();
    return boosterConverter.convertFromDto(boosterDto);
  }

  public static List<BoosterDto> ofEntities(Collection<Booster> boosters) {
    BoosterConverter boosterConverter = new BoosterConverter();
    return boosterConverter.convertFromEntities(boosters);
  }

  public static List<Booster> ofDtos(Collection<BoosterDto> boosterDtos) {
    BoosterConverter boosterConverter = new BoosterConverter();
    return boosterConverter.convertFromDtos(boosterDtos);
  }
}

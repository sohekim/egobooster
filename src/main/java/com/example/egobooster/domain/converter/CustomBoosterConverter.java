package com.example.egobooster.domain.converter;

import com.example.egobooster.common.BaseConverter;
import com.example.egobooster.domain.dto.CustomBoosterDto;
import com.example.egobooster.domain.entity.Booster;

public class CustomBoosterConverter extends BaseConverter<CustomBoosterDto, Booster> {

  public CustomBoosterConverter() {
    super(null, CustomBoosterDto::ofEntity);
  }

  public static CustomBoosterDto ofEntity(Booster booster) {
    CustomBoosterConverter customBoosterConverter = new CustomBoosterConverter();
    return customBoosterConverter.convertFromEntity(booster);
  }

}

package com.example.egobooster.domain.converter;

import com.example.egobooster.common.BaseConverter;
import com.example.egobooster.domain.dto.LoveDto;
import com.example.egobooster.domain.entity.Love;

public class LoveConverter extends BaseConverter<LoveDto, Love> {

  public LoveConverter() {
    super(null, LoveDto::ofEntity);
  }

  public static LoveDto ofEntity(Love love) {
    LoveConverter loveConverter = new LoveConverter();
    return loveConverter.convertFromEntity(love);
  }

}
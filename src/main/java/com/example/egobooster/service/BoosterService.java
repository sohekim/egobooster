package com.example.egobooster.service;

import com.example.egobooster.domain.dto.BoosterDto;
import com.example.egobooster.domain.entity.Booster;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface BoosterService {

  Page<Booster> findBoosters(Integer page, Integer size);

  Integer getBoosterCount();

  Optional<Booster> findBoosterById(Long id);

  Page<Booster> findBoostersByKeyword(String keyword, Integer page, Integer size);

  boolean save(BoosterDto dto);

  String personalize(String boosterText, String giftee);

}

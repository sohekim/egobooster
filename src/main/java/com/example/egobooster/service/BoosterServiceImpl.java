package com.example.egobooster.service;

import com.example.egobooster.domain.converter.BoosterConverter;
import com.example.egobooster.domain.dto.BoosterDto;
import com.example.egobooster.domain.entity.Booster;
import com.example.egobooster.repository.BoosterRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoosterServiceImpl implements BoosterService {

  final BoosterRepository boosterRepository;

  @Override
  public Page<Booster> findBoosters(Integer page, Integer size) {
    return boosterRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Integer getBoosterCount() {
    return boosterRepository.countByIdGreaterThanEqual(1L);
  }

  @Override
  public Optional<Booster> findBoosterById(Long id) {
    return boosterRepository.findById(id);
  }

  @Override
  public Page<Booster> findBoostersByKeyword(String keyword, Integer page, Integer size) {
    return boosterRepository.findAllByTextContaining(keyword, PageRequest.of(page, size));
  }

  @Override
  public boolean save(BoosterDto boosterDto) {
    if (boosterRepository.existsByText(boosterDto.getText())) {
      return false;
    }
    boosterDto.setUpdateDate(LocalDateTime.now());
    boosterRepository.save(BoosterConverter.ofDto(boosterDto));
    return true;
  }

  @Override
  public String personalize(String boosterText, String giftee) {
    if (!giftee.equals("")) {
      boosterText = boosterText.replaceAll("you ", giftee + " ");
      boosterText = boosterText.replaceAll("your ", giftee + "'s ");
    }
    return boosterText;
  }
}

package com.example.egobooster.controller;

import com.example.egobooster.domain.converter.BoosterConverter;
import com.example.egobooster.domain.converter.CustomBoosterConverter;
import com.example.egobooster.domain.dto.BoosterDto;
import com.example.egobooster.domain.dto.CustomBoosterDto;
import com.example.egobooster.domain.entity.Booster;
import com.example.egobooster.service.BoosterService;
import com.sun.istack.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boosters")
public class BoosterController {

  final BoosterService boosterService;

  @PostMapping
  public ResponseEntity<String> save(@RequestBody BoosterDto boosterDto) {
    if (!boosterService.save(boosterDto)) {
      return new ResponseEntity<>("booster already exists", HttpStatus.SEE_OTHER);
    }
    return new ResponseEntity<>("booster saved", HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BoosterDto> findBoosterById(@PathVariable(value = "id") Long id) {
    Optional<Booster> booster = boosterService.findBoosterById(id);
    if (booster.isEmpty()) {
      return new ResponseEntity("booster not found", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(BoosterConverter.ofEntity(booster.get()), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<BoosterDto>> findBoosters(
      @RequestParam(required = false, value = "keyword") String keyword,
      @RequestParam(required = false, defaultValue = "0") Integer page,
      @RequestParam(required = false, defaultValue = "10") Integer size
  ) {
    try {
      Page<Booster> boosterPage;
      if (keyword != null) {
        boosterPage = boosterService.findBoostersByKeyword(keyword, page, size);
      } else {
        boosterPage = boosterService.findBoosters(page, size);
      }
      if (boosterPage.isEmpty()) {
        throw new Exception();
      }
      List<Booster> boosters = boosterPage.getContent();
      return new ResponseEntity<>(BoosterConverter.ofEntities(boosters),
          HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity("booster not found", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/random")
  public ResponseEntity<BoosterDto> findRandomBooster() {
    for (int i = 0; i < 50; i++) {
      Integer count = boosterService.getBoosterCount();
      Integer randomNum = ThreadLocalRandom.current().nextInt(1, count + 1);
      Optional<Booster> booster = boosterService.findBoosterById(Long.valueOf(randomNum));
      if (booster.isPresent()) {
        return new ResponseEntity<>(BoosterConverter.ofEntity(booster.get()), HttpStatus.OK);
      }
    }
    return new ResponseEntity("booster not found", HttpStatus.NOT_FOUND);
  }

  @GetMapping("/{id}/personalize")
  public ResponseEntity<CustomBoosterDto> findCustomBooster(@PathVariable(value = "id") Long id,
      @RequestParam(value = "giftee", defaultValue = "") @Nullable String giftee,
      @RequestParam(value = "gifter", defaultValue = "") @Nullable String gifter) {
    Optional<Booster> booster = boosterService.findBoosterById(id);
    if (booster.isEmpty()) {
      return new ResponseEntity("booster not found", HttpStatus.NOT_FOUND);
    }
    CustomBoosterDto customBoosterDto = CustomBoosterConverter.ofEntity(booster.get());
    customBoosterDto.setText(boosterService.personalize(customBoosterDto.getText(), giftee));
    customBoosterDto.setGifter(gifter);
    return new ResponseEntity<>(customBoosterDto,
        HttpStatus.OK);
  }
}

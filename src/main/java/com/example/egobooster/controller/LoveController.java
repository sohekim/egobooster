package com.example.egobooster.controller;

import com.example.egobooster.domain.converter.LoveConverter;
import com.example.egobooster.domain.dto.BoosterDto;
import com.example.egobooster.domain.dto.LoveDto;
import com.example.egobooster.domain.entity.Love;
import com.example.egobooster.service.LoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/love")
public class LoveController {

  final LoveService loveService;

  @PutMapping
  public ResponseEntity<LoveDto> save() {
    Love love = loveService.love();
    return new ResponseEntity<LoveDto>(LoveConverter.ofEntity(love), HttpStatus.OK);
  }

}

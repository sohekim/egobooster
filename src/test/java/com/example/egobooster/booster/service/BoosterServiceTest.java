package com.example.egobooster.booster.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.example.egobooster.domain.entity.Booster;
import com.example.egobooster.repository.BoosterRepository;
import com.example.egobooster.service.BoosterServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@ExtendWith(MockitoExtension.class)
public class BoosterServiceTest {

  @Mock
  private BoosterRepository boosterRepository;

  @InjectMocks
  private BoosterServiceImpl boosterService;

  private Booster booster;
  private Page<Booster> boosterPage;

  @BeforeEach
  public void setup(TestInfo testInfo) {
    if ("findBoosterByIdTest".equals(testInfo.getDisplayName())) {
      initIdTest(testInfo);
    } else if ("findBoosters".equals(testInfo.getDisplayName())) {
      initListTest(testInfo);
    }
  }


  private void initIdTest(TestInfo testInfo) {
    booster = Booster.builder().text("testing").build();
  }

  private void initListTest(TestInfo testInfo) {
    booster = Booster.builder().text("testing").build();
    Booster booster2 = Booster.builder().text("testing2").build();
    List<Booster> boosterList = new ArrayList<>();
    boosterList.add(booster);
    boosterList.add(booster2);
    boosterPage = new PageImpl<>(boosterList);
  }

  @Test
  @DisplayName("findBoosterByIdTest")
  public void findBoosterByIdTest() {
    when(boosterRepository.findById(anyLong())).thenReturn(Optional.of(booster));
    Booster booster = boosterService.findBoosterById(anyLong()).get();
    Assertions.assertEquals(booster.getText(), "testing");
  }

  @Test
  @DisplayName("findBoosters")
  public void findBoosters() {
    when(boosterRepository.findAll(PageRequest.of(1, 1))).thenReturn(boosterPage);
    Page<Booster> boosterServicePage = boosterService.findBoosters(1, 1);
    Assertions.assertEquals(boosterPage.getTotalElements(), boosterServicePage.getTotalElements());
  }

}

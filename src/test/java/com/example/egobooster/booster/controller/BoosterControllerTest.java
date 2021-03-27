package com.example.egobooster.booster.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.egobooster.apicontroller.BoosterController;
import com.example.egobooster.domain.entity.Booster;
import com.example.egobooster.service.BoosterServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BoosterController.class)
public class BoosterControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  BoosterServiceImpl boosterService;

  @DisplayName("Find Booster by Id Test Success")
  @Test
  public void findBoosterByIdSuccessTest() throws Exception {
    Booster booster = Booster.builder().text("testing").build();
    given(boosterService.findBoosterById(anyLong())).willReturn(Optional.of(booster));
    mockMvc.perform(get("/api/v1/boosters/1")).andDo(print()).andExpect(status().isOk());
  }

  @DisplayName("Find Booster by Id Test Fail")
  @Test
  public void findBoosterByIdFailTest() throws Exception {
    given(boosterService.findBoosterById(anyLong())).willReturn(Optional.empty());
    mockMvc.perform(get("/api/v1/boosters/1")).andDo(print()).andExpect(status().isNotFound());
  }

}

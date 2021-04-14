package com.example.egobooster.apicontroller;

import com.example.egobooster.service.BatchService;
import com.example.egobooster.service.BoosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/batch")
public class BatchController {

  final BatchService batchService;
  final BoosterService boosterService;

  @PutMapping("/set")
  public ResponseEntity setBatchNum(
      @RequestParam(value = "num") Integer num
  ) {
    batchService.setBatch(num);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Integer> getBatchNum() {
    Integer batchCount = batchService.getCount();
    Long lastId = boosterService.getLastBoosterId();

    if (batchCount > lastId) {
      batchService.clear();
      return new ResponseEntity<>(batchService.getCount(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(batchCount, HttpStatus.OK);
    }
  }

  @PutMapping("/clear")
  public ResponseEntity clearBatch() {
    batchService.clear();
    return new ResponseEntity(HttpStatus.OK);
  }

}

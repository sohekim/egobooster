package com.example.egobooster.apicontroller;

import com.example.egobooster.service.BatchService;
import com.example.egobooster.service.BoosterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/batch")
public class BatchController {

  final BatchService batchService;
  final BoosterService boosterService;

  @Value("${key}")
  private String myKey;

  @PutMapping("/set")
  public ResponseEntity setBatchNum(@RequestHeader("key") String key,
      @RequestParam(value = "num") Integer num
  ) {

    if (!myKey.equals(key)) {
      return new ResponseEntity<>("Ooops permission denied", HttpStatus.FORBIDDEN);
    }

    batchService.setBatch(num);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Integer> getBatchNum(@RequestHeader("key") String key) {

    if (!myKey.equals(key)) {
      return new ResponseEntity("Ooops permission denied", HttpStatus.FORBIDDEN);
    }

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
  public ResponseEntity clearBatch(@RequestHeader("key") String key) {

    if (!myKey.equals(key)) {
      return new ResponseEntity<>("Ooops permission denied", HttpStatus.FORBIDDEN);
    }

    batchService.clear();
    return new ResponseEntity(HttpStatus.OK);
  }

}

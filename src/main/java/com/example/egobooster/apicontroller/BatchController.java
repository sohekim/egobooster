package com.example.egobooster.apicontroller;

import com.example.egobooster.service.BatchService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

  @PutMapping("/set")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "num", value = "batch num", required = true, paramType = "query", dataType = "Integer")
  })
  public ResponseEntity setBatchNum(
      @RequestParam(required = true, value = "num") Integer num
  ) {
    batchService.setBatch(num);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Integer> getBatchNum() {
    return new ResponseEntity<>(batchService.getCount(), HttpStatus.OK);
  }

  @PutMapping("/clear")
  public ResponseEntity clearBatch() {
    batchService.clear();
    return new ResponseEntity(HttpStatus.OK);
  }

}

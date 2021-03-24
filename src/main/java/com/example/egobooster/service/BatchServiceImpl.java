package com.example.egobooster.service;

import com.example.egobooster.domain.entity.BatchNum;
import com.example.egobooster.repository.BatchRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

  final BatchRepository batchRepository;

  @Transactional
  @Override
  public BatchNum executeBatch() {
    Optional<BatchNum> optionalBatchNum = batchRepository.findById(1L);
    BatchNum batchNum = optionalBatchNum.get();
    batchNum.setCount(batchNum.getCount() + 1);
    return batchNum;
  }

  @Override
  public Integer getCount() {
    Optional<BatchNum> optionalBatchNum = batchRepository.findById(1L);
    if (optionalBatchNum.isPresent()) {
      BatchNum batchNum = optionalBatchNum.get();
      return batchNum.getCount();
    }
    return 0;
  }
}

package com.example.egobooster.service;

import com.example.egobooster.domain.entity.Love;
import com.example.egobooster.repository.LoveRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoveServiceImpl implements LoveService {

  final LoveRepository loveRepository;

  @Transactional
  @Override
  public Love love() {
    Optional<Love> optionalLove = loveRepository.findById(1L);
    Love love = optionalLove.get();
    love.setCount(love.getCount() + 1);
    //SOHEE if error
    return love;
  }

  @Override
  public int getCount() {
    Optional<Love> optionalLove = loveRepository.findById(1L);
    if (optionalLove.isPresent()) {
      Love love = optionalLove.get();
      return love.getCount();
    }
    return 0;
  }
}

package com.example.egobooster.repository;

import com.example.egobooster.domain.entity.Booster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoosterRepository extends JpaRepository<Booster, Long> {

  boolean existsByText(String text);

  Page<Booster> findAllByTextContaining(String text, Pageable pg);

  Integer countByIdGreaterThanEqual(Long id);

  Booster findTopByOrderByIdDesc();
}

package com.example.egobooster.repository;

import com.example.egobooster.domain.entity.BatchNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<BatchNum, Long> {

}

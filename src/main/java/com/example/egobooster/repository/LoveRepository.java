package com.example.egobooster.repository;

import com.example.egobooster.domain.entity.Love;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoveRepository extends JpaRepository<Love, Long> {

}

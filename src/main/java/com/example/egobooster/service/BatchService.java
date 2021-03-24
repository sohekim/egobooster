package com.example.egobooster.service;

import com.example.egobooster.domain.entity.BatchNum;

public interface BatchService {

  BatchNum executeBatch();

  Integer getCount();

}

package com.family.webserver.service;

import com.family.webserver.entity.Cinema;
import com.family.webserver.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class CinemasService {
  @Autowired
  private CinemaMapper mapper;

  public Cinema selectByPrimaryKey() {
    return mapper.selectByPrimaryKey(4444);
  }
}

package com.family.webserver.service;

import com.family.webserver.mapper.MovieshowingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class HomeService {
  @Autowired
  private MovieshowingMapper mapper;

  public List<String> getHotMoviesByCity(Integer cityId) {

    return new ArrayList<String>();
  }
}

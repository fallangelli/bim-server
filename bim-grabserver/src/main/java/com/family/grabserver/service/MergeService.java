package com.family.grabserver.service;

import com.family.grabserver.mapper.SolidifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/8.
 */
@SuppressWarnings("ALL")
@Service
public class MergeService {
    @Autowired
    private SolidifyMapper mapper;

    public void merge() {
        mapper.merge_city_maoyan();
        mapper.merge_city_mtime();

        mapper.merge_city_area_mtime();
        mapper.merge_city_area_maoyan();

        mapper.merge_movieshowing_mtime();
        mapper.merge_movieshowing_maoyan();

        mapper.merge_cinema_mtime();
        mapper.merge_cinema_maoyan();
    }

}

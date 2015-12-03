package com.family.grabserver.service;

import com.family.grabserver.entity.CinemaMovieMaoyan;
import com.family.grabserver.mapper.CinemaMovieMaoyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class CinemaMovieMaoyanService {
    @Autowired
    private CinemaMovieMaoyanMapper mapper;

    public List<CinemaMovieMaoyan> selectAll() {
        return mapper.selectAll();
    }

    public int insertOrUpate(CinemaMovieMaoyan record) {
        if (mapper.selectByPrimaryKey(record.getCinemaId(), record.getMovieId()) == null)
            return mapper.insert(record);
        return 0;
    }

}

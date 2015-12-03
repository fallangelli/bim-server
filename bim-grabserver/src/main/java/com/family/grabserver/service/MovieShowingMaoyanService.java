package com.family.grabserver.service;

import com.family.grabserver.entity.MovieShowingMaoyan;
import com.family.grabserver.mapper.MovieShowingMaoyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class MovieShowingMaoyanService {
    @Autowired
    private MovieShowingMaoyanMapper mapper;

    public int insertOrUpate(MovieShowingMaoyan record) {
        if (record.getId() == null)
            return mapper.insert(record);
        else {
            //电影信息不覆盖
            if (mapper.selectByPrimaryKey(record.getId()) != null)
                return 0;
            else
                return mapper.insert(record);
        }
    }

}

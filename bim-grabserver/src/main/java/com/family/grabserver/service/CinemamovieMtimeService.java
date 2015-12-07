package com.family.grabserver.service;

import com.family.grabserver.entity.CinemamovieMtime;
import com.family.grabserver.mapper.CinemamovieMtimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class CinemamovieMtimeService {
    @Autowired
    private CinemamovieMtimeMapper mapper;

    public List<CinemamovieMtime> selectAll() {
        return mapper.selectAll();
    }

    public int insertOrUpate(CinemamovieMtime record) {

        if (record.getId() == null)
            return mapper.insert(record);
        else {
            if (mapper.selectByPrimaryKey(record.getId()) != null)
                return mapper.updateByPrimaryKey(record);
            else
                return mapper.insert(record);
        }
    }

}

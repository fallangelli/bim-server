package com.family.grabserver.service;

import com.family.grabserver.entity.CityareaMtime;
import com.family.grabserver.mapper.CityareaMtimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class CityareaMtimeService {
    @Autowired
    private CityareaMtimeMapper mapper;

    public CityareaMtime selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int insertOrUpate(CityareaMtime record) {
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

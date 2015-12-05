package com.family.grabserver.service;

import com.family.grabserver.entity.CityMtime;
import com.family.grabserver.mapper.CityMtimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class CityMtimeService {
    @Autowired
    private CityMtimeMapper mapper;

    public List<CityMtime> selectAll() {
        return mapper.selectAll();
    }

    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int insertOrUpate(CityMtime record) {
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

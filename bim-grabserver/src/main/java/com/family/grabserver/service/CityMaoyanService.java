package com.family.grabserver.service;

import com.family.grabserver.entity.CityMaoyan;
import com.family.grabserver.mapper.CityMaoyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class CityMaoyanService {
    @Autowired
    private CityMaoyanMapper mapper;

    public List<CityMaoyan> selectAll() {
        return mapper.selectAll();
    }

    public int insertOrUpate(CityMaoyan record) {
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

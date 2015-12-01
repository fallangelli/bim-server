package com.family.grabserver.service;

import com.family.grabserver.entity.CinemaMaoyan;
import com.family.grabserver.mapper.CinemaMaoyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class CinemaMaoyanService {
    @Autowired
    private CinemaMaoyanMapper mapper;

    public int insertOrUpate(CinemaMaoyan record) {
        if (record.getId() == null)
            return mapper.insert(record);
        else
            return mapper.updateByPrimaryKey(record);
    }

}

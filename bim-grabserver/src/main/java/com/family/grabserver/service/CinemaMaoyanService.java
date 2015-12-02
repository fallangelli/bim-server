package com.family.grabserver.service;

import com.family.grabserver.entity.CinemaMaoyan;
import com.family.grabserver.mapper.CinemaMaoyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service("CinemaMaoyanService")
public class CinemaMaoyanService {
    @Autowired
    private CinemaMaoyanMapper mapper;

    public int insertOrUpate(CinemaMaoyan record) {
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

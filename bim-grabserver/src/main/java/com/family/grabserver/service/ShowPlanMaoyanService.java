package com.family.grabserver.service;

import com.family.grabserver.entity.ShowplanMaoyan;
import com.family.grabserver.mapper.ShowplanMaoyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class ShowplanMaoyanService {
    @Autowired
    private ShowplanMaoyanMapper mapper;

    public int insertOrUpate(ShowplanMaoyan record) {
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

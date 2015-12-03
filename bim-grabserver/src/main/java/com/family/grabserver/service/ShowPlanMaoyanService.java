package com.family.grabserver.service;

import com.family.grabserver.entity.ShowPlanMaoyan;
import com.family.grabserver.mapper.ShowPlanMaoyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class ShowPlanMaoyanService {
    @Autowired
    private ShowPlanMaoyanMapper mapper;

    public int insertOrUpate(ShowPlanMaoyan record) {
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

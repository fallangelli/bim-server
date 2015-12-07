package com.family.grabserver.service;

import com.family.grabserver.entity.ShowplanMtime;
import com.family.grabserver.mapper.ShowplanMtimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("ALL")
@Service
public class ShowplanMtimeService {
    @Autowired
    private ShowplanMtimeMapper mapper;

    public int insertOrUpate(ShowplanMtime record) {
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

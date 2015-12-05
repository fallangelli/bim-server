package com.family.grabserver.service;

import com.family.grabserver.entity.CinemamovieMaoyan;
import com.family.grabserver.mapper.CinemamovieMaoyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class CinemamovieMaoyanService {
    @Autowired
    private CinemamovieMaoyanMapper mapper;

    public List<CinemamovieMaoyan> selectAll() {
        return mapper.selectAll();
    }

    public int insertOrUpate(CinemamovieMaoyan record) {

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

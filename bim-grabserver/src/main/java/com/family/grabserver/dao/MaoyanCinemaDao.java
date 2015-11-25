package com.family.grabserver.dao;

import com.family.grabserver.model.MaoyanCinemaJson;
import org.apache.ibatis.annotations.Insert;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:27
 */
public interface MaoyanCinemaDao {
    @Insert("insert into maoyan_cinema (`context`,`source`, `url`,`urlMd5`)" +
            "values (#{context},#{source},#{url},#{urlMd5})")
    public int add(MaoyanCinemaJson model);
}
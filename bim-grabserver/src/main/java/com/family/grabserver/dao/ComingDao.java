package com.family.grabserver.dao;

import com.family.grabserver.model.DoubanComing;
import org.apache.ibatis.annotations.Insert;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:27
 */
public interface ComingDao {
    @Insert("insert into movie_coming (`title`,`director`,`actor`,`type`,`source`,`url`,`urlMd5`)" +
            "values (#{title},#{director},#{actor},#{type},#{source},#{url},#{urlMd5})")
    public int add(DoubanComing model);
}
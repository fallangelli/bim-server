package com.family.grabserver.mapper;

import com.family.grabserver.entity.ScreeningMaoyan;

import java.util.List;

public interface ScreeningMaoyanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table screening_maoyan
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table screening_maoyan
     *
     * @mbggenerated
     */
    int insert(ScreeningMaoyan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table screening_maoyan
     *
     * @mbggenerated
     */
    ScreeningMaoyan selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table screening_maoyan
     *
     * @mbggenerated
     */
    List<ScreeningMaoyan> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table screening_maoyan
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ScreeningMaoyan record);
}
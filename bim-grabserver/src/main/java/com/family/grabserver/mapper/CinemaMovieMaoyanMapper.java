package com.family.grabserver.mapper;

import com.family.grabserver.entity.CinemaMovieMaoyan;

import java.util.List;

public interface CinemaMovieMaoyanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cinema_movie_maoyan
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cinema_movie_maoyan
     *
     * @mbggenerated
     */
    int insert(CinemaMovieMaoyan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cinema_movie_maoyan
     *
     * @mbggenerated
     */
    CinemaMovieMaoyan selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cinema_movie_maoyan
     *
     * @mbggenerated
     */
    List<CinemaMovieMaoyan> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cinema_movie_maoyan
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CinemaMovieMaoyan record);
}
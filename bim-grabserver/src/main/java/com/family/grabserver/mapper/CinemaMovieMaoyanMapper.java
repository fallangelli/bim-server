package com.family.grabserver.mapper;

import com.family.grabserver.entity.CinemaMovieMaoyan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CinemaMovieMaoyanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cinema_movie_maoyan
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("cinemaId") Integer cinemaId, @Param("movieId") Integer movieId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cinema_movie_maoyan
     *
     * @mbggenerated
     */
    CinemaMovieMaoyan selectByPrimaryKey(@Param("cinemaId") Integer cinemaId, @Param("movieId") Integer movieId);

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
    List<CinemaMovieMaoyan> selectAll();
}
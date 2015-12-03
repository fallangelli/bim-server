package com.family.grabserver.entity;

public class CinemaMaoyanFeatures {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cinema_maoyan_features.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cinema_maoyan_features.cinema_id
     *
     * @mbggenerated
     */
    private Integer cinemaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cinema_maoyan_features.desc
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cinema_maoyan_features.tag
     *
     * @mbggenerated
     */
    private String tag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cinema_maoyan_features.id
     *
     * @return the value of cinema_maoyan_features.id
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cinema_maoyan_features.id
     *
     * @param id the value for cinema_maoyan_features.id
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cinema_maoyan_features.cinema_id
     *
     * @return the value of cinema_maoyan_features.cinema_id
     * @mbggenerated
     */
    public Integer getCinemaId() {
        return cinemaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cinema_maoyan_features.cinema_id
     *
     * @param cinemaId the value for cinema_maoyan_features.cinema_id
     * @mbggenerated
     */
    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cinema_maoyan_features.desc
     *
     * @return the value of cinema_maoyan_features.desc
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cinema_maoyan_features.desc
     *
     * @param desc the value for cinema_maoyan_features.desc
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cinema_maoyan_features.tag
     *
     * @return the value of cinema_maoyan_features.tag
     * @mbggenerated
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cinema_maoyan_features.tag
     *
     * @param tag the value for cinema_maoyan_features.tag
     * @mbggenerated
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}
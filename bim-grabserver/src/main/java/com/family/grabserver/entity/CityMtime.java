package com.family.grabserver.entity;

public class CityMtime {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city_mtime.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city_mtime.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city_mtime.first_letter
     *
     * @mbggenerated
     */
    private String firstLetter;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city_mtime.pinyin
     *
     * @mbggenerated
     */
    private String pinyin;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city_mtime.id
     *
     * @return the value of city_mtime.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city_mtime.id
     *
     * @param id the value for city_mtime.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city_mtime.name
     *
     * @return the value of city_mtime.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city_mtime.name
     *
     * @param name the value for city_mtime.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city_mtime.first_letter
     *
     * @return the value of city_mtime.first_letter
     *
     * @mbggenerated
     */
    public String getFirstLetter() {
        return firstLetter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city_mtime.first_letter
     *
     * @param firstLetter the value for city_mtime.first_letter
     *
     * @mbggenerated
     */
    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter == null ? null : firstLetter.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city_mtime.pinyin
     *
     * @return the value of city_mtime.pinyin
     *
     * @mbggenerated
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city_mtime.pinyin
     *
     * @param pinyin the value for city_mtime.pinyin
     *
     * @mbggenerated
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }
}
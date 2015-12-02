package com.family.grabserver.entity;

public class MovieComing {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_coming.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_coming.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_coming.director
     *
     * @mbggenerated
     */
    private String director;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_coming.actor
     *
     * @mbggenerated
     */
    private String actor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_coming.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_coming.source
     *
     * @mbggenerated
     */
    private String source;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_coming.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_coming.urlMd5
     *
     * @mbggenerated
     */
    private String urlmd5;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_coming.id
     *
     * @return the value of movie_coming.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_coming.id
     *
     * @param id the value for movie_coming.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_coming.title
     *
     * @return the value of movie_coming.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_coming.title
     *
     * @param title the value for movie_coming.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_coming.director
     *
     * @return the value of movie_coming.director
     *
     * @mbggenerated
     */
    public String getDirector() {
        return director;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_coming.director
     *
     * @param director the value for movie_coming.director
     *
     * @mbggenerated
     */
    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_coming.actor
     *
     * @return the value of movie_coming.actor
     *
     * @mbggenerated
     */
    public String getActor() {
        return actor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_coming.actor
     *
     * @param actor the value for movie_coming.actor
     *
     * @mbggenerated
     */
    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_coming.type
     *
     * @return the value of movie_coming.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_coming.type
     *
     * @param type the value for movie_coming.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_coming.source
     *
     * @return the value of movie_coming.source
     *
     * @mbggenerated
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_coming.source
     *
     * @param source the value for movie_coming.source
     *
     * @mbggenerated
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_coming.url
     *
     * @return the value of movie_coming.url
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_coming.url
     *
     * @param url the value for movie_coming.url
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_coming.urlMd5
     *
     * @return the value of movie_coming.urlMd5
     *
     * @mbggenerated
     */
    public String getUrlmd5() {
        return urlmd5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_coming.urlMd5
     *
     * @param urlmd5 the value for movie_coming.urlMd5
     *
     * @mbggenerated
     */
    public void setUrlmd5(String urlmd5) {
        this.urlmd5 = urlmd5 == null ? null : urlmd5.trim();
    }
}
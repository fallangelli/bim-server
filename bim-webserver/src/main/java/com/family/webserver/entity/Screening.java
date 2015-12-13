package com.family.webserver.entity;

import java.util.Date;

public class Screening {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.id
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private Integer id;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.cinema_id
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private Integer cinemaId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.movie_id
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private Integer movieId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.show_date
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private Date showDate;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.start_time
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private Date startTime;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.end_time
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private Date endTime;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.language
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private String language;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.hall
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private String hall;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.version
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private String version;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.sale_price
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private Float salePrice;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.cinema_price
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private Float cinemaPrice;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.source
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private String source;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column screening.ticket_url
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  private String ticketUrl;

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.id
   *
   * @return the value of screening.id
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public Integer getId() {
    return id;
  }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column screening.id
     *
     * @param id the value for screening.id
     *
     * @mbggenerated Sun Dec 13 20:33:05 CST 2015
     */
    public void setId(Integer id) {
      this.id = id;
    }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.cinema_id
   *
   * @return the value of screening.cinema_id
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public Integer getCinemaId() {
    return cinemaId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.cinema_id
   *
   * @param cinemaId the value for screening.cinema_id
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setCinemaId(Integer cinemaId) {
    this.cinemaId = cinemaId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.movie_id
   *
   * @return the value of screening.movie_id
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public Integer getMovieId() {
    return movieId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.movie_id
   *
   * @param movieId the value for screening.movie_id
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setMovieId(Integer movieId) {
    this.movieId = movieId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.show_date
   *
   * @return the value of screening.show_date
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public Date getShowDate() {
    return showDate;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.show_date
   *
   * @param showDate the value for screening.show_date
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setShowDate(Date showDate) {
    this.showDate = showDate;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.start_time
   *
   * @return the value of screening.start_time
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public Date getStartTime() {
    return startTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.start_time
   *
   * @param startTime the value for screening.start_time
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.end_time
   *
   * @return the value of screening.end_time
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public Date getEndTime() {
    return endTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.end_time
   *
   * @param endTime the value for screening.end_time
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.language
   *
   * @return the value of screening.language
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public String getLanguage() {
    return language;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.language
   *
   * @param language the value for screening.language
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setLanguage(String language) {
    this.language = language == null ? null : language.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.hall
   *
   * @return the value of screening.hall
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public String getHall() {
    return hall;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.hall
   *
   * @param hall the value for screening.hall
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setHall(String hall) {
    this.hall = hall == null ? null : hall.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.version
   *
   * @return the value of screening.version
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public String getVersion() {
    return version;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.version
   *
   * @param version the value for screening.version
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setVersion(String version) {
    this.version = version == null ? null : version.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.sale_price
   *
   * @return the value of screening.sale_price
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public Float getSalePrice() {
    return salePrice;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.sale_price
   *
   * @param salePrice the value for screening.sale_price
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setSalePrice(Float salePrice) {
    this.salePrice = salePrice;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.cinema_price
   *
   * @return the value of screening.cinema_price
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public Float getCinemaPrice() {
    return cinemaPrice;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.cinema_price
   *
   * @param cinemaPrice the value for screening.cinema_price
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setCinemaPrice(Float cinemaPrice) {
    this.cinemaPrice = cinemaPrice;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.source
   *
   * @return the value of screening.source
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public String getSource() {
    return source;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.source
   *
   * @param source the value for screening.source
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setSource(String source) {
    this.source = source == null ? null : source.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column screening.ticket_url
   *
   * @return the value of screening.ticket_url
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public String getTicketUrl() {
    return ticketUrl;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column screening.ticket_url
   *
   * @param ticketUrl the value for screening.ticket_url
   *
   * @mbggenerated Sun Dec 13 20:33:05 CST 2015
   */
  public void setTicketUrl(String ticketUrl) {
    this.ticketUrl = ticketUrl == null ? null : ticketUrl.trim();
  }
}
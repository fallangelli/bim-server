package com.family.webserver.entity;

public class Cinema {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.id
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private Integer id;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.district_id
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private Integer districtId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.name
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private String name;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.address
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private String address;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.latitude
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private String latitude;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.longitude
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private String longitude;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.rating
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private String rating;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.has_3d
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private Boolean has3d;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.has_imax
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private Boolean hasImax;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.has_Wifi
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private Boolean hasWifi;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.has_Park
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private Boolean hasPark;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.tel
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private String tel;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.route
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private String route;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.id_maoyan
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private Integer idMaoyan;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column cinema.id_mtime
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  private Integer idMtime;

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.id
   *
   * @return the value of cinema.id
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public Integer getId() {
    return id;
  }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cinema.id
     *
     * @param id the value for cinema.id
     *
     * @mbggenerated Sat Dec 12 22:05:44 CST 2015
     */
    public void setId(Integer id) {
      this.id = id;
    }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.district_id
   *
   * @return the value of cinema.district_id
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public Integer getDistrictId() {
    return districtId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.district_id
   *
   * @param districtId the value for cinema.district_id
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setDistrictId(Integer districtId) {
    this.districtId = districtId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.name
   *
   * @return the value of cinema.name
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public String getName() {
    return name;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.name
   *
   * @param name the value for cinema.name
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.address
   *
   * @return the value of cinema.address
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public String getAddress() {
    return address;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.address
   *
   * @param address the value for cinema.address
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setAddress(String address) {
    this.address = address == null ? null : address.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.latitude
   *
   * @return the value of cinema.latitude
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.latitude
   *
   * @param latitude the value for cinema.latitude
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude == null ? null : latitude.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.longitude
   *
   * @return the value of cinema.longitude
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.longitude
   *
   * @param longitude the value for cinema.longitude
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude == null ? null : longitude.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.rating
   *
   * @return the value of cinema.rating
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public String getRating() {
    return rating;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.rating
   *
   * @param rating the value for cinema.rating
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setRating(String rating) {
    this.rating = rating == null ? null : rating.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.has_3d
   *
   * @return the value of cinema.has_3d
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public Boolean getHas3d() {
    return has3d;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.has_3d
   *
   * @param has3d the value for cinema.has_3d
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setHas3d(Boolean has3d) {
    this.has3d = has3d;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.has_imax
   *
   * @return the value of cinema.has_imax
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public Boolean getHasImax() {
    return hasImax;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.has_imax
   *
   * @param hasImax the value for cinema.has_imax
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setHasImax(Boolean hasImax) {
    this.hasImax = hasImax;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.has_Wifi
   *
   * @return the value of cinema.has_Wifi
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public Boolean getHasWifi() {
    return hasWifi;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.has_Wifi
   *
   * @param hasWifi the value for cinema.has_Wifi
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setHasWifi(Boolean hasWifi) {
    this.hasWifi = hasWifi;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.has_Park
   *
   * @return the value of cinema.has_Park
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public Boolean getHasPark() {
    return hasPark;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.has_Park
   *
   * @param hasPark the value for cinema.has_Park
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setHasPark(Boolean hasPark) {
    this.hasPark = hasPark;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.tel
   *
   * @return the value of cinema.tel
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public String getTel() {
    return tel;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.tel
   *
   * @param tel the value for cinema.tel
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setTel(String tel) {
    this.tel = tel == null ? null : tel.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.route
   *
   * @return the value of cinema.route
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public String getRoute() {
    return route;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.route
   *
   * @param route the value for cinema.route
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setRoute(String route) {
    this.route = route == null ? null : route.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.id_maoyan
   *
   * @return the value of cinema.id_maoyan
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public Integer getIdMaoyan() {
    return idMaoyan;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.id_maoyan
   *
   * @param idMaoyan the value for cinema.id_maoyan
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setIdMaoyan(Integer idMaoyan) {
    this.idMaoyan = idMaoyan;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column cinema.id_mtime
   *
   * @return the value of cinema.id_mtime
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public Integer getIdMtime() {
    return idMtime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column cinema.id_mtime
   *
   * @param idMtime the value for cinema.id_mtime
   *
   * @mbggenerated Sat Dec 12 22:05:44 CST 2015
   */
  public void setIdMtime(Integer idMtime) {
    this.idMtime = idMtime;
  }
}

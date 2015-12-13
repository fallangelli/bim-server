package com.family.webserver.service;

import com.family.webserver.entity.Cinema;
import com.family.webserver.entity.ListCinema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-myBatis.xml"})
public class CityCinemaServiceTest {

  @Autowired
  private CityCinemaService service;

  @Test
  public void testSelect() throws Exception {
    Cinema cinema = service.getCinemaId(212213);
    System.out.println(cinema.getName());
  }

  @Test
  public void testGetByCinemaId() throws Exception {

  }

  @Test
  public void testGetCinemaByCity() throws Exception {

  }

  @Test
  public void testGetMovieCinemaByCity() throws Exception {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2015-12-12");
    List<ListCinema> listCinemas = service.getMovieCinemaByCity(2861, 1713, date);


    System.out.println("return size : " + listCinemas.size());
  }
}

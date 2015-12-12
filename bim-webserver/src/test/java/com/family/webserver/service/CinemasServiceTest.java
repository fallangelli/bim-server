package com.family.webserver.service;

import com.family.webserver.entity.Cinema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-myBatis.xml"})
public class CinemasServiceTest {

  @Autowired
  private CinemasService service;

  @Test
  public void testSelect() throws Exception {
    Cinema cinema = service.selectByPrimaryKey();
    System.out.println(cinema.getName());
  }
}

package com.family.grabserver;

import com.family.grabserver.dao.ComingDao;
import com.family.grabserver.model.DoubanComing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 下午8:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-*.xml"})
public class JobInfoDaoTest {
    @Resource
    private ComingDao dao;

    //    @Ignore
    @Test
    public void test() {
        DoubanComing jobInfo = new DoubanComing();
        jobInfo.setTitle("a");
        try {
            final int add = dao.add(jobInfo);
            System.out.println(add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

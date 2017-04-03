package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载spring IOC容器
 * Created by wx on 2017/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    /* 注入Dao实现类依赖 */
    @Resource
    private SeckillDao seckillDao;

    @Test
    /**
     * 1000元秒杀ipone6s
     Seckill{seckillId=1000, name='1000元秒杀ipone6s', number=100, startTime=Mon Apr 03 00:00:00 GMT+08:00 2017, endTime=Wed Nov 02 00:00:00 GMT+08:00 2016, createTime=Sun Apr 02 13:28:38 GMT+08:00 2017}

     */
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    /**
     * Parameter 'offset' not found. Available parameters are [1, 0, param1, param2]
     */
    public void queryAll() throws Exception {
        List<Seckill> seckillList = seckillDao.queryAll(0,100);
        for (Seckill seckill : seckillList) {
            System.out.println(seckill);
        }

    }
    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println(updateCount);
    }
}
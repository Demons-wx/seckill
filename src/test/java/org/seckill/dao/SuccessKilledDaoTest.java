package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wx on 2017/4/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1001L;
        long phone = 18620003214L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    /**
     * SuccessKilled{seckillId=1000, state=-1, userPhone=18620003214, createTime=Mon Apr 03 16:22:48 GMT+08:00 2017}
     Seckill{seckillId=1000, name='1000元秒杀ipone6s', number=100, startTime=Mon Apr 03 00:00:00 GMT+08:00 2017, endTime=Wed Nov 02 00:00:00 GMT+08:00 2016, createTime=Sun Apr 02 13:28:38 GMT+08:00 2017}
     */
    public void queryByIdWithSeckill() throws Exception {
        long id = 1001L;
        long phone = 18620003214L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}
package org.seckill.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by wangxuan on 2017/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml",
        "classpath:spring/spring-web.xml"})
public class SeckillControllerTest {

    @Test
    public void testExposer() {
        Long seckillId = 1002L;
        RestTemplate rest = new RestTemplate();
        Exposer exposer = rest.getForObject("http://localhost:8080/seckill/{seckillId}/exposer2",  Exposer.class, seckillId);
        System.out.print(exposer);
    }

    @Test
    public void testTime() {
        RestTemplate rest = new RestTemplate();
        Long time = rest.getForObject(URI.create("http://localhost:8080/seckill/time/now"), Long.class);
        System.out.print(time);
    }
}
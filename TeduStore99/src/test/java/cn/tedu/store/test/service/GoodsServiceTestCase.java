package cn.tedu.store.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.service.IGoodsService;

public class GoodsServiceTestCase {
	private AbstractApplicationContext ac;
	private IGoodsService goodsService;
    @Before
    public void start() {
    	ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
    	goodsService=ac.getBean("goodsService",IGoodsService.class);
    }
    @After
    public void end() {
    	ac.close();
    }
    @Test
    public void test() {
    Goods goods=goodsService.findGoodsById("10000017");
    System.out.println(goods.toString());
    }
}

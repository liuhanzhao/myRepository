package cn.tedu.store.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IGoodsService;

public class CartServiceTestCase {
	private AbstractApplicationContext ac;
	private ICartService cartService;
    @Before
    public void start() {
    	ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
    	cartService=ac.getBean("cartService",ICartService.class);
    }
    @After
    public void end() {
    	ac.close();
    }
    @Test
    public void test() {
    	Cart cart=new Cart();
		cart.setGoodsId("10000017");
		cart.setGoodsNum(1);
		cart.setUid(4);	
		cartService.addToCart(cart);
    }
    @Test
    public void test1() {
    	
     Integer[]cartIds=new Integer[] {29,30,31,32};
	  cartService.orderConfirm(cartIds, 4);
    }

}

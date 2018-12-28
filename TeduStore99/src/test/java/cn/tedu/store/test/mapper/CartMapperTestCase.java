package cn.tedu.store.test.mapper;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.vo.CartVO;

public class CartMapperTestCase {
	private AbstractApplicationContext ac;
	private CartMapper cartMapper;
	@Before
	public void start() {
		ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		cartMapper=ac.getBean("cartMapper",CartMapper.class);
		
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
		Integer rows=cartMapper.insert(cart);
		System.out.println(rows);	
	}
	@Test
	public void test2() {
		
		List<CartVO>list=cartMapper.getList(4);
		System.out.println(list);
	}


}

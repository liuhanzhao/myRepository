package cn.tedu.store.test.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;

public class GGoodsMapperTestCase {
	private AbstractApplicationContext ac;
	private GoodsMapper goodMapper;
	@Before
	public void start() {
		ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		goodMapper=ac.getBean("goodsMapper",GoodsMapper.class);
		
	}
	@After
	public void end() {
		ac.close();
	}
	@Test
	public void test() {
		Goods good=goodMapper.findGoodsById("10000017");
		System.out.println(good.toString());
		
	}

}

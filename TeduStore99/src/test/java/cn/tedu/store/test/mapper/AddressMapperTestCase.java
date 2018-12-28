package cn.tedu.store.test.mapper;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.entity.Address;
import cn.tedu.store.mapper.AddressMapper;

public class AddressMapperTestCase {
	private AbstractApplicationContext ac;
	private AddressMapper addressMapper;
	@Before
	public void test1() {
		ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		addressMapper=ac.getBean("addressMapper",AddressMapper.class);
	}
	@After
	public void test2() {
		ac.close();
	}
	@Test
	public void test() {
		Address address=new Address();
		address.setUid(3);
		address.setRecvZip("3333445");
		address.setRecvName("小刘");
		Integer rows=addressMapper.insert(address);
		System.out.println(rows);
		
	}
	@Test
	public void test3() {
		Integer rows=addressMapper.getCountByUid(4);
		System.out.println(rows);
		
	}
	@Test
	public void test4() {
		List<Address>list=addressMapper.getListByuid(4);
		System.out.println(list);
	}

}

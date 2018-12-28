package cn.tedu.store.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.tedu.store.entity.Address;
import cn.tedu.store.service.impl.AddressServiceImpl;

public class AddressServiceTestCase {
	private AbstractApplicationContext ac;
	private AddressServiceImpl addressService;
	
	@Before
	public void start() {
		ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		addressService=ac.getBean("addressService",AddressServiceImpl.class);
	}
	@After
	public void end() {
		ac.close();
	}
	@Test 
	public void test() {
		Address address=new Address();
		address.setUid(4);
		address.setRecvName("小李子");
		address=addressService.addnew(address);
		System.out.println(address.toString());
	}

}

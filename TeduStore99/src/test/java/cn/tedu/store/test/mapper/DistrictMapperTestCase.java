package cn.tedu.store.test.mapper;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;

public class DistrictMapperTestCase {
	private DistrictMapper districtMapper;
	private AbstractApplicationContext ac;
	@Before
	public void start() {
		ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		districtMapper=ac.getBean("districtMapper",DistrictMapper.class);	
	}
    @After
    public void finish() {
    	ac.close();
    }
    @Test
    public void test() {
    	List<District>list=districtMapper.getList("86");
    	for(int i=0;i<list.size();i++) {
    		System.out.println(list.get(i).toString());
    	}
    }
}

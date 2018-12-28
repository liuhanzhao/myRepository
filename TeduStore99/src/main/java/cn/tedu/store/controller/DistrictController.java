package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.District;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IDistrictService;

@Controller
@RequestMapping("/district")
@ResponseBody
public class DistrictController {
	@Autowired
	private IDistrictService districtService;
	@RequestMapping(value="/list.do",method=RequestMethod.POST)
	public ResponseResult<List<District>> getList(@RequestParam("parent")String parent){
		//获取数据
		List<District>list=districtService.getList(parent);
		System.out.println(list);
		//创建返回值对象
		ResponseResult<List<District>> rr=new ResponseResult<List<District>>();
		rr.setData(list);
		return rr;
	}

}

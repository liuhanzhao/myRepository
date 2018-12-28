package cn.tedu.store.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.IAddressService;
@Controller
@RequestMapping("/address")
public class AddressController extends BaseController{
	@Autowired
	private IAddressService addressService;
	@RequestMapping(value="/addnew.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAddnew(Address address, HttpSession session) {
		// 获取uid
		Integer uid = Integer.valueOf(session.getAttribute("uid").toString());	
		// 将uid封装到address
		address.setUid(uid);
		System.out.println(address.toString());
		// 调用业务层执行增加
		addressService.addnew(address);
		
		// 返回
		return new ResponseResult<Void>();
		
	}
	/*
	 * 用户请求的所有快递地址的详细信息
	 */
	@RequestMapping(value="/getList.do",method=RequestMethod.GET)
   @ResponseBody
   public ResponseResult<List<Address>> handleGetList(HttpSession session){
		Integer uid=Integer.valueOf(session.getAttribute("uid").toString());
		List<Address> list=addressService.getListByuid(uid);
		ResponseResult<List<Address>> rr=new ResponseResult<List<Address>>();
		rr.setData(list);
		System.out.println("用户请求地址List："+list);
	   return rr;
   }
	/*
	 * 用户请求删除地址
	 */
	@RequestMapping(value="/deleteAddress.do",method=RequestMethod.GET)
	@ResponseBody
	public ResponseResult<Integer> handleDeleteAddress(@RequestParam("id")Integer id){
		ResponseResult<Integer> rr=new ResponseResult<Integer>();
		Integer rows=addressService.deleteAddress(id);
		rr.setData(rows);
		return rr;
	}
	/**
	 * 更新用户的已有的address
	 * @param address
	 * @return
	 */
	@RequestMapping(value="/updateAddress.do",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleUpdateAddress(Address address){
		Integer rows=addressService.updateAddress(address);
		System.out.println("用户已有的地址更新了！");
		return null;
	}
	/**
	 * 用户默认收货地址设置
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/set_default.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(@RequestParam("id") Integer id,HttpSession session){
		System.out.println("我进来啦！");
		Integer uid=Integer.valueOf(session.getAttribute("uid").toString());
		addressService.setDefaultAddress(id, uid);
		return new ResponseResult<Void>();
	}
	
	
	

}

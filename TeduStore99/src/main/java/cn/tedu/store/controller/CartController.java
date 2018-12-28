package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.vo.CartVO;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private ICartService cartService;
	@RequestMapping(value="/addToCart.do",method=RequestMethod.POST)
	@ResponseBody
	/*
	 * 商品加入购物车
	 */
	public ResponseResult<Void> handleInsertCart(HttpSession session,String goodsId,Integer goodsNum) {
		Cart cart=new Cart();
		cart.setGoodsId(goodsId);
		cart.setGoodsNum(goodsNum);
		Integer uid = null;
		if(session!=null) {
		 uid=Integer.valueOf(session.getAttribute("uid").toString());
		}else {
			//用户未登录
		}
		cart.setUid(uid);
		System.out.println(cart.toString());
		cartService.addToCart(cart);
		return new ResponseResult<Void>();
	}
	/**
	 * 获取用户的购物车的商品信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public ResponseResult<List<CartVO>> handleGetCartList(HttpSession session){
		Integer uid=Integer.valueOf(session.getAttribute("uid").toString());
		List<CartVO>list=cartService.getList(uid);
		ResponseResult<List<CartVO>> rr=new ResponseResult<List<CartVO>>();
		rr.setData(list);
		return rr;	
	}
	/**
	 * 修改用户购物车里面商品的数量
	 */
    @RequestMapping(value="/updateNum.do",method=RequestMethod.GET)
    @ResponseBody
    public ResponseResult<Void> handleUpdateCartGoodsNum(@RequestParam("cartId")Integer id,@RequestParam("goodsNum")Integer num,HttpSession session){
    	if(session!=null) {
    		cartService.updateGoodsNum(id, num);
    	}
    	return new ResponseResult<Void>();
    }
	/**
	 * 获取用户的购物车的商品信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/orderConfirm.do")
	@ResponseBody
	public ResponseResult<List<CartVO>> handleOrderConfirm(HttpSession session,Integer[]cartId){
		Integer uid=Integer.valueOf(session.getAttribute("uid").toString());
		List<CartVO>list=cartService.orderConfirm(cartId, uid);
		ResponseResult<List<CartVO>> rr=new ResponseResult<List<CartVO>>();
		rr.setData(list);
		return rr;	
	}
}

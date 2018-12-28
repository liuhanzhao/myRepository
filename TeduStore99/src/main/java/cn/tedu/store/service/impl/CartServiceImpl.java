package cn.tedu.store.service.impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.vo.CartVO;
@Service("cartService")
public class CartServiceImpl implements ICartService{
	@Autowired
	private CartMapper cartMapper;
    /**
     * 商品加入购物车功能
     */
	public void addToCart(Cart cart) {
		Integer rows=cartMapper.insert(cart);
		if(rows==1) {
			//插入成功
		}else {
			throw new InsertDataException("商品加入购物车失败！");
		}
		
	}
	/**
	 *  查询购物车的商品详情
	 * @param id
	 * @return
	 */
	public List<CartVO> getList(Integer uid) {
	   List<CartVO>list=cartMapper.getList(uid);
		return list;
	}
	/*
	 * 修改购物车商品数量
	 */
	public void updateGoodsNum(Integer cartId, Integer goodsNum) {
		Integer rows=cartMapper.updateGoodsNum(cartId, goodsNum);
		if(rows==1) {
			System.out.println("商品数量修改成功！");
		}else {
			System.out.println("商品数量修改失败！");
		}
	}
	 /**
	    * 返回的是确认商品的详细信息
	    * @param cartId
	    * @param id
	    * @return
	    */
	
@Transactional
public List<CartVO> orderConfirm(Integer[] cartIds, Integer uid) {
		Set<Integer> set=new HashSet<Integer>();
		List<CartVO> list=new ArrayList<CartVO>();
		for(int i=0;i<cartIds.length;i++) {
			CartVO cv=cartMapper.getOrderListByGoodsId(cartIds[i], uid);
			list.add(cv);
			set.add(Integer.valueOf(cv.getGoodsId()));
				
		}
		System.out.println("goodsId:"+set);
		System.out.println(list);
		return list;
	}
	

}

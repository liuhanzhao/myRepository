package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.vo.CartVO;

/*
 * 购物车表业务
 */
public interface ICartService {
	/**
	 * 
	 * @param cart
	 */
	public void addToCart(Cart cart)throws InsertDataException;
	/**
	 *  查询购物车的商品详情
	 * @param id
	 * @return
	 */
	public List<CartVO> getList(Integer uid);
	/*
	 * 修改购物车商品数量
	 */
   public void updateGoodsNum(Integer cartId,Integer goodsNum);
   /**
    * 返回的是确认商品的详细信息
    * @param cartId
    * @param id
    * @return
    */
   public List<CartVO> orderConfirm(Integer[]cartId,Integer id);

}

package cn.tedu.store.vo;

import java.io.Serializable;

public class CartVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -977121558471543679L;
	private Integer uid;
	private Integer cartId;
	private String goodsId;
	private String goodsTitle;
	private String goodsImage;
	private long goodsPrice;
	private Integer goodsNum;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getUid() {
		return uid;
	}
	public Integer getCartId() {
		return cartId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public long getGoodsPrice() {
		return goodsPrice;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public void setGoodsPrice(long goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	@Override
	public String toString() {
		return "CartVO [uid=" + uid + ", cartId=" + cartId + ", goodsId=" + goodsId + ", goodsImage=" + goodsImage
				+ ", goodsPrice=" + goodsPrice + ", goodsNum=" + goodsNum + "]";
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	

}

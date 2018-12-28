package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.AddressAccessException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.UpdateDataException;

/*
 * 收货地址的数据业务层
 */
public interface IAddressService {
	/**
	 * 增加新的收货地址
	 * @param address 收货地址数据
	 * @return 成功增加的收货地址数据，包括数据的id
	 */
	Address addnew(Address address);
	/**
	 *  获取用户数据的数组
	 * @param uid 用户的id
	 * @return 用户list
	 */
	List<Address> getListByuid(Integer uid);
	/**
     * 删除用户地址 
     * @param  用户的id
     * @return 删除的行数
     */
	Integer deleteAddress(Integer id);
	/**
	 * 更新用户的已有的address
	 * @param address
	 * @return
	 */
	Integer updateAddress(Address address);
	/**
	 * 设置默认收货地址
	 * @param id 默认的收货地址的id
	 * @param uid 地址信息归属的用户
	 * @throws AddressNotFoundException 尝试访问的收货地址数据不存在
	 * @throws AddressAccessException 收货地址数据归属错误
	 * @throws UpdateDataException 更新数据异常
	 */
	void setDefaultAddress(Integer id, Integer uid) throws AddressNotFoundException,AddressAccessException, UpdateDataException;
	

}

package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.Address;

public interface AddressMapper {
	/**
	 * 插入收货地址数据
	 * @param address 收货地址数据
	 * @return 受影响的行数
	 */
	Integer insert(Address address);
	/**
	 * 获取某用户的收货地址数据的数量
	 * @param uid 用户的id 
	 * @return 用户的收货地址数据的数量
	 */
	Integer getCountByUid(Integer uid);
	/**
	 *  获取用户数据的数组
	 * @param uid 用户的uid
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
	 * 获取用户数据的数组 
	 * @param id
	 * @return
	 */
	Address getAddressById(Integer id);
	/**
	 * 将某用户的所有收货地址设置为非默认收货地址
	 * @param uid 用户id
	 * @return 受影响的行数
	 */
	Integer setNonDefault(Integer uid);

	/**
	 * 将指定id的收货地址设置为默认收货地址
	 * @param id 收货地址数据id
	 * @return 受影响的行数
	 */
	Integer setDefault(Integer id);


}

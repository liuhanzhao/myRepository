package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.User;

public interface UserMapper {


	/**
	 * 插入用户数据
	 * @param user 用户数据
	 * @return 受影响的行数
	 */
	Integer insert(User user);

	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findUserByUsername(String username);
	/**
	 * 根据用户id查询用户数据
	 * @param id 用户id
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findUserById(Integer id);

	/**
	 * 对原始密码进行修改
	 * 
	 * @param username
	 * @param oldPassword
	 * @param newPassword
	 * @return 被更改的行数
	 */
	
	Integer changePwd(@Param("username")String username, @Param("password")String newPassword);
	
    /*
     * 对用户数据进行修改
     */
	Integer updateInfo(User user);
	/**
	 * 更新用户头像
	 * @param id 用户id
	 * @param avatar 用户头像在服务器端的路径
	 * @return 受影响的行数
	 */
	Integer updateAvatar(@Param("id") Integer id,@Param("avatar") String avatar);
	
	
}

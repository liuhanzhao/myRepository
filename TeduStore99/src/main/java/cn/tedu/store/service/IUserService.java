package cn.tedu.store.service;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ChangePwdException;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateDataException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameConflictException;

public interface IUserService {

	/**
	 * �û�ע��
	 * @param user �û�����
	 * @return �ɹ�ע����û����ݣ��Ұ����û���id
	 * @throws UsernameConflictException �û�����ռ��
	 * @throws InsertDataException �������ݴ���
	 */
	User reg(User user) 
			throws UsernameConflictException, 
				InsertDataException;
	
	/**
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return �ɹ���¼���û���Ϣ
	 * @throws UserNotFoundException �û���������
	 * @throws PasswordNotMatchException ������� 
	 */
	User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;
	/**
	 * 修改用户密码
	 */
	User updataPwd(String username,String oldPassword,String newPassword)throws ChangePwdException,UpdateDataException;
	/*
	 * 修改用户信息
	 */
	User updateInfo(User user,Integer id);
	/*
	 * 获取用户信息
	 */
	User findUserByUsername(String username);
	/**
	 * 根据用户id查询用户数据
	 * @param id 用户id
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findUserById(Integer id);
	/**
	 * 修改用户头像
	 * @param id 用户id
	 * @param avatar 用户头像的路径
	 * @throws UserNotFoundException 用户数据不存在
	 * @throws UpdateDataException 更新数据错误
	 */
	void changeAvatar(Integer id, String avatar) throws UserNotFoundException, UpdateDataException;
	
}





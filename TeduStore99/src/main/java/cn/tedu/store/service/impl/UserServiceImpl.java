package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.ChangePwdException;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.PasswordFormatException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateDataException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameConflictException;
import cn.tedu.store.service.ex.UsernameFormatException;
import cn.tedu.store.util.TextValidator;

/**
 * �û����ݵ�ҵ���
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	public User reg(User user) throws UsernameConflictException, InsertDataException {
		// * ��λ����֯ҵ�񣬱�֤���ݵİ�ȫ��
		// ���ݳ���ע����û�����ѯ�û�����
		User data = findUserByUsername(user.getUsername());
		// �ж��Ƿ��ѯ������
		if (data != null) {
			// �ǣ���ѯ�����ݣ����û�����ռ�ã����׳�UsernameConflictException�쳣
			throw new UsernameConflictException("用户名(" + user.getUsername() + ")已经存在！");
		} else {
			// ��û�в�ѯ�����ݣ����û���û�б�ռ�ã���ִ�в����û����ݣ���ȡ����ֵ
			User result = insert(user);
			// ִ�з���
			return result;
		}
	}

	public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		// 验证用户名与密码的格式是否正确
		if (!TextValidator.checkUsername(username)) {
			throw new UsernameFormatException("用户名格式不正确");
		}
		if (!TextValidator.checkPassword(password)) {
			throw new PasswordFormatException("用户密码格式不正确");
		}
		// �����û�����ѯ�û�����
		User user = findUserByUsername(username);
		// �ж��Ƿ��ѯ������
		if (user != null) {
			// �ǣ���ѯ�����û���ƥ������ݣ���ȡ��ֵ
			String salt = user.getSalt();
			// ���ڲ�����������ֵ���м���
			String md5Password = getEncrpytedPassword(password, salt);
			// �жϼ��ܽ�����û������е������Ƿ�ƥ��
			if (user.getPassword().equals(md5Password)) {
				// �ǣ������û�����
				user.setPassword(null);
				user.setSalt(null);
				return user;
			} else {
				// �����벻��ȷ���׳�PasswordNotMatchException�쳣
				throw new PasswordNotMatchException("密码不匹配");
			}
		} else {
			// ��û�����û���ƥ������ݣ����׳�UserNotFoundException�쳣
			throw new UserNotFoundException("用户名(" + username + ")未找到！");
		}
	}
	//修改密码业务
	public User updataPwd(String username,String oldPassword,String newPassword) {
		User data=findUserByUsername(username);
		String salt=data.getSalt();
		String password=data.getPassword();
		String md5password=getEncrpytedPassword(oldPassword, salt);
		//表示验证成功
		if(md5password.equals(password)) {
		//将新密码加密
		System.out.println("未加密前："+newPassword);
		newPassword=getEncrpytedPassword(newPassword, salt);
		System.out.println("加密后："+newPassword);
		Integer rows=userMapper.changePwd(username,newPassword);
			if(rows==1) {
			data.setPassword(null);
			data.setSalt(null);
			return data;
			}else {
				throw new ChangePwdException("修改密码异常");
			}
		}else {
			throw new PasswordNotMatchException("原密码不匹配");
		}
	}
	/*
	 * 修改用户信息
	 */
	public User updateInfo(User user,Integer id) {
		user.setId(id);
		Date now=new Date();
		user.setModifiedUser("[System]");
		user.setModifiedTime(now);
		Integer rows=userMapper.updateInfo(user);
		if(rows==1) {
			System.out.println("用户信息更新成功！");
		}else {
			System.out.println("用户信息更新失败！");
		}
		return null;
	}

	/**
	 * �����û�����ѯ�û�����
	 * 
	 * @param username
	 *            �û���
	 * @return ƥ����û����ݣ����û��ƥ������ݣ��򷵻�null
	 */
	public User findUserByUsername(String username) {
		return userMapper.findUserByUsername(username);
	}
	/*
	 * 获取用户信息by Id;
	 */
	public User findUserById(Integer id) {
		return userMapper.findUserById(id);
	}


	/**
	 * �����û�����
	 * 
	 * @param user
	 *            �û�����
	 * @return �ɹ�������û�����
	 */
	private User insert(User user) {
		// �ڲ���user�з�װ��Щ�����ⲿ�ṩ�����ݣ�
		// 1. ��������Σ�����װ��user��
		String salt = UUID.randomUUID().toString().toUpperCase();
		user.setSalt(salt);
		// 2. ȡ��user��ԭ����ִ�м��ܣ�����װ��user��
		String oldPassword = user.getPassword();
		String md5Password = getEncrpytedPassword(oldPassword, salt);
		user.setPassword(md5Password);
		// 3. ����isDeleteΪ0
		user.setIsDelete(0);
		// 4. ��־��4��
		Date now = new Date();
		user.setCreatedTime(now);
		user.setModifiedTime(now);
		user.setCreatedUser("[System]");
		user.setModifiedUser("[System]");

		// �����û�����
		Integer rows = userMapper.insert(user);
		if (rows == 1) {
			return user;
		} else {
			throw new InsertDataException("插入用户数据异常！");
		}
	}

	/**
	 * ��ȡ���ܺ������
	 * 
	 * @param password
	 *            ����ԭ��
	 * @param salt
	 *            ��ֵ
	 * @return ���ܺ������
	 */
	private String getEncrpytedPassword(String password, String salt) {
		// ��ԭ�������
		String str1 = DigestUtils.md5Hex(password).toUpperCase();
		// ���μ���
		String str2 = DigestUtils.md5Hex(salt).toUpperCase();
		// ������2�����ܽ��ƴ��
		String result = str1 + str2;
		// ѭ��5�μ���
		for (int i = 0; i < 5; i++) {
			result = DigestUtils.md5Hex(result).toUpperCase();
		}
		// ����
		return result;
	}
	public void changeAvatar(Integer id, String avatar) throws UserNotFoundException, UpdateDataException {
			if (findUserById(id) == null) {
				throw new UserNotFoundException("用户id错误！");
			}
			updateAvatar(id, avatar);
		}
	private void updateAvatar(Integer id, String avatar) {
		Integer rows = userMapper.updateAvatar(id, avatar);
		if (rows != 1) {
			throw new UpdateDataException("用户图片更新错误！");
		}
	}




}

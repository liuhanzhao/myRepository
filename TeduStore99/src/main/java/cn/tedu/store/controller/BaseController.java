package cn.tedu.store.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.tedu.store.entity.ResponseResult;
import cn.tedu.store.service.ex.AddressAccessException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.InsertDataException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameConflictException;

/**
 * 控制器的基类
 */
public abstract class BaseController {

	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public ResponseResult<Void> handleException(Exception e) {
		    // 用户名重复
		if (e instanceof UsernameConflictException) {
			return new ResponseResult<Void>(401, e);
			// 数据插入错误
		} else if (e instanceof InsertDataException) {
			return new ResponseResult<Void>(501, e);
			// 用户不存在
		} else if (e instanceof UserNotFoundException) {
			return new ResponseResult<Void>(402, e);
			//密码不匹配
		}else if(e instanceof PasswordNotMatchException) {
			return new ResponseResult<Void>(403,e);
		}else if(e instanceof AddressAccessException) {
			return new ResponseResult<Void>(404,e);
		}else if(e instanceof AddressNotFoundException) {
			return new ResponseResult<Void>(405,e);
		}
		return null;
	}

}

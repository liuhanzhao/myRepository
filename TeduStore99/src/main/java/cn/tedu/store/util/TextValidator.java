package cn.tedu.store.util;
/*
 * 文本验证类
 */
public  final class TextValidator {
	private TextValidator() {
		super();
	}
	
/*
 * 验证用户的正则表达式
 */
private static final String REGEX_USERNAME="[a-zA-Z]{1}[a-zA-Z0-9]{3,15}";
private static final String REGEX_PHONE="[0-9]{11}";
private static final String REGEX_EMAIL="[@]{1}[a-zA-Z0-9]+[.]+[a-z]+";
/*
 * 验证用户名格式
 * @Param username 用户名
 * @Return 返回true时表示符合格式要求
 */
public static boolean checkUsername(String username) {
	if(username==null) {
		return false;
	}
		return username.matches(REGEX_USERNAME);
}

/*
 * 验证密码格式
 */
public static boolean checkPassword(String password) {
	if(password==null) {
		return false;
	}
	return password.length()>=4&&password.length()<=16;
	
}
/*
 * 验证手机号码格式
 */
public static boolean checkPhone(String phone) {
	if(phone==null) {
		return false;
	}
	return phone.matches(REGEX_PHONE);
}
/*
 * 验证邮箱格式
 */
public static boolean checkEmail(String email) {
	if(email==null) {
		return false;
	}
	return email.matches(REGEX_EMAIL);
}
}

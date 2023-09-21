package com.exampro.utils.passwd;

import com.exampro.utils.file.MD5Util;
import org.springframework.stereotype.Component;

/**
 * 通用的密码处理类，用于生成密码和校验密码
 * ClassName: PassGenerator <br/>
 */
@Component
public class PassHandler {

	/**
	 * checkPass:校验密码是否一致
	 * @param inputPass 用户传入的密码
	 * @param salt 数据库保存的密码随机码
	 * @param pass 数据库保存的密码MD5
	 * @return
	 */
	public  boolean checkPass(String inputPass , String salt , String pass){
		String pwdMd5 = MD5Util.MD5(inputPass);
		return MD5Util.MD5(pwdMd5 + salt).equals(pass);
	}
	
	
	/**
	 * buildPassword:用于用户注册时产生一个密码
	 * @param inputPass 输入的密码
	 * @return PassInfo 返回一个密码对象，记得保存
	 */
	public  PassInfo buildPassword(String inputPass) {

		//加密的随机码
		String salt = "exampro^0^";
		//加密后的密码
		String encryptPassword = MD5Util.MD5(MD5Util.MD5(inputPass)+salt);
		//返回对象
		return new PassInfo(salt,encryptPassword);
	}

//	/**
//	 * 测试方法
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		PassInfo info = buildPassword("1234567");
//		System.out.println(info.getPassword());
//		System.out.println(checkPass("123456",info.getSalt(),info.getPassword()));
//	}

}

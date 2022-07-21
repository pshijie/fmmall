package com.psj.fmmall.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// MD5生成器
public class MD5Utils {
	public static String md5(String password){
		//生成一个md5加密器
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算MD5 的值
			md.update(password.getBytes());
			// BigInteger将8位的字符串转成16位的字符串，得到的字符串形式是哈希码值
			// BigInteger(参数1,参数2) 参数1为'1'时表示正数,'0'表示0,'-1'表示负数
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}

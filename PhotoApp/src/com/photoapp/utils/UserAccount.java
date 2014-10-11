package com.photoapp.utils;

import com.photoapp.domain.UserInfo;


/**
 * Global user account
 * @author amansharma
 *
 */
public class UserAccount {
	
	private static UserAccount account;
	private UserInfo info;
	
	private UserAccount(UserInfo info) {
		this.info = info;
	}
	
	public static UserAccount getInstance() {
		return account;
	}
	
	public static void init(UserInfo info) {
		account = new UserAccount(info);
	}

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}
	
	

}

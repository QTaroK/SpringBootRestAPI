package com.example.demo.dto;

import com.example.demo.model.User;

/**
 * 会員クラス
 */
public class UserDto {

	/**
	 * ユーザーNo
	 */
	private int userNumber;

	/**
	 * ユーザー名
	 */
	private String userName;

	/**
	 * ユーザー住所
	 */
	private String userAddress;

	/**
	 * ユーザーメールアドレス
	 */
	private String userEmailAddress;

	public UserDto() {

	}

	public UserDto(User user) {
		this.userNumber = user.getUserId();
		this.userName = user.getUserName();

	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

}

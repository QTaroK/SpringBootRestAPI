package com.example.demo.model;

import com.example.demo.dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`user`")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

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

	public User() {

	}

	public User(UserDto userDto) {
		this.userId = userDto.getUserNumber();
		this.userName = userDto.getUserName();
		this.userEmailAddress = userDto.getUserEmailAddress();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

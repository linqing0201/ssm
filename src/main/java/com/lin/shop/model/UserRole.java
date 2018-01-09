package com.lin.shop.model;

import java.io.Serializable;

import com.lin.shop.common.BaseEntity;

public class UserRole extends BaseEntity implements Serializable{
	private Long userId;
	private Long roleId;
	
	public UserRole(Long userId,Long roleId){
		this.userId=userId;
		this.roleId=roleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}

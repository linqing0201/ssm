package com.lin.shop.model;

import java.io.Serializable;

import com.lin.shop.common.BaseEntity;

public class RolePermission extends BaseEntity implements Serializable{
	private Long roleId;
	private Long permissionId;
	
	public RolePermission(Long roleId,Long permissionId){
		this.roleId=roleId;
		this.permissionId=permissionId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}
}

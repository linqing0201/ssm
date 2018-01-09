package com.lin.shop.dao;

import java.util.List;

import com.lin.shop.common.BaseDao;
import com.lin.shop.model.Permission;

public interface PermissionDao extends BaseDao<Permission>{
	void addPermission(Permission permission);
	void deletePermission(Long permissionId);
	Permission findById(Long permId);
	List<Permission> findNavisByRoleId(Long roleId);
	List<Permission> findPermissionsByRoleId(Long roleId);
	List<Permission> findAllPermissions();
	void updatePermission(Permission permission);
	
	void deleteRolePermission(Long permissionId);
}

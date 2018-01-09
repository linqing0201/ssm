package com.lin.shop.dao;

import java.util.List;

import com.lin.shop.common.BaseDao;
import com.lin.shop.model.Role;
import com.lin.shop.model.RolePermission;
import com.lin.shop.model.User;

public interface RoleDao  extends BaseDao<Role>{
	void addRole(Role role);
	void deleteRole(Long roleId);
	Role findById(Long roleId);
	List<Role> findRolesByUserName(String userName);
	List<Role> findAllRoles();
	void updateRole(Role role);

	void deleteUserRole(Long roleId);
	void deleteRolePermission(Long roleId);
	void addRolePermission(RolePermission rolePermission);
}

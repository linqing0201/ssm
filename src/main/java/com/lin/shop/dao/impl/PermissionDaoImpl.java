package com.lin.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.shop.common.BaseDaoImpl;
import com.lin.shop.dao.PermissionDao;
import com.lin.shop.model.Permission;

@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao{

	public void addPermission(Permission permission) {
		 super.getSqlSession().insert(getStatement("addPermission"), permission);
		
	}

	public void deletePermission(Long permissionId) {
		getSqlSession().delete(getStatement("deletePermission"), permissionId);		
	}

	public Permission findById(Long permId) {
		return getSqlSession().selectOne(getStatement("findById"), permId);
	}

	public List<Permission> findNavisByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(getStatement("findNavisByRoleId"), roleId);
	}

	public List<Permission> findPermissionsByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(getStatement("findPermissionsByRoleId"), roleId);
	}

	public List<Permission> findAllPermissions() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(getStatement("findAllPermissions"));
	}

	public void updatePermission(Permission permission) {
		// TODO Auto-generated method stub
		getSqlSession().update(getStatement("updatePermission"), permission);
	}

	public void deleteRolePermission(Long permissionId) {
		// TODO Auto-generated method stub
		getSqlSession().delete(getStatement("deleteRolePermission"), permissionId);
	}

}

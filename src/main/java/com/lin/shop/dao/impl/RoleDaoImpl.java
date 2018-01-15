package com.lin.shop.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lin.shop.common.BaseDaoImpl;
import com.lin.shop.dao.RoleDao;
import com.lin.shop.model.Role;
import com.lin.shop.model.RolePermission;
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	public long insert(Role entity) {
		
		return getSqlSession().insert(getStatement(SQL_INSERT), entity);
	}

	public long insert(List<Role> list) {
		// TODO Auto-generated method stub
		return getSqlSession().insert(getStatement(SQL_BATCH_INSERT), list);
	}

	public int update(Role entity) {
		// TODO Auto-generated method stub
		return getSqlSession().update(getStatement(SQL_UPDATE), entity);
	}

	public int update(List<Role> list) {
		// TODO Auto-generated method stub
		return getSqlSession().update(getStatement(SQL_BATCH_UPDATE), list);
	}

	public Role getById(long id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getStatement("getById"), id);
	}

	public Role getBy(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getStatement("getBy"), paramMap);
	}

	public void addRole(Role role) {
		// TODO Auto-generated method stub
		getSqlSession().insert(getStatement("addRole"), role);
	}

	public void deleteRole(Long roleId) {
		// TODO Auto-generated method stub
		getSqlSession().delete(getStatement("deleteRole"), roleId);
	}

	public Role findById(Long roleId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getStatement("findById"), roleId);
	}

	public List<Role> findRolesByUserName(String userName) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(getStatement("findRolesByUserName"), userName);
	}

	public List<Role> findAllRoles() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(getStatement("findAllRoles"));
	}

	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		getSqlSession().update(getStatement("updateRole"), role);
	}

	public void deleteUserRole(Long roleId) {
		getSqlSession().delete(getStatement("deleteUserRole"), roleId);		
	}

	public void deleteRolePermission(Long roleId) {
		// TODO Auto-generated method stub
		getSqlSession().delete(getStatement("deleteRolePermission"), roleId);		
	}

	public void addRolePermission(RolePermission rolePermission) {
		// TODO Auto-generated method stub
		getSqlSession().insert(getStatement("addRolePermission"), rolePermission);
	}

}

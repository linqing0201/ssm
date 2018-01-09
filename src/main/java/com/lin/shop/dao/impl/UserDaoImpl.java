package com.lin.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lin.shop.common.BaseDaoImpl;
import com.lin.shop.dao.UserDao;
import com.lin.shop.model.User;
import com.lin.shop.model.UserRole;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	public void addUser(User user) {
		getSqlSession().insert(getStatement("addUser"),user);
		
	}

	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		getSqlSession().delete(getStatement("deleteUser"), userId);
	}

	public User findUserByUserName(String userName) {
		return super.getSqlSession().selectOne(getStatement("findUserByUserName"), userName);
	}

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList(getStatement("findAllUsers"));
	}

	public void deleteUserRole(Long userId) {
		getSqlSession().delete(getStatement("deleteUserRole"), userId);
		
	}

	public void addUserRole(UserRole userRole) {
		getSqlSession().insert(getStatement("addUserRole"),userRole);
		
	}

	public List<String> findRolesByUserName(String userName) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(getStatement("findRolesByUserName"), userName);
	}

	public List<String> findPermissionsByUserName(String userName) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(getStatement("findPermissionsByUserName"), userName);
	}

}

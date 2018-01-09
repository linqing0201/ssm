package com.lin.shop.dao;

import java.util.List;

import com.lin.shop.common.BaseDao;
import com.lin.shop.model.User;
import com.lin.shop.model.UserRole;

public interface UserDao extends BaseDao<User>{
	void addUser(User user);
	void deleteUser(Long userId);
	User findUserByUserName(String userName);
	List<User> findAllUsers();
	
	void deleteUserRole(Long userId);
	void addUserRole(UserRole userRole);
	
	List<String> findRolesByUserName(String userName);
	List<String> findPermissionsByUserName(String userName);
}

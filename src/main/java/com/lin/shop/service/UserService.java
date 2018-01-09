package com.lin.shop.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.shop.dao.PermissionDao;
import com.lin.shop.dao.RoleDao;
import com.lin.shop.dao.UserDao;
import com.lin.shop.model.Navigation;
import com.lin.shop.model.Role;
import com.lin.shop.model.User;
import com.lin.shop.model.UserRole;

@Service
public class UserService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private PasswordService passwordService;

	public void addUser(User user, Long... roleIds) {
		passwordService.encryptPassword(user);
		userDao.addUser(user);
		if(roleIds!=null&&roleIds.length>0){
			for(Long roleId:roleIds){
				userDao.addUserRole(new UserRole(user.getUserId(),roleId));
			}
		}
	}

	public void deleteUser(Long userId) {
		userDao.deleteUserRole(userId);
		userDao.deleteUser(userId);
	}

	public void deleteMoreUsers(Long... userIds) {
		if(userIds!=null&&userIds.length>0){
			for(Long userId:userIds){
				deleteUser(userId);
			}
		}
	}

	public User getUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

	public List<User> getAllUsers() {
		return userDao.findAllUsers();
	}

	public void updateUserRoles(Long userId, Long... roleIds) {
		userDao.deleteUserRole(userId);
		if(roleIds!=null&&roleIds.length>0){
			for(Long roleId:roleIds){
				userDao.addUserRole(new UserRole(userId,roleId));
			}
		}
	}

	public Set<String> findRolesByUserName(String userName) {
		return new HashSet<String>(userDao.findRolesByUserName(userName));
	}

	public Set<String> findPermissionsByUserName(String userName) {
		return new HashSet<String>(userDao.findPermissionsByUserName(userName));
	}

	public List<Navigation> getNavigationBar(String userName) {
		List<Navigation> navigationBar=new ArrayList<Navigation>();
		Navigation navigation;
		List<Role> roles=roleDao.findRolesByUserName(userName);
		for(Role role:roles){
			navigation=new Navigation();
			navigation.setNavigationName(role.getRoleDesc());
			navigation.setChildNavigations(
					permissionDao.findNavisByRoleId(role.getRoleId()));
			navigationBar.add(navigation);
		}
		return navigationBar;
	}

}

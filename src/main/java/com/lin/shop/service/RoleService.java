package com.lin.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.shop.dao.RoleDao;
import com.lin.shop.model.Role;
import com.lin.shop.model.RolePermission;

@Service
public class RoleService{

	@Autowired
	private RoleDao roleDao;
	
	public Long addRole(Role role, Long... permissionIds) {
		roleDao.addRole(role);
		if(permissionIds!=null&&permissionIds.length>0){
			for(Long permissionId:permissionIds){
				roleDao.addRolePermission(new RolePermission(role.getRoleId(),permissionId));
			}
		}
		return role.getRoleId();
	}

	public void deleteRole(Long roleId) {
		roleDao.deleteUserRole(roleId);
		roleDao.deleteRolePermission(roleId);
		roleDao.deleteRole(roleId);
	}

	public void deleteMoreRoles(Long... roleIds) {
		if(roleIds!=null&&roleIds.length>0){
			for(Long roleId:roleIds){
				deleteRole(roleId);
			}
		}
	}

	public Role getRoleById(Long roleId) {
		return roleDao.findById(roleId);
	}

	public List<Role> getRolesByUserName(String userName) {
		return roleDao.findRolesByUserName(userName);
	}

	public List<Role> getAllRoles() {
		return roleDao.findAllRoles();
	}

	public void updateRole(Role role,Long...permIds) {
		roleDao.updateRole(role);
		roleDao.deleteRolePermission(role.getRoleId());
		addRolePermissions(role.getRoleId(),permIds);
	}

	public void addRolePermissions(Long roleId, Long... permissionIds) {
		if(permissionIds!=null&&permissionIds.length>0){
			for(Long permissionId:permissionIds){
				roleDao.addRolePermission(new RolePermission(roleId,permissionId));
			}
		}
	}

}

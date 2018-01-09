package com.lin.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.shop.dao.PermissionDao;
import com.lin.shop.model.Permission;

@Service
public class PermissionService {

	@Autowired
	private PermissionDao PermissionDao;
	
	public Long addPermission(Permission permission) {
		PermissionDao.addPermission(permission);
		return permission.getPermissionId();
	}

	public void deletePermission(Long permissionId) {
		PermissionDao.deleteRolePermission(permissionId);
		PermissionDao.deletePermission(permissionId);
	}

	public void deleteMorePermissions(Long... permIds) {
		if(permIds!=null&&permIds.length>0){
			for(Long permId:permIds){
				deletePermission(permId);
			}
		}
	}

	public Permission findById(Long permId) {
		return PermissionDao.findById(permId);
	}

	public List<Permission> getPermissionsByRoleId(Long roleId) {
		return PermissionDao.findPermissionsByRoleId(roleId);
	}

	public List<Permission> getAllPermissions() {
		return PermissionDao.findAllPermissions();
	}

	public void updatePermission(Permission permission) {
		PermissionDao.updatePermission(permission);
	}

}

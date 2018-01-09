package com.lin.shop.dao;

import java.util.List;
import java.util.Map;

import com.lin.shop.common.BaseDao;
import com.lin.shop.model.Users;

public interface UsersDao extends BaseDao<Users>{

	public List<Users> listBy(Map<String,Object> map);
	public Users getById(Long id);
}

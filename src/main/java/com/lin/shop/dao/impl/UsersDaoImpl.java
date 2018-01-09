package com.lin.shop.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lin.shop.common.BaseDaoImpl;
import com.lin.shop.dao.UsersDao;
import com.lin.shop.model.Users;

@Repository
public class UsersDaoImpl extends BaseDaoImpl<Users>  implements UsersDao{

	public List<Users> listBy(Map<String, Object> map) {
		return super.getSqlSession().selectList(SQL_LIST_BY, map);
	}

	public Users getById(Long id) {
		return super.getSqlSession().selectOne(SQL_GET_BY_ID, id);
	}

	
}

package com.lin.shop.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.UserDataHandler;

import com.lin.shop.common.PageBean;
import com.lin.shop.common.PageParam;
import com.lin.shop.dao.UsersDao;
import com.lin.shop.model.Users;

@Service
public class UsersBiz {

	@Autowired
	private UsersDao usersDao;
	@Transactional(readOnly=true)
	public List<Users> listBy(Map<String,Object> map){
		List<Users> listBy = usersDao.listBy(map);
		return listBy;
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public Long insert(Users users){
		long result = usersDao.insert(users);
		return result;
	}
	public Users getById(Long id){
		return usersDao.getById(id);
	}
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public int update(Users user){
		return usersDao.update(user);
	}
	public PageBean listPage(PageParam pageParam,Map<String, Object> map) {
		return  usersDao.listPage(pageParam, map);
	}
}

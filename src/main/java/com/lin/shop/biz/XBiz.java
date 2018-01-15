package com.lin.shop.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.shop.dao.XDao;
import com.lin.shop.model.X;

@Service
public class XBiz {

	@Autowired
	private XDao xDao;
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public void insert(X x){
		xDao.insert(x);
	}
}

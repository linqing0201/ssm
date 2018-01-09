package com.lin.shop.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.shop.biz.UsersBiz;
import com.lin.shop.common.PageBean;
import com.lin.shop.common.PageParam;
import com.lin.shop.model.Users;

@Controller
@RequestMapping(value="hello")
public class Hello {
	@Autowired
	private UsersBiz usersBiz;
	
	@RequestMapping(value="a")
	@ResponseBody
	public String a(){
		return "hello";
	}
	@RequestMapping(value="/listBy",method=RequestMethod.POST)
	@ResponseBody
	public List<Users> listBy(@RequestParam Map<String,Object> map){
		List<Users> listBy = usersBiz.listBy(map);
		System.out.println(listBy);
		return listBy;
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public Long insert(Users users){
		long result = usersBiz.insert(users);
		return result;
	}
	@RequestMapping(value="/getById",method=RequestMethod.POST)
	@ResponseBody
	public Users getById(@RequestParam Long id){
		return usersBiz.getById(id);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public int update(Users user){
		return usersBiz.update(user);
	}
	@RequestMapping(value="/listPage",method=RequestMethod.POST)
	@ResponseBody
	public PageBean listPage(@RequestParam Map<String,Object> map){
		PageParam pageParam=new PageParam(Integer.parseInt(map.get("pageNum").toString()), Integer.parseInt(map.get("numPerPage").toString()));
		return usersBiz.listPage(pageParam,map);
	}
}

package com.lin.shop.shiro.filter;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.lin.shop.service.UserService;

public class WithNavibarFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private UserService userService;
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest httpReq=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String userName=(String)SecurityUtils.getSubject().getPrincipal();
		List navigationBar=userService.getNavigationBar(userName);
		httpReq.getSession().setAttribute("navibar", navigationBar);
		res.sendRedirect("index");
		return true;
	}
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		System.out.println(e);
		return super.onLoginFailure(token, e, request, response);
	}
	
}

package com.lin.shop.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RsaInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		@SuppressWarnings("unchecked")
		Map<String, Object> parameterMap = (Map<String, Object>)request.getParameterMap();
		for (Entry<String, Object> entry : parameterMap.entrySet()) {
			 System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			 System.out.println(parameterMap.get(entry.getKey()));
			 System.out.println(request.getParameter(entry.getKey()));
		}
		 //一系列处理后发现session已经失效
//        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ //如果是ajax请求响应头会有x-requested-with  
//        	System.out.println();
//        	return true;
//        }else{
//            //非ajax请求时，session失效的处理
//        }
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}

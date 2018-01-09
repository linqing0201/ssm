package com.lin.shop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.lin.shop.common.Constants;
import com.lin.shop.model.TsUser;

/**
 * MyWebSocketInterceptor拦截用户登录信息，
 * 并将用户登录信息交给websocket的WebSocketSession来管理，
 * 因为这样websocket就可以知道用户是否在线，是否不在线了，而且还能给别的用户发送消息，非常的方便。
 * @author admin
 *
 */
public class MyWebSocketInterceptor implements HandshakeInterceptor {
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		// 将ServerHttpRequest转换成request请求相关的类，用来获取request域中的用户信息
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpServletRequest httpRequest = servletRequest.getServletRequest();
			// Constants.CURRENT_USER这个是我定义的常量，是request域的key，通过key就可以获取到用户信息了
//			TsUser user = (TsUser) httpRequest
//					.getAttribute(Constants.CURRENT_USER.getName());
//			// Constants.CURRENT_WEBSOCKET_USER也是常量，用来存储WebsocketSession的key值
//			attributes.put(Constants.CURRENT_WEBSOCKET_USER.getName(), user.getUserid());
		}
		return true;
	}

	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
	}
}

package com.lin.shop.action;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Configuration注解该类，等价于XML中配置beans标签，@Bean相当于spring 
 * xml里面的bean标签，@EnableWebSocket这个注解用于springmvc对websocket的支持。
 * 
 *其中WebSocketPushHandler是websocket消息处理类
 *，包括窗口打开，关闭，信息发送，错误信息监听等功能。
 *MyWebSocketInterceptor是登录信息拦截处理的类
 *  ，都是自定义的，名字可以自己取，后面会有代码演示。
 * 
 * 1：/
 *  webSocketServer这个请求网址是普通浏览器访问所用
 *  ，使用大多数浏览器支持websocket
 * 
 *  2：/sockjs/webSocketServer
  是适应IE低版本浏览器所用的，
 * 因为IE11以下的浏览器都不支持websocket，
 *所以需要前台jsp页面用这个网址访问注册对应的注册器
 * 。
 * @author admin
 *
 */
@Configuration  
@EnableWebSocket
@EnableWebMvc
public class WebSocketConfig extends WebMvcConfigurerAdapter implements
		WebSocketConfigurer {

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(WebSocketPushHandler(), "/webSocketServer.do")
				.addInterceptors(new MyWebSocketInterceptor());
		registry.addHandler(WebSocketPushHandler(), "/sockjs/webSocketServer")
				.addInterceptors(new MyWebSocketInterceptor()).withSockJS();

	}

	@Bean
	public WebSocketHandler WebSocketPushHandler() {
		return new WebSocketPushHandler();
	}

}

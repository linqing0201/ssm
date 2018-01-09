package com.lin.shop.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.lin.shop.biz.UsersBiz;
import com.lin.shop.model.Users;

@Controller
@RequestMapping(value = "/test")
public class Test {
	@Autowired
	private UsersBiz usersBiz;

	@RequestMapping(value = "/main")
	public ModelAndView main() {
		return new ModelAndView("1");
	}

	/**
	 * 注入发送消息类实例
	 * 
	 * @return
	 */
	@Bean
	public WebSocketPushHandler getWebSocketPushHandler() {
		return new WebSocketPushHandler();
	}

	/**
	 * 根据用户获取消息内容
	 */
	public TextMessage getMsgByUserId(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Users> listBy = usersBiz.listBy(map);
		resultMap.put("test", "qing");
		ObjectMapper mapper = new ObjectMapper();
		String msg = "";
		try {
			msg = mapper.writeValueAsString(listBy);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new TextMessage(msg);
	}

	@RequestMapping(value = "/1")
	@ResponseBody
	public void send(@RequestParam Map<String, Object> map) {
		getWebSocketPushHandler().sendMessagesToUsers(getMsgByUserId(map));
	}
}

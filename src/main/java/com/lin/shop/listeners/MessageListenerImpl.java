package com.lin.shop.listeners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.lin.shop.biz.XBiz;
import com.lin.shop.model.X;

public class MessageListenerImpl implements MessageListenerConcurrently {

	private Logger log = LoggerFactory.getLogger(MessageListenerImpl.class);
	@Autowired
	private XBiz xBiz;
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
			ConsumeConcurrentlyContext context) {
		for (MessageExt messageExt : msgs) {
			log.info(messageExt.toString());
			System.out.println(new String(messageExt.getBody()));
		}
		log.info("getDelayLevelWhenNextConsume="
				+ context.getDelayLevelWhenNextConsume() + "getMessageQueue="
				+ context.getMessageQueue().toString()
				+ "getDelayLevelWhenNextConsume="
				+ context.getDelayLevelWhenNextConsume());
		X x =new X();
		x.setVersion(1);
		x.setC("getDelayLevelWhenNextConsume="
				+ context.getDelayLevelWhenNextConsume() + "getMessageQueue="
				+ context.getMessageQueue().toString()
				+ "getDelayLevelWhenNextConsume="
				+ context.getDelayLevelWhenNextConsume());
		xBiz.insert(x);
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

}

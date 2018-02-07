package com.lin.shop.listeners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.lin.shop.biz.XBiz;
import com.lin.shop.model.X;

public class MessageOrderListener implements MessageListenerOrderly{
	private Logger log = LoggerFactory.getLogger(MessageOrderListener.class);
	@Autowired
	private XBiz xBiz;
	public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs,
			ConsumeOrderlyContext context) {
		for (MessageExt messageExt : msgs) {
			log.info(messageExt.toString());
			X x =new X();
			x.setVersion(1);
			x.setC(new String(messageExt.getBody()));
			try {
				xBiz.insert(x);
			} catch (Exception e) {
				e.printStackTrace();
				if(messageExt.getReconsumeTimes()==3){
					return ConsumeOrderlyStatus.SUCCESS;
				}else{
					return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
				}
				
			}
			System.out.println(new String(messageExt.getBody()));
			System.out.println("------------------------");
		}
		return ConsumeOrderlyStatus.SUCCESS;
	}

}

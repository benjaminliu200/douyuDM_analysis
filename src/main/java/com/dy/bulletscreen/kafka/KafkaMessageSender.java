package com.dy.bulletscreen.kafka;

import com.dy.bulletscreen.client.DyBulletScreenClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

import java.util.UUID;

/**
 * 描述：kafka消息发送器<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/7/31<br>
 */
public class KafkaMessageSender {
	org.apache.log4j.Logger logger = Logger.getLogger(KafkaMessageSender.class);
	private KafkaProducer<Integer, String> kafkaProducer;
	private String topic;

	/**
	 * 发送消息
	 * 
	 * @param object
	 */
	public void send(String message) {
		String key = UUID.randomUUID().toString();
		logger.debug("准备发送kafka消息,key:"+ key +",内容:" + message);
		try {
			kafkaProducer.send(new ProducerRecord<Integer, String>(topic, message));
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		logger.debug("发送kafka消息完毕,key:" + key);

	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public KafkaProducer<Integer, String> getKafkaProducer() {
		return kafkaProducer;
	}

	public void setKafkaProducer(KafkaProducer<Integer, String> kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

}

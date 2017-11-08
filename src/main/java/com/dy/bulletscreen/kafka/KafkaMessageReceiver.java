package com.dy.bulletscreen.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;

/**
 * 描述：kafka消息接收器<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/7/31<br>
 */
public class KafkaMessageReceiver {
	Logger logger = Logger.getLogger(KafkaMessageReceiver.class);

	private KafkaConsumer<Integer, String> kafkaConsumer;
	private String topic;
	/** 是否开启了自动提交 */
	private Boolean autoCommit = true;
	/** 消息处理 */
	private KafkaMessageHandler kafkaMessageHandler;

	/** 初始化方法 */
	public void init() {
		kafkaConsumer.subscribe(Arrays.asList(topic));
		Runnable runnable = () -> {
            while (true) {
                ConsumerRecords<Integer, String> records = kafkaConsumer.poll(200);
                for (ConsumerRecord<Integer, String> record : records) {
//						logger.debug("message received,offset:{},value:{}", record.offset(), record.value());
                    logger.debug("message received,offset:"+ record.offset()+",value:" +record.value());
                    String message = record.value();
                    if (kafkaMessageHandler == null) {
                        logger.warn("kafkaMessageHandler is null.");
                        continue;
                    }
                    boolean success = kafkaMessageHandler.handle(message);
                    logger.debug("是否入库成功" + success);
                    if (success && !autoCommit) {
                        kafkaConsumer.commitSync(Collections.singletonMap(new TopicPartition(topic, record.partition()), new OffsetAndMetadata(record.offset() + 1)));
                    }
                }
            }
        };
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public KafkaConsumer<Integer, String> getKafkaConsumer() {
		return kafkaConsumer;
	}

	public void setKafkaConsumer(KafkaConsumer<Integer, String> kafkaConsumer) {
		this.kafkaConsumer = kafkaConsumer;
	}

	public KafkaMessageHandler getKafkaMessageHandler() {
		return kafkaMessageHandler;
	}

	public void setKafkaMessageHandler(KafkaMessageHandler kafkaMessageHandler) {
		this.kafkaMessageHandler = kafkaMessageHandler;
	}

	public Boolean getAutoCommit() {
		return autoCommit;
	}

	public void setAutoCommit(Boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

}

package com.dy.bulletscreen.kafka;

/**
 * kafka消息接收的处理接口,用于实现自定义逻辑 <br>
 * 版权: Copyright (c) 2011-2016<br>
 * 公司: 北京活力天汇<br>
 * 
 * @author: 刘德咏<br>
 * @date: 2016年10月19日<br>
 */
public interface KafkaMessageHandler {
	/** 处理消息,处理成功返回true,处理失败返回false */
	boolean handle(String message);
}

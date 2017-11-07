package com.dy.bulletscreen.kafka.impl;

import com.dy.bulletscreen.kafka.KafkaMessageHandler;
import com.dy.bulletscreen.utils.ParseDYMsg;
import com.dy.bulletscreen.dao.DMCountDAO;
import com.dy.bulletscreen.dao.DMDetailDAO;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * 描述：斗鱼弹幕入库处理器<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/11/6<br>
 */
public class CustomKafkaMessageHandler implements KafkaMessageHandler {
	Logger logger = Logger.getLogger(CustomKafkaMessageHandler.class);

	private DMCountDAO dmCountDAO;

	private DMDetailDAO dmDetailDAO;

	@Override
	public boolean handle(String message) {
		try {
			logger.debug("入库message:" + message);
			Map<String, String> data = ParseDYMsg.parse(message.toString());
			// logger.debug("map数据:{}" + data);
			String nickName = data.get("nn");
			String uid = data.get("uid");
			String txt = data.get("txt");
			String roomid = data.get("rid");
			// step1 存储弹幕总数库
			if (dmCountDAO.queryTodayCountByUid(uid, roomid)) {
				// 今天uid这个用户发过弹幕
				dmCountDAO.updateCount(uid, roomid);
			} else {
				dmCountDAO.save(uid, nickName, roomid);
			}
			// step2 存储弹幕细节库
			dmDetailDAO.save(uid, txt, roomid);
			return true;
		} catch (Exception e) {
			logger.error("Exception", e);
		}
		return false;
	}

	public void setDmCountDAO(DMCountDAO dmCountDAO) {
		this.dmCountDAO = dmCountDAO;
	}

	public void setDmDetailDAO(DMDetailDAO dmDetailDAO) {
		this.dmDetailDAO = dmDetailDAO;
	}
}

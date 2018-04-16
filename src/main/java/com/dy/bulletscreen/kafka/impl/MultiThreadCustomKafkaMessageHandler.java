package com.dy.bulletscreen.kafka.impl;

import com.dy.bulletscreen.dao.DMCountDAO;
import com.dy.bulletscreen.dao.DMDetailDAO;
import com.dy.bulletscreen.kafka.KafkaMessageHandler;
import com.dy.bulletscreen.utils.ParseDYMsg;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 描述：多线程斗鱼弹幕入库处理器<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/11/6<br>
 */
public class MultiThreadCustomKafkaMessageHandler implements KafkaMessageHandler {
    private Logger logger = LoggerFactory.getLogger(MultiThreadCustomKafkaMessageHandler.class);

    @Setter
	private DMCountDAO dmCountDAO;

    @Setter
	private DMDetailDAO dmDetailDAO;

    @Setter
	private ThreadPoolTaskExecutor handleMessageTaskExecutor;

	@Override
	public boolean handle(String message) {
        logger.debug("入库message:" + message);
        FutureTask<Boolean> messageSaveFutureTask = new FutureTask<>(() -> {
            Map<String, String> data = ParseDYMsg.parse(message.toString());
            logger.debug("map数据:{}" + data);
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
            return dmDetailDAO.save(uid, txt, roomid);
        });
        try {
            handleMessageTaskExecutor.execute(messageSaveFutureTask);
            return messageSaveFutureTask.get(2000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logger.error("{}", e);
            return false;
        }
	}
}

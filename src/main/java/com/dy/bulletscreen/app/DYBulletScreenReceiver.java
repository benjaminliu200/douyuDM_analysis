package com.dy.bulletscreen.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述：弹幕kafka接收器<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/11/8<br>
 */
public class DYBulletScreenReceiver {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-kafka-receiver.xml", "app-db.xml", "app-dao.xml");
        Thread.sleep(24* 60 * 60 * 1000);
    }
}

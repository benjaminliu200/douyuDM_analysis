package com.dy.bulletscreen;

import com.dy.bulletscreen.app.DyBulletScreenApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

/**
 * 描述：Web入口类<br>
 * 版权：Copyright (c) 2011<br>
 * 公司：北京活力天汇<br>
 * 作者：童凡<br>
 * 版本：1.0<br>
 * 创建日期：2014-1-29<br>
 */
public class WebMain {
	private static Logger logger = LoggerFactory.getLogger(WebMain.class);
	public static ApplicationContext appContext;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		try {
			logger.info("准备加载程序");
			File dir = new ClassPathResource("").getFile();
			logger.info(dir.toString());

			appContext = new ClassPathXmlApplicationContext("app-*.xml");
			DyBulletScreenApplication bean = appContext.getBean(DyBulletScreenApplication.class);
			bean.main(null);
			logger.info("加载完成");
		} catch (Exception e) {
			logger.error("主程序出错:", e);
		}

	}

}

package com.dy.bulletscreen.app;

import com.dy.bulletscreen.client.DyBulletScreenClient;
import com.dy.bulletscreen.utils.KeepAlive;
import com.dy.bulletscreen.utils.KeepGetMsg;

/**
 * @summary: 弹幕Demo程序启动类 
 * @author: FerroD     
 * @date:   2016
 * -3-12
 * @version V1.0
 */
public class DyBulletScreenApplication
{
	//设置需要访问的房间ID信息
//	private static final int roomId = 533813;
//	private static final int roomId = 1854725;
//	private static final int roomId = 78561;
//	private static final int roomId = 2530148;
//	private static final int roomId = 491416;
//	private static final int roomId = 85981;
//	private static final int roomId = 138286;
	private static final int roomId = 485503;

	//弹幕池分组号，海量模式使用-9999
	private static final int groupId = -9999;
	
	public static void main(String[] args)
	{
		//初始化弹幕Client
        DyBulletScreenClient danmuClient = DyBulletScreenClient.getInstance();
        //设置需要连接和访问的房间ID，以及弹幕池分组号
        danmuClient.init(roomId, groupId);
        
        //保持弹幕服务器心跳
        KeepAlive keepAlive = new KeepAlive();
        keepAlive.start();
        
        //获取弹幕服务器发送的所有信息
        KeepGetMsg keepGetMsg = new KeepGetMsg();
        keepGetMsg.start();
	}
}
package com.dy.bulletscreen.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：解析弹幕msg到一个map中<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/11/6<br>
 */
public class ParseDYMsg {
    public static Map<String, String> parse(String msg) {
        String subMsg = msg.substring(1, msg.length() - 1);
        String[] subMsgArr = subMsg.split(",");
        Map<String, String> result = new HashMap<String, String>();
        for(String data : subMsgArr) {
            String[] tmpArr = data.split("=");
            result.put(tmpArr[0], data.substring(tmpArr[0].length() + 1));
        }
        return result;
    }
}

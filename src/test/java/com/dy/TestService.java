package com.dy;

import com.dy.bulletscreen.utils.ParseDYMsg;
import org.junit.Test;

import java.util.Map;

/**
 * 描述：测试数据入库<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/11/7<br>
 */
public class TestService {

    @Test
    public void testParseMsg() throws Exception {
        String aa = "{nn=TD丶程序员菜鸟, col=3, bnn=正直, level=15, brid=533813, el=, bl=9, type=chatmsg, rid=533813, ct=2, uid=2899622, txt=大家好啊, ifs=1, sahf=0, ic=avanew@Sface@S201710@S25@S18@S8773c1c7497bb6d56afbaef8a6f90dd7, hc=98606198b072af3cfafa67fb81910cf0, nl=7, cid=7fc1ad4b97974ae899bb040000000000}";
        Map<String, String> data = ParseDYMsg.parse(aa);
        System.out.println(data);
        System.out.println(data.get("uid"));
    }
}

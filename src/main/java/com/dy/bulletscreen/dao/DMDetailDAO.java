package com.dy.bulletscreen.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 描述：<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/11/6<br>
 */
public class DMDetailDAO extends JdbcDaoSupport {

    public int save(String uid, String text) {
        String sql = "INSERT INTO dm_detail(uid, text, date) VALUES(?, ?, now()) ";
        return getJdbcTemplate().update(sql, uid, text);
    }
}

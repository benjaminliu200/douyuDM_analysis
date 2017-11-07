package com.dy.bulletscreen.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 描述：斗鱼弹幕数量DAO<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/11/6<br>
 */
public class DMCountDAO extends JdbcDaoSupport{

    /**
     * 当前用户第一次发弹幕
     * @param uid 用户id
     * @param nickName 用户姓名
     * @return 影响条数
     */
    public int save(String uid, String nickName, String roomId) {
        String sql = "INSERT INTO dm_count(uid, nickName, roomid, dmCount, date) VALUES (?, ?, ?, 1, now());";
        return getJdbcTemplate().update(sql, uid, nickName, roomId);
    }

    public boolean queryTodayCountByUid(String uid, String roomid) {
        String sql = "SELECT count(1) FROM  dm_count WHERE uid = ? AND DATEDIFF(date, now())=0 AND roomid=?;";
        return getJdbcTemplate().queryForObject(sql, Integer.TYPE, uid, roomid) > 0;
    }

    public int updateCount(String uid, String roomid) {
        String sql = "UPDATE dm_count set dmCount = dmCount + 1 WHERE uid = ? AND DATEDIFF(date, now())=0 AND roomid=?;";
        return getJdbcTemplate().update(sql, uid, roomid);
    }
}

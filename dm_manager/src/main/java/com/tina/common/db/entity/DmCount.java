package com.tina.common.db.entity;

import java.util.Date;

public class DmCount {
    private Integer id;

    private Integer uid;

    private Integer roomid;

    private String nickname;

    private Integer dmcount;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getDmcount() {
        return dmcount;
    }

    public void setDmcount(Integer dmcount) {
        this.dmcount = dmcount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
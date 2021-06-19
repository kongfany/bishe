package com.example.mylogin.entity;

import java.io.Serializable;

public  class VideoEntity implements Serializable{
    /**
     * id : 1
     * collectnum : 30
     * commentnum : 27
     * introduce : 回顾百年党史，增强理想信念主题团日活动
     * likenum : 35
     * name : 信科院团日活动
     * sponsor : 信息科学技术学院
     * time : 星期三
     * typeid : 1
     */

    private int id;
    private int collectnum;
    private int commentnum;
    private String introduce;
    private int likenum;
    private String name;
    private String sponsor;
    private String time;
    private int typeid;
    private int flagcollect;
    private int flaglike;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCollectnum() {
        return collectnum;
    }

    public void setCollectnum(int collectnum) {
        this.collectnum = collectnum;
    }

    public int getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(int commentnum) {
        this.commentnum = commentnum;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getLikenum() {
        return likenum;
    }

    public void setLikenum(int likenum) {
        this.likenum = likenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getFlagcollect() {
        return flagcollect;
    }

    public void setFlagcollect(int flagcollect) {
        this.flagcollect = flagcollect;
    }

    public int getFlaglike() {
        return flaglike;
    }

    public void setFlaglike(int flaglike) {
        this.flaglike = flaglike;
    }
}
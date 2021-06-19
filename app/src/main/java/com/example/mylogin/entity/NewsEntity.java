package com.example.mylogin.entity;

import java.io.Serializable;

public  class NewsEntity implements Serializable {
    /**
     * id : 1
     * introduce : 啬园建于1924年，为全国重点文物保护单位、江苏省环境教育基地、南通市爱国主义教育基地。清末状元、近代民族工业的先驱、实业家、教育家张謇先生（1853-1926）长眠于此。这里环境雅静、景色宜人。园内古木参天，有珙桐、台湾杉等珍稀树种200多种，总数万余株，为江苏南通规模最大的植物观赏园，是空气质量最好、负离子含量最高的生态园林，素有“城市氧吧”之称。
     * location : 崇川区狼山街道
     * name : 啬园
     * type : 景区
     * url : https://img.sogoucdn.com/v2/thumb/retype/ext/auto/q/60/?appid=200698&url=https://pic.baike.soso.com/ugc/baikepic2/0/20190322210152-387683346_jpeg_800_475_200940.jpg/800
     */

    private int id;
    private String introduce;
    private String location;
    private String name;
    private String type;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

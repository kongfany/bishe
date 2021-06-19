package com.example.mylogin.entity;

import java.io.Serializable;

public  class SchoolEntity implements Serializable {
    /**
     * id : 1
     * location : 崇川区啬园路
     * name : 南通大学啬园校区
     * url : http://5b0988e595225.cdn.sohucs.com/images/20180722/d796a358dd9f4cbc85525e26b705bfd4.jpeg
     */

    private int id;
    private String location;
    private String name;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
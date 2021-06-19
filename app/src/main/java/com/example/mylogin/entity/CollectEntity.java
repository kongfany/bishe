package com.example.mylogin.entity;

import java.io.Serializable;

public  class CollectEntity implements Serializable {
    /**
     * id : 1
     * eventid : 9
     */

    private int id;
    private int eventid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }
}

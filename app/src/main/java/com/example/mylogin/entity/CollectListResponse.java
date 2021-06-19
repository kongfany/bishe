package com.example.mylogin.entity;

import java.io.Serializable;
import java.util.List;

public class CollectListResponse implements Serializable {


    /**
     * code : 0
     * msg : 成功
     * data : [{"id":1,"eventid":9},{"id":4,"eventid":4}]
     */

    private int code;
    private String msg;
    private List<CollectEntity> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CollectEntity> getData() {
        return data;
    }

    public void setData(List<CollectEntity> data) {
        this.data = data;
    }

}

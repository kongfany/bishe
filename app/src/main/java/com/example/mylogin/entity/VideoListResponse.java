package com.example.mylogin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 将接口回调的jason串转化成实体类
 */
public class VideoListResponse implements Serializable {
    /**
     * code : 0
     * msg : 成功
     * data : [{"id":1,"collectnum":30,"commentnum":27,"introduce":"回顾百年党史，增强理想信念主题团日活动","likenum":35,"name":"信科院团日活动","sponsor":"信息科学技术学院","time":"星期三","typeid":1},{"id":2,"collectnum":28,"commentnum":20,"introduce":"三五之学习青年习近平，争做社会主义事业接班人","likenum":34,"name":"学习青年习近平","sponsor":"教育科学学院","time":"星期二","typeid":2},{"id":3,"collectnum":25,"commentnum":23,"introduce":"构建蓝图，志赢职场职业生涯规划大赛","likenum":33,"name":"职规赛","sponsor":"理学院","time":"星期四","typeid":3},{"id":4,"collectnum":26,"commentnum":25,"introduce":"回母校看一看，我为通大代言，寒假实践动员大会","likenum":30,"name":"寒假实践","sponsor":"电气工程学院","time":"星期五","typeid":4},{"id":5,"collectnum":27,"commentnum":17,"introduce":"红十字会救护知识和技能培训","likenum":32,"name":"救护培训","sponsor":"经济与管理学院","time":"星期一","typeid":5}]
     */

    private int code;
    private String msg;
    private List<VideoEntity> data;

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

    public List<VideoEntity> getData() {
        return data;
    }

    public void setData(List<VideoEntity> data) {
        this.data = data;
    }
}

package com.example.mylogin.entity;

import java.io.Serializable;
import java.util.List;

public class NewsListResponse implements Serializable {


    /**
     * code : 0
     * msg : 成功
     * data : [{"id":1,"introduce":"啬园建于1924年，为全国重点文物保护单位、江苏省环境教育基地、南通市爱国主义教育基地。清末状元、近代民族工业的先驱、实业家、教育家张謇先生（1853-1926）长眠于此。这里环境雅静、景色宜人。园内古木参天，有珙桐、台湾杉等珍稀树种200多种，总数万余株，为江苏南通规模最大的植物观赏园，是空气质量最好、负离子含量最高的生态园林，素有\u201c城市氧吧\u201d之称。","location":"崇川区狼山街道","name":"啬园","type":"景区","url":"https://img.sogoucdn.com/v2/thumb/retype/ext/auto/q/60/?appid=200698&url=https://pic.baike.soso.com/ugc/baikepic2/0/20190322210152-387683346_jpeg_800_475_200940.jpg/800"},{"id":2,"introduce":"滨江公园是狼山风景区的重要组成部分，位于南通市。它北面毗邻港口，西临长江，南面与黄马山景区连成一片，东面与南通市园艺博览园相连接。2005年4月正式动工兴建，总投资2.5亿元人民币。规划面积有400余亩，近30万平方米，它是利用原长江滩涂进行岸线整理开发而成，是一个集景观性、休闲性、参与性于一体的大型综合性开放式公园。","location":"崇川区滨江公园路","name":"滨江公园","type":"公园","url":"https://pic.baike.soso.com/ugc/baikepic2/0/20160715182019-1728309390.jpg/800"},{"id":3,"introduce":"南通狼山风景名胜区，是江苏省级风景名胜区、国家AAAA级风景旅游区，由军山、剑山、狼山、马鞍山、黄泥山五座山组成，总面积11.27平方公里。五山形成距今已有3.5亿至4亿年，山体占地面积0.728平方公里。佛教中，狼山为大势至菩萨道场，列为全国佛教八小名山之首。","location":"崇川区狼山镇","name":"南通狼山风景名胜区","type":"景区","url":"https://pic.baike.soso.com/ugc/baikepic2/0/20160730063149-2074603135.jpg/800"},{"id":4,"introduce":"南通海底世界是南通市展示面积最大的海洋水族馆，是第四都市体验型海洋主题海洋馆。是一座以海洋生物展览为主，集科普教育、休闲娱乐、体验互动为一体的现代都市型水族馆。","location":"崇川区狼山镇","name":"南通海底世界","type":"海洋馆","url":"https://pic.baike.soso.com/ugc/baikepic2/0/20160719234023-1352913357.jpg/800"},{"id":5,"introduce":"南通植物园位于狼山风景区内，占用125公顷的土地，种植400多种、约30000株乔木，还有500多种灌木。南通植物园于2019年9月建成。","location":"崇川区工农南路","name":"南通植物园","type":"植物园","url":"http://www.nantong.gov.cn/ntsrmzf/upload/ueditor/1538007534887.jpg"},{"id":6,"introduce":"南通大学（简称通大，Nantong University），于1912年始建，坐落于江苏省南通市，是江苏省人民政府和交通运输部共建的综合性大学，还是江苏省十五所重点建设大学成员，国家卓越医生教育培养计划、卓越教师培养计划试点高校。","location":"崇川区啬园路","name":"南通大学啬园校区","type":"校园","url":"http://5b0988e595225.cdn.sohucs.com/images/20180722/d796a358dd9f4cbc85525e26b705bfd4.jpeg"}]
     */

    private int code;
    private String msg;
    private List<NewsEntity> data;

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

    public List<NewsEntity> getData() {
        return data;
    }

    public void setData(List<NewsEntity> data) {
        this.data = data;
    }
}

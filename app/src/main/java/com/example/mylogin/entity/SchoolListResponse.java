package com.example.mylogin.entity;

import java.io.Serializable;
import java.util.List;

public class SchoolListResponse implements Serializable {


    /**
     * code : 0
     * msg : 成功
     * data : [{"id":1,"location":"崇川区啬园路","name":"南通大学啬园校区","url":"http://5b0988e595225.cdn.sohucs.com/images/20180722/d796a358dd9f4cbc85525e26b705bfd4.jpeg"},{"id":2,"location":"南通大学","name":"图书馆","url":"http://www.gxscse.com/myimg/article/110/1_jz9nn__.jpg"},{"id":3,"location":"南通大学","name":"方肇周教学楼","url":"http://m.qpic.cn/psc?/V51Bk5Mb1dY2Hy1ffJGT31ryY03U6oPl/45NBuzDIW489QBoVep5mcfcgxTw1j3*QpZAe*Ky.v8dR7tUK40BN1SHQR0Hq2XRg3dgVXeMBmqRXEfxcTIS5jsg1DTT6FuwAozXmphTMhfQ!/b&bo=OASPBgAAAAABF4U!&rf=viewer_4"},{"id":4,"location":"南通大学","name":"逸夫教学楼","url":"http://m.qpic.cn/psc?/V51Bk5Mb1dY2Hy1ffJGT31ryY03U6oPl/45NBuzDIW489QBoVep5mcfcgxTw1j3*QpZAe*Ky.v8dcmOs35kYvHilhFfU39o*oGfRt3CXFUYB1ySI1.2yPR6NUp3vFIHGIIC7O3Co8Qng!/b&bo=OATzBQAAAAABF*o!&rf=viewer_4"},{"id":5,"location":"南通大学","name":"西操","url":"http://m.qpic.cn/psc?/V51Bk5Mb1dY2Hy1ffJGT31ryY03U6oPl/45NBuzDIW489QBoVep5mcfcgxTw1j3*QpZAe*Ky.v8cjcWqBOwPsBxvbyf.M.rnXmys6s09tchSKZsQUqaxL.hmQoLd5Htqr6NEFI5*HYNU!/b&bo=OATyAwAAAAABF*0!&rf=viewer_4"},{"id":6,"location":"南通大学","name":"东操","url":"http://m.qpic.cn/psc?/V51Bk5Mb1dY2Hy1ffJGT31ryY03U6oPl/45NBuzDIW489QBoVep5mcWzImPQO2DHzJGJpfl1jLNl9*OT54jKvG9tLtUuxGDhFgXorlkFzqa3FJpCPlVu*CurBkqGF7QR4lt1NR1o9pt4!/b&bo=oAU4BAAAAAABF6k!&rf=viewer_4"},{"id":7,"location":"南通大学","name":"一食堂","url":"http://m.qpic.cn/psc?/V51Bk5Mb1dY2Hy1ffJGT31ryY03U6oPl/45NBuzDIW489QBoVep5mcfmtFtRsfEmjs15boHpEYGHLvfr356VLTMexopYW5QPOzshic4lQPQj9ReDZyB.uULCVq0zGhKDJ.36A2WV7ExQ!/b&bo=OAS*AgAAAAABF7E!&rf=viewer_4"},{"id":8,"location":"南通大学","name":"二食堂","url":"http://m.qpic.cn/psc?/V51Bk5Mb1dY2Hy1ffJGT31ryY03U6oPl/45NBuzDIW489QBoVep5mcWzImPQO2DHzJGJpfl1jLNnWkmsdVbVAXjoZUL4NMZM.CdD0GQKuBXSOtICL3FbkrZ2TMfoTPFF77pDnxTDubqg!/b&bo=OARrBAAAAAABF2M!&rf=viewer_4"}]
     */

    private int code;
    private String msg;
    private List<SchoolEntity> data;

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

    public List<SchoolEntity> getData() {
        return data;
    }

    public void setData(List<SchoolEntity> data) {
        this.data = data;
    }
}

package com.example.mylogin.entity;

public class LoginResponse {
    /**
     * code : 0
     * msg : 成功
     * data : {"id":29,"username":"root","password":"123456","email":"1","tel":"1"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 29
         * username : root
         * password : 123456
         * email : 1
         * tel : 1
         */

        private int id;
        private String username;
        private String password;
        private String email;
        private String tel;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }


    //token:保存在应用的本地，请求其他接口的时候需要带着token，表示应用已经登陆过，以便来验证这个应用是已经登陆过的
    //登录后返回的Jason串包括token
    //通过gsonformat插件：
    //把对应的key转换为实体的一个属性，自动的添加get，set方法。

}
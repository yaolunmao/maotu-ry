package com.ruoyi.webtopo.domain;

import com.alibaba.fastjson2.JSONArray;

public class WebtopoWebSocketMsg {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JSONArray getMsg() {
        return msg;
    }

    public void setMsg(JSONArray msg) {
        this.msg = msg;
    }

    private String type;
    private JSONArray msg;
}

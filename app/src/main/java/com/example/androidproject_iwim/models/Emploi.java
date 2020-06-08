package com.example.androidproject_iwim.models;

public class Emploi {
    private String desc,url,pid;

    public Emploi() {
    }

    public Emploi(String desc, String url, String pid) {
        this.desc = desc;
        this.url = url;
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

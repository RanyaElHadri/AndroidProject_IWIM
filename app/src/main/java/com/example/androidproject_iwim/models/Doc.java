package com.example.androidproject_iwim.models;

public class Doc {
    private String docname,url;

    public Doc() {
    }

    public Doc(String docname,  String url) {
        this.docname = docname;
        //this.pid = pid;
        this.url = url;
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname;
    }


    /*public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }*/

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

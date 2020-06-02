package com.example.androidproject_iwim.models;

public class Message {

    private String textMsg;
    private long dateMsg;

    public Message() {

    }

    public Message(String textMsg) {
        this.textMsg=textMsg;
    }

    public String getTextMsg() {
        return textMsg;
    }

    public void setTextMsg(String textMsg) {
        this.textMsg = textMsg;
    }

    public long getDateMsg() {
        return dateMsg;
    }

    public void setDateMsg(long dateMsg) {
        this.dateMsg = dateMsg;
    }

}
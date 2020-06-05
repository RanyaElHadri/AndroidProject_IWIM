package com.example.androidproject_iwim.models;

public class Event {

    private String titleEvent , descEvent ,imageEvent;

    public Event(){

    }

    public Event(String mTitleEvent, String mDescEvent,String mImageEvent){
        titleEvent = mTitleEvent;
        descEvent = mDescEvent;
        imageEvent = mImageEvent;
    }

    public String getTitleEvent() {
        return titleEvent;
    }

    public void setTitleEvent(String mTitleEvent) {
        titleEvent = mTitleEvent;
    }

    public String getDescEvent() {
        return descEvent;
    }

    public void setDescEvent(String mDescEvent) {
        this.descEvent = mDescEvent;
    }

    public String getImageEvent() {
        return imageEvent;
    }

    public void setImageEvent(String mImageEvent) {
        this.imageEvent = mImageEvent;
    }
}

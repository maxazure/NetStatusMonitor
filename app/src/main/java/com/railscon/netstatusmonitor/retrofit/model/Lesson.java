package com.railscon.netstatusmonitor.retrofit.model;

public class Lesson {

    private int id;
    private String cTitle;
    private String cBody;
    private String cVoice;
    private String cCreated;
    private int cSort;
    private int cRank;
    private String cTags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCTitle() {
        return cTitle;
    }

    public void setCTitle(String cTitle) {
        this.cTitle = cTitle;
    }

    public String getCBody() {
        return cBody;
    }

    public void setCBody(String cBody) {
        this.cBody = cBody;
    }

    public String getCVoice() {
        return cVoice;
    }

    public void setCVoice(String cVoice) {
        this.cVoice = cVoice;
    }

    public String getCCreated() {
        return cCreated;
    }

    public void setCCreated(String cCreated) {
        this.cCreated = cCreated;
    }

    public int getCSort() {
        return cSort;
    }

    public void setCSort(int cSort) {
        this.cSort = cSort;
    }

    public int getCRank() {
        return cRank;
    }

    public void setCRank(int cRank) {
        this.cRank = cRank;
    }

    public Object getCTags() {
        return cTags;
    }

    public void setCTags(String cTags) {
        this.cTags = cTags;
    }

}
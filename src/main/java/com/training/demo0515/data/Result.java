package com.training.demo0515.data;

public class Result {

    private boolean isexists;

    private String data;

    public Result(boolean isexists, String data) {
        this.isexists = isexists;
        this.data = data;
    }

    public boolean isIsexists() {
        return isexists;
    }

    public void setIsexists(boolean isexists) {
        this.isexists = isexists;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

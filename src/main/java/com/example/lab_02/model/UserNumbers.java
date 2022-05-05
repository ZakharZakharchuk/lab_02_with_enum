package com.example.lab_02.model;

public enum UserNumbers {
    a(""), b(""), c(""), d("");
    private String val;
    private UserNumbers(String val){
        this.val=val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}

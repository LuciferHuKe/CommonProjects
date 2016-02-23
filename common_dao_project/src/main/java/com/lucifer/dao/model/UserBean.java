package com.lucifer.dao.model;

import java.io.Serializable;

/**
 * Created by lucifer on 15/8/3.
 */
public class UserBean implements Serializable {

    private String userName = "";

    private String address = "";

    private String picUrl = "";

    private int telNum = 0;

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

    public int getTelNum() {
        return telNum;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelNum(int telNum) {
        this.telNum = telNum;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}

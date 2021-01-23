package com.example.grocery;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class AddressModel implements Serializable {
    private String userName, userPhoneNo, userPinCode, address1, address2, city, state;

    public AddressModel(String userName, String userPhoneNo, String userPinCode, String address1, String address2, String city, String state) {
        this.userName = userName;
        this.userPhoneNo = userPhoneNo;
        this.userPinCode = userPinCode;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserPinCode() {
        return userPinCode;
    }

    public void setUserPinCode(String userPinCode) {
        this.userPinCode = userPinCode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

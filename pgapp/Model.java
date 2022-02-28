package com.example.pgapp;

public class Model {
    String name,Address,Mobile;

    public Model() {

    }

    public Model(String name, String address, String mobile) {
        this.name = name;
        Address = address;
        Mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}

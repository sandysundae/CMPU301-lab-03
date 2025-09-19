package com.example.listycitylab3;

import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private String province;
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }
    public String getName() {
        return name;
    }
    public String getProvince() {
        return province;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setProvince(String newProvince){
        this.province = newProvince;
    }
}

package com.example.dailyquotes;

import java.io.Serializable;
import java.sql.Struct;

public class RCModel implements Serializable {
    private int img;
    private String name;
    public  RCModel()
    {

    }
    public RCModel(int img, String name)
    {
        this.name=name;
        this.img=img;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getImg()
    {
        return img;
    }
    public void getImg(int img)
    {
        this.img=img;
    }
}

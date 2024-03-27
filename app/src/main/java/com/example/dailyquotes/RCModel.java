package com.example.dailyquotes;

import java.io.Serializable;
import java.sql.Struct;

public class RCModel implements Serializable {
    private int img;
    private String name;
    private String quote;



    public  RCModel()
    {

    }
    public RCModel(int img, String name ,String quote)
    {
        this.name=name;
        this.img=img;
        this.quote=quote;
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
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}

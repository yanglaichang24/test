package com.ylch.test.disruptors.traderinfo;

/**
 * Created by yanglaichang1 on 2018/2/1.
 */
public class TraderInfo {

    private String id;//交易ID
    private double price;//交易金额

    public TraderInfo(){

    }

    public TraderInfo(String id,double price){
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void clean(){
        price = 0;
    }

}

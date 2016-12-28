package com.apex;

import java.util.Random;

/**
 * Created by akm on 12/21/16.
 */
public class Adobject {
    public String publisher;
    public String advertiser;
    public String location;
    private double cost;
    private int impressions;
    private boolean click;

    public double getCost() {
        return cost;
    }

    public void setCost() {
        Random r = new Random();
        this.cost = r.nextDouble();

    }

    public int getImpressions() {
        return impressions;
    }

    public void setImpressions() {
        Random r = new Random();
        this.impressions = r.nextInt();;
    }

    public boolean isClick() {
        return click;
    }

    public void setClick() {
        Random r = new Random();
        this.click = r.nextBoolean();
    }

    public Adobject(String a,String b,String c){
        publisher = a;
        advertiser = b;
        location = c;
    }
    public void disp(){
        System.out.println("Publisher is "+publisher+" and "+"Advertiser is "+advertiser+" and "+"Location is "+location);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(String advertiser) {
        this.advertiser = advertiser;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

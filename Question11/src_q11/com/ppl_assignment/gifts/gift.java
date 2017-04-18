package com.ppl_assignment.gifts;

public class gift {
    private double price;
    private double value;
    public boolean taken;
    gift(double price,double value){
        this.price = price;
        this.value = value;
        this.taken = false;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getsecondary(){
        return value;
    }
}

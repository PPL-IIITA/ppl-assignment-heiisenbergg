package com.ppl_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class boy extends person{

    protected double budget;                               //budget
    protected double min_attract_req;                      //minimum attraction requirement
    boy(String name,double attract,double mb,double iq,int type,double min_attract){
        super(name,attract,iq,type);
        this.budget=mb;
        this.min_attract_req=min_attract;
    }
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getMin_attract_req() {
        return min_attract_req;
    }

    public void setMin_attract_req(double min_attract_req) {
        this.min_attract_req = min_attract_req;
    }

}

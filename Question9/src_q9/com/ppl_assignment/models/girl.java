
package com.ppl_assignment.models;

public class girl extends person {
    private double maint_cost;      //maintainer cost
    public girl(String name,double attract,double mb,double iq,int type){
        super(name,attract,iq,type);
        this.maint_cost = mb;
    }
    public double getsecondary(){
        return maint_cost;
    }
    public double getMaint_cost() {
        return maint_cost;
    }

    public void setMaint_cost(double maint_cost) {
        this.maint_cost = maint_cost;
    }

}

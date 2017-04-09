
package com.ppl_assignment;

public class girl extends person {
    private double maint_cost;      //maintainer cost
    girl(String name,double attract,double mb,double iq,int type){
        super(name,attract,iq,type);
        this.maint_cost = mb;
    }
    public double getMaint_cost() {
        return maint_cost;
    }

    public void setMaint_cost(double maint_cost) {
        this.maint_cost = maint_cost;
    }

}

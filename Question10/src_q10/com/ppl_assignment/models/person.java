package com.ppl_assignment.models;
abstract class person{
    protected String name;    //person's name
    protected double attr_level;    // person's attraction level
    protected double iq_lvl;    // person's iq level
    protected int c_type;    //person's type
    protected double happy_lvl;    //person's happiness level
    protected boolean comm_or_not;   //commitment status
    protected String ex_partner; // name of ex-partner
    public person(String name,double attract,double iq,int type){
        this.name=name;
        this.attr_level=attract;
        this.iq_lvl=iq;
        this.c_type=type;                                    // 0 for non-committed, 1 for miser, 2 for generous, 3 for geek
        this.happy_lvl=0;
        comm_or_not = false;
    }
    abstract public double getsecondary();
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public double getAttr_level() {
        return attr_level;
    }

    public void setAttr_level(double attr_level) {
        this.attr_level = attr_level;
    }

    public double getIq_lvl() {
        return iq_lvl;
    }

    public void setIq_lvl(double iq_lvl) {
        this.iq_lvl = iq_lvl;
    }

    public int getC_type() {
        return c_type;
    }

    public void setC_type(int c_type) {
        this.c_type = c_type;
    }

    public double getHappy_lvl() {
        return happy_lvl;
    }

    public void setHappy_lvl(double happy_lvl) {
        this.happy_lvl = happy_lvl;
    }

    public boolean isComm_or_not() {
        return comm_or_not;
    }

    public void setComm_or_not(boolean comm_or_not) {
        this.comm_or_not = comm_or_not;
    }

    public String getEx_partner() {
        return ex_partner;
    }

    public void setEx_partner(String ex_partner) {
        this.ex_partner = ex_partner;
    }


}
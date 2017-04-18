package com.ppl_assignment.exception;

import com.ppl_assignment.couples;

public class GirlHappyExp extends Throwable{
    public GirlHappyExp(String name){
        System.out.println(name+" is Infinitely happy!!!!!!");
    }
    public void normalize(couples couples){
        couples.setG_happy_lvl(500);

    }
}

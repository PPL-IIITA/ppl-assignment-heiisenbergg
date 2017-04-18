package com.ppl_assignment.exception;

import com.ppl_assignment.couples;

public class NotEnoughMoney extends Throwable {
    public NotEnoughMoney(String name){
        System.out.println(name +" dosen't have enough money for gifting!!!!!");
    }
    public couples lendMoney(couples couples){
        couples.setB_budget(couples.getB_budget()+1000);
        return couples;
    }
}

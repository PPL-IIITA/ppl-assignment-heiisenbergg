package com.ppl_assignment.exception;

import com.ppl_assignment.models.boy;

import java.util.ArrayList;

public class NoCouple extends Throwable{

    public ArrayList<boy> giveraise(ArrayList<boy> boyArrayList) {
        for(boy b: boyArrayList){
            b.setBudget(b.getBudget()+1000);
        }
        return boyArrayList;
    }
}

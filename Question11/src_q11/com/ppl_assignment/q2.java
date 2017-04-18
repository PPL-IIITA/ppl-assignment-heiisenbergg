package com.ppl_assignment;

import com.ppl_assignment.exception.NotEnoughMoney;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class q2 {
    public q2(ArrayList<couples> couplesArrayList) throws FileNotFoundException {
        int count = 0;
        ArrayList<couples> couplesArrayList1 = new ArrayList<couples>(10);
        couplesArrayList1 = (ArrayList<couples>)couplesArrayList.clone();

        for(couples couples: couplesArrayList ){
            couples.makeBasket(false);
            try{
                if(couples.getB_budget() < 100){
                    throw new NotEnoughMoney(couples.getB_name());
                }

            } catch(NotEnoughMoney notEnoughMoney){
                couples = notEnoughMoney.lendMoney(couples);
            }

        }
        CSVgenerator_Gift csVgenerator_gift = new  CSVgenerator_Gift();
        csVgenerator_gift.generate(couplesArrayList,"initial_primitive");

        Collections.sort(couplesArrayList, new MyCouple_happy());
        int k = 10;
        //System.out.println("K Most Happy Couples");
        for( couples c: couplesArrayList){
            count++;
            //System.out.println(c.getB_name()+" "+c.getG_name()+" "+c.happiness_couple());
            if(count == k){
                break;
            }
        }
        count = 0;
        System.out.println("");
        //System.out.println("K Most Compatible Couples");
        Collections.sort(couplesArrayList, new MyCouple_Compatible());
        for( couples c: couplesArrayList){
            count++;
            //System.out.println(c.getB_name()+" "+c.getG_name()+" "+c.compat());
            if(count == k){
                break;
            }
        }
    }
}

class MyCouple_happy implements Comparator<couples> {
    public int compare(couples u1, couples u2) {
        if (u1.happiness_couple() < u2.happiness_couple()) {
            return 1;
        } else {
            return -1;
        }
    }
}
class MyCouple_Compatible implements Comparator<couples> {
    public int compare(couples u1, couples u2) {
        if (u1.compat() < u2.compat()) {
            return 1;
        } else {
            return -1;
        }
    }
}

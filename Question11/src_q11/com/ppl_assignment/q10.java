package com.ppl_assignment;

import com.ppl_assignment.gifts.gift;
import com.ppl_assignment.models.boy;
import com.ppl_assignment.models.girl;

import java.util.ArrayList;
import java.util.Collections;

public class q10<T> {
    final int k = 10;
    public T randomK(ArrayList<T> arrayList){
        int size,rand;
        T result = null;
        if( arrayList.get(0) instanceof boy) {
            ArrayList<boy> boyArrayList = new ArrayList<boy>(10);
            for (T t : arrayList) {
                boy b = (boy)(Object) t;
                if(b.isComm_or_not() == false)
                    boyArrayList.add(b);
            }
            Collections.sort(boyArrayList,new compare_k_best_boys());
            result = (T)boyArrayList.get(0);
        } else if( arrayList.get(0) instanceof girl){
            ArrayList<girl> girlArrayList = new ArrayList<girl>(10);
            for (T t : arrayList) {
                girl g = (girl) t;
                if(g.isComm_or_not() == false)
                    girlArrayList.add(g);
            }
            Collections.sort(girlArrayList,new compare_k_best_girls());
            result = (T)girlArrayList.get(0);
        } else if( arrayList.get(0) instanceof gift){
            ArrayList<gift> giftArrayList = new ArrayList<gift>(5);
            for (T t : arrayList) {
                gift g = (gift) t;
                if( g.taken == false )
                    giftArrayList.add(g);
            }
            Collections.sort(giftArrayList,new compare_k_best_gifts());
            size = giftArrayList.size();
            rand = 0 +(int)(Math.random() * size);
            try {
                result = (T)giftArrayList.get(rand);
            } catch (IndexOutOfBoundsException e){
                result = null;
            }
        }
        return result;
    }
}

package com.ppl_assignment;

import com.ppl_assignment.gifts.gift;
import com.ppl_assignment.models.boy;
import com.ppl_assignment.models.girl;

import java.util.ArrayList;
import java.util.*;

public class q9<T>{
    final int k = 7;

    public  ArrayList<T> k_generator(ArrayList<T> arrayList){
        int i=0;
        ArrayList<T> result = new ArrayList<T>(10);
        if( arrayList.get(0) instanceof boy) {
            ArrayList<boy> boyArrayList = new ArrayList<boy>(10);
            for (T t : arrayList) {
                boy b = (boy)(Object) t;
                if(b.isComm_or_not() == false)
                    boyArrayList.add(b);
            }
            Collections.sort(boyArrayList,new compare_k_best_boys());
            for( boy b : boyArrayList){
                i++;
                result.add((T)b);
                if( i == k)
                    break;
            }
        } else if( arrayList.get(0) instanceof girl ){
            ArrayList<girl> girlArrayList = new ArrayList<girl>(10);
            for (T t : arrayList) {
                girl g = (girl) t;
                if(g.isComm_or_not() == false)
                    girlArrayList.add(g);
            }
            Collections.sort(girlArrayList,new compare_k_best_girls());
            for( girl g : girlArrayList){
                i++;
                result.add((T)g);
                if( i == k)
                    break;
            }
        } else if( arrayList.get(0) instanceof gift ){
            ArrayList<gift> giftArrayList = new ArrayList<gift>(5);
            for (T t : arrayList) {
                gift g = (gift) t;
                giftArrayList.add(g);
            }
            Collections.sort(giftArrayList,new compare_k_best_gifts());
            for( gift g : giftArrayList){
                i++;
                result.add((T)g);
                if( i == k)
                    break;
            }
        }
        return result;
    }
}

class compare_k_best_boys implements Comparator<boy>  {
    public int compare(boy u1, boy u2) {
        return Double.compare(u1.getsecondary(),u2.getsecondary());
    }
}
class compare_k_best_girls implements Comparator<girl>  {
    public int compare(girl u1, girl u2) {
        return Double.compare(u1.getsecondary(),u2.getsecondary());
    }
}
class compare_k_best_gifts implements Comparator<gift>  {
    public int compare(gift u1, gift u2) {
        return Double.compare(u1.getsecondary(),u2.getsecondary());
    }
}

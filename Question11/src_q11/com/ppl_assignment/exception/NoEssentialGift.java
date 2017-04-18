package com.ppl_assignment.exception;

import com.ppl_assignment.gifts.gift;

import java.util.ArrayList;

public class NoEssentialGift extends Throwable {
    public NoEssentialGift(){
        System.out.println("This Boy did not take any Essential Gift!!!!!");
    }
    public ArrayList<gift> bargain(ArrayList<gift> arrayList){
        for(gift gift: arrayList){
            gift.setPrice(gift.getPrice() - 100);
            if(gift.getPrice() == 0){
                gift.setPrice(100);
            }
        }
        return arrayList;
    }
}

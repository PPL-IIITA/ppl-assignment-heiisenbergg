package com.ppl_assignment;

import com.ppl_assignment.exception.GirlHappyExp;
import com.ppl_assignment.exception.NoEssentialGift;
import com.ppl_assignment.exception.NoLuxuryGift;
import com.ppl_assignment.exception.NoUtilGift;
import com.ppl_assignment.gifts.e_gift_rand;
import com.ppl_assignment.gifts.gift;
import com.ppl_assignment.gifts.l_gift_rand;
import com.ppl_assignment.gifts.u_gift_rand;
import com.ppl_assignment.models.boy;
import com.ppl_assignment.models.girl;

import java.util.ArrayList;

public class couples {

    private String b_name;
    private String g_name;
    private double b_attr_level;
    private double g_attr_level;
    private double b_budget;
    private double maint_cost;
    private double b_iq_lvl;
    private double g_iq_lvl;
    private double b_happy_lvl;
    private double g_happy_lvl;
    protected int num_ess,num_lux,num_util;
    protected double price_ess,price_lux,price_util;
    public int getBoy_c_type() {
        return boy_c_type;
    }

    public void setBoy_c_type(int boy_c_type) {
        this.boy_c_type = boy_c_type;
    }

    public int getGirl_c_type() {
        return girl_c_type;
    }

    public void setGirl_c_type(int girl_c_type) {
        this.girl_c_type = girl_c_type;
    }

    private int boy_c_type,girl_c_type;

    public double getGirl_maint() {
        return girl_maint;
    }

    public void setGirl_maint(double girl_maint) {
        this.girl_maint = girl_maint;
    }

    private double girl_maint;

    q10 q10 = new q10();

    public void setting(boy b, girl g){
        b_name = b.getname();
        g_name = g.getname();
        b_attr_level = b.getAttr_level();
        g_attr_level = g.getAttr_level();
        b_budget = b.getBudget();
        maint_cost = g.getMaint_cost();
        b_iq_lvl = b.getIq_lvl();
        g_iq_lvl = g.getIq_lvl();
        b_happy_lvl = b.getHappy_lvl();
        g_happy_lvl = g.getHappy_lvl();
        boy_c_type = b.getC_type();
        girl_c_type = g.getC_type();
        girl_maint = g.getMaint_cost();
        num_ess = num_lux = num_ess = 0;
        price_ess = price_lux = price_ess = 0.0;
    }
    q9 q9 = new q9();
    ArrayList<gift> e_giftsArrayList =  e_gift_rand.generator();
    ArrayList<gift> l_giftsArrayList = l_gift_rand.generator() ;
    ArrayList<gift> u_giftsArrayList = u_gift_rand.generator();
    Filling_Basket basket_primitive = new Basket_primitive();
    Filling_Basket basket_hybrid = new Basket_hybrid();
    public void makeBasket(boolean hybrid_algo){
        int type = (int)boy_c_type,count  = 0;
        double budget=0.0;
        boolean ok = false;
        while(count < 2 && ok == false) {
            if (hybrid_algo == false) {
                switch (type) {
                    case 1:
                        budget = basket_primitive.miser_makebasket(b_budget, this);
                        break;
                    case 2:
                        budget = basket_primitive.generous_makebasket(b_budget, this);
                        break;
                    case 3:
                        budget = basket_primitive.geek_makebasket(b_budget, this);
                        break;
                }
            } else {
                switch (type) {
                    case 1:
                        budget = basket_hybrid.miser_makebasket(b_budget, this);
                        break;
                    case 2:
                        budget = basket_hybrid.generous_makebasket(b_budget, this);
                        break;
                    case 3:
                        budget = basket_hybrid.geek_makebasket(b_budget, this);
                        break;
                }
            }
            try {
                if (num_ess == 0) {
                    throw new NoEssentialGift();
                }
                if (num_lux == 0) {
                    throw new NoLuxuryGift();
                }
                if (num_util == 0) {
                    throw new NoUtilGift();
                }
                ok = true;
            } catch (NoEssentialGift noEssentialGift) {
                e_giftsArrayList = noEssentialGift.bargain(e_giftsArrayList);
            } catch (NoLuxuryGift noLuxuryGift) {
                l_giftsArrayList = noLuxuryGift.bargain(l_giftsArrayList);
            } catch (NoUtilGift noUtilGift) {
                u_giftsArrayList = noUtilGift.bargain(u_giftsArrayList);
            } finally {
                System.out.println("Bargaining.......");
            }
            count++;
        }
        b_budget = budget;
    }
    public void girl_happy(double ess_price,double lux_price,double util_price,
                           double ess_value,double lux_value,double util_value){
        switch((int)girl_c_type){
            case 1: g_happy_lvl = Math.log(ess_price+2*lux_price+util_price);
                break;
            case 2: g_happy_lvl = ess_price+lux_price+util_price+ess_value+lux_value+util_value;
                break;
            case 3: g_happy_lvl =(Math.exp(ess_price+lux_price+util_price));
        }
        try {
            if (g_happy_lvl >= 500) {
                throw new GirlHappyExp(getG_name());
            }
        } catch(GirlHappyExp girlHappyExp){
            girlHappyExp.normalize(this);
        }finally{
            System.out.println("Girl's Happiness naormalized.");
        }
        //System.out.println(g_happy_lvl);
    }
    public void boy_happy(){
        switch((int)boy_c_type){
            case 1: b_happy_lvl = (b_budget);
                break;
            case 2: b_happy_lvl = (g_happy_lvl);
                break;
            case 3: b_happy_lvl = g_iq_lvl;
        }
    }
    public double[] essential_buy(double budget,int max){
        double arr[] = {0, 0};
        int count = 0;

       while( true ) {
           gift e  = (gift) q10.randomK(e_giftsArrayList);
           if( e == null )
                break;
           for( gift gift : e_giftsArrayList)
           {
               if(gift.getPrice() == e.getPrice() && gift.getValue() == e.getValue()){
                   gift.taken = true;
                   break;
               }
           }
           double ess_price = e.getPrice();
            count++;
            num_ess++;
            double ess_value = e.getPrice();
            if (budget - ess_price >= 0) {
                arr[0] += ess_price;
                arr[1] += ess_value;
                budget -= ess_price;
            } else break;
            if(count == max)
                break;
        }
        num_ess = count;
        price_ess = arr[0];
        return arr;
    }
    public double[] luxury_buy(double budget,int max){
        double arr[] = {0, 0};
        int count = 0;
       while( true) {
           gift l = (gift) q10.randomK(l_giftsArrayList);
           if( l == null )
               break;
            count++;
            num_lux++;
            double price = l.getPrice();
            double value = l.getPrice();
            if (budget - price >= 0) {
                arr[0] += price;
                arr[1] += value;
                budget -= price;
            }
            else
                 break;
            if(count == max)
                break;
        }
        //num_lux = count;
        price_lux = arr[0];
        return arr;
    }
    public double[] utility_buy(double budget,int max) {
        double arr[] = {0, 0};
        int count = 0;
        while( true ) {
            gift u = (gift) q10.randomK(u_giftsArrayList);
            if( u == null )
                break;
            count++;
            double price = u.getPrice();
            double value = u.getPrice();
            if (budget - price >= 0) {
                arr[0] += price;
                arr[1] += value;
                budget -= price;
            } else  break;
            if(count == max)
                break;
        }
        num_util = count;
        price_util = arr[0];
        return arr;
    }
    public double compat(){
        return (Math.abs(b_budget-maint_cost)+Math.abs(b_iq_lvl-g_iq_lvl)+Math.abs(b_attr_level-g_attr_level));
    }
    public double happiness_couple(){
        return (b_happy_lvl + g_happy_lvl);
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public double getB_attr_level() {
        return b_attr_level;
    }

    public void setB_attr_level(double b_attr_level) {
        this.b_attr_level = b_attr_level;
    }

    public double getG_attr_level() {
        return g_attr_level;
    }

    public void setG_attr_level(double g_attr_level) {
        this.g_attr_level = g_attr_level;
    }

    public double getB_budget() {
        return b_budget;
    }

    public void setB_budget(double b_budget) {
        this.b_budget = b_budget;
    }

    public double getMaint_cost() {
        return maint_cost;
    }

    public void setMaint_cost(double maint_cost) {
        this.maint_cost = maint_cost;
    }

    public double getB_iq_lvl() {
        return b_iq_lvl;
    }

    public void setB_iq_lvl(double b_iq_lvl) {
        this.b_iq_lvl = b_iq_lvl;
    }

    public double getG_iq_lvl() {
        return g_iq_lvl;
    }

    public void setG_iq_lvl(double g_iq_lvl) {
        this.g_iq_lvl = g_iq_lvl;
    }

    public double getB_happy_lvl() {
        return b_happy_lvl;
    }

    public void setB_happy_lvl(double b_happy_lvl) {
        this.b_happy_lvl = b_happy_lvl;
    }

    public double getG_happy_lvl() {
        return g_happy_lvl;
    }

    public void setG_happy_lvl(double g_happy_lvl) {
        this.g_happy_lvl = g_happy_lvl;
    }
}

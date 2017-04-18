package com.ppl_assignment;
import com.ppl_assignment.exception.ArrayEmpty;
import com.ppl_assignment.exception.NoCouple;
import com.ppl_assignment.models.boy;
import com.ppl_assignment.models.girl;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class q1{
    public static <T extends Comparable<T>> void main(String[] args) throws FileNotFoundException {
        ArrayList<boy> boyArrayList = new ArrayList<boy>(60);
        ArrayList<girl> girlArrayList = new ArrayList<girl>(40);
        CSVgenerator_Boy csVgeneratorBoy = new CSVgenerator_Boy();
        CSVgenerator_Girl csVgeneratorgirl = new CSVgenerator_Girl();
        boyArrayList = csVgeneratorBoy.generate();
        girlArrayList = csVgeneratorgirl.generate();
        ArrayList<couples> couplesArrayList = new ArrayList<couples>(40);
        q5 q5 = new q5();
        /*Matchmaking here*/
        couplesArrayList = q5.matching_algo(boyArrayList,girlArrayList);
        try{
            if(boyArrayList.size() == 0){
                throw new ArrayEmpty(1);
            }
            if(girlArrayList.size() == 0){
                throw new ArrayEmpty(2);
            }
            if(couplesArrayList.size() == 0){
                throw new NoCouple();
            }
        }catch (NoCouple noCouple){
            System.out.println("No Couple Formed.......Giving boys a raise");
            boyArrayList = noCouple.giveraise(boyArrayList);
            couplesArrayList = q5.matching_algo(boyArrayList,girlArrayList);
        } catch (ArrayEmpty a) {
            a.Message();
            if(a.getType() == 1)
                boyArrayList = a.getBoy();
            if(a.getType() == 2)
                girlArrayList = a.getGirl();

        }
        CSVgenerator_Couple csVgeneratorCouple = new CSVgenerator_Couple();
        csVgeneratorCouple.generate(couplesArrayList,"initial");

        /*Question 2*/
        q2 q = new q2(couplesArrayList);

        /*q9 q9 = new q9();
        ArrayList<boy> result = (ArrayList<boy>) (Object) q9.k_generator(boyArrayList);*/
        System.out.println("Please Refer to CSV files for Output. ThankYou");
    }
    public static ArrayList<couples> matchmaking(ArrayList<boy> boyArrayList, ArrayList<girl> girlArrayList) {
        ArrayList<couples> couplesArrayList = new ArrayList<couples>(40);
        for (boy b : boyArrayList) {
            for (girl g : girlArrayList) {
                if (b.getBudget() >= g.getMaint_cost()
                        && g.getAttr_level() > b.getMin_attract_req() && b.isComm_or_not() == false
                        && g.isComm_or_not() == false
                        && !g.getname().equals(b.getEx_partner())
                        && !b.getname().equals(g.getEx_partner())) {
                    b.setComm_or_not(true);
                    g.setComm_or_not(true);
                    couples couples = new couples();
                    couples.setting(b, g);
                    couplesArrayList.add(couples);
                }
            }
        }
        return couplesArrayList;
    }
}

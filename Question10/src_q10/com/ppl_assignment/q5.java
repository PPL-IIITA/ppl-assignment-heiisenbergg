package com.ppl_assignment;

import com.ppl_assignment.models.boy;
import com.ppl_assignment.models.girl;

import java.util.ArrayList;
import java.util.Comparator;

public class q5 {
    public ArrayList<couples> matching_algo (ArrayList<boy> boyArrayList1,ArrayList<girl> girlArrayList1) {
        ArrayList<couples> couplesArrayList = new ArrayList<couples>(10);
        int boy_size= boyArrayList1.size();
        q9 q9 = new q9();
        int girl_size = girlArrayList1.size();
        int size = boyArrayList1.size() + girlArrayList1.size() - 1;
        int i,j,bptr=0,gptr=0;
        boy b;
        girl g;
        for(i=0;i<size;i++){
            if(i%2 != 0 && bptr<boy_size) {
                b = boyArrayList1.get(bptr++);
                ArrayList<girl> girlArrayList = (ArrayList<girl>)(Object) q9.k_generator((ArrayList<girl>) girlArrayList1.clone());
                girl_size = girlArrayList.size();
               for(j = 0; j<girl_size;j++){
                   girl gr = girlArrayList.get(j);
                    if (b.getBudget() >= gr.getMaint_cost()
                            && gr.getAttr_level() >= b.getMin_attract_req()
                            && b.isComm_or_not() == false
                            && gr.isComm_or_not() == false
                            && !gr.getname().equals(b.getEx_partner())
                            && !b.getname().equals(gr.getEx_partner())) {
                        b.setComm_or_not(true);
                        gr.setComm_or_not(true);
                        couples couples = new couples();
                        couples.setting(b, gr);
                        couplesArrayList.add(couples);
                    }
                }
            } else if ( i%2 == 0 && gptr < girl_size){
                g = girlArrayList1.get(gptr++);
                ArrayList<boy> boyArrayList = (ArrayList<boy>)(Object) q9.k_generator((ArrayList<boy>) boyArrayList1.clone());
                boy_size = boyArrayList.size();
                for(j = 0 ;j < boy_size; j++ ){
                    boy by = boyArrayList.get(j);
                    if (by.getBudget() >= g.getMaint_cost()
                            && g.getAttr_level() > by.getMin_attract_req()
                            && by.isComm_or_not() == false
                            && g.isComm_or_not() == false
                            && !g.getname().equals(by.getEx_partner())
                            && !by.getname().equals(g.getEx_partner())) {
                        by.setComm_or_not(true);
                        g.setComm_or_not(true);
                        couples couples = new couples();
                        couples.setting(by, g);
                        couplesArrayList.add(couples);
                    }
                }
            }
        }
        return couplesArrayList;
    }
}
class boy_attractiveness implements Comparator<boy> {
    public int compare(boy u1, boy u2) {
       return Double.compare(u1.getAttr_level(),u2.getAttr_level());
    }
}

class girl_maint_cost implements Comparator<girl> {
    public int compare(girl u1, girl u2) {
        return Double.compare(u1.getMaint_cost(),u2.getMaint_cost());
    }
}
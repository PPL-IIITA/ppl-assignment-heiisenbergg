package com.ppl_assignment;

import com.ppl_assignment.models.boy;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class my_partner{
    private String b_name,g_name;
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

}

class find_gf_Arraylist{
    protected ArrayList<couples> couplesArrayList;
    find_gf_Arraylist(ArrayList<couples> couplesArrayList){
        this.couplesArrayList = (ArrayList<couples>)couplesArrayList.clone();
    }
    public void generate(){
            //intentionally null function
    }
    public ArrayList<my_partner> search(ArrayList<boy> boyArrayList) {
        int flag = 0;
        System.out.println("Arraylist Method: "+boyArrayList.size());
        ArrayList<my_partner> arraylist_hash = new ArrayList<my_partner>(10);
        my_partner my_partner;
        for (boy b : boyArrayList) {
            flag = 0;
            for (couples c : couplesArrayList) {
                if (c.getB_name().equals(b.getname())) {
                    flag = 1;
                    System.out.println(b.getname() + " coupled with " + c.getG_name());
                    my_partner = new my_partner();
                    my_partner.setB_name(b.getname());
                    my_partner.setG_name(c.getG_name());
                    arraylist_hash.add(my_partner);
                    break;
                }
            }
            if( flag == 0){
                System.out.println("Sorry "+b.getname()+" not commited");
                my_partner = new my_partner();
                my_partner.setB_name(b.getname());
                my_partner.setG_name("NULL");
                arraylist_hash.add(my_partner);
            }
        }
        return arraylist_hash;
    }
}
class find_gf_Array extends find_gf_Arraylist {
    private String[] boys = new String[500];
    find_gf_Array(ArrayList<couples> couplesArrayList){
        super(couplesArrayList);
    }
    int i=0;
    public void generate(){
        for(couples c: couplesArrayList){
            boys[i++] = c.getB_name();
        }
    }
    public ArrayList<my_partner> search(ArrayList<boy> boyArrayList){
        System.out.println("Array Method: "+boyArrayList.size());
        ArrayList<my_partner> array_partner = new ArrayList<my_partner>(10);
        my_partner my_partner;
        for(boy b: boyArrayList){
            for(i=0;i<couplesArrayList.size();i++){
                if(b.getname().equals(boys[i])){
                    break;
                }
            }
            if( i < couplesArrayList.size()) {
                for (couples c : couplesArrayList) {
                    if (c.getB_name().equals(b.getname())) {
                        System.out.println(b.getname() + " coupled with " + c.getG_name());
                        my_partner = new my_partner();
                        my_partner.setB_name(b.getname());
                        my_partner.setG_name(c.getG_name());
                        array_partner.add(my_partner);
                        break;
                    }
                }

            } else {
                System.out.println("Sorry "+b.getname()+" not commited");
                my_partner = new my_partner();
                my_partner.setB_name(b.getname());
                my_partner.setG_name("NULL");
                array_partner.add(my_partner);
            }
        }
        return array_partner;
    }
}

class find_gf_hash extends find_gf_Arraylist{
    private int[] boys = new int[couplesArrayList.size()];
    int i=0,current;
    find_gf_hash(ArrayList<couples> couplesArrayList){
        super(couplesArrayList);
    }
    public void generate() {
        for (couples c : couplesArrayList) {
            //System.out.println(c.getB_name().substring(4,c.getB_name().length()));
            boys[i++] = Integer.parseInt(c.getB_name().substring(4,c.getB_name().length()));
        }
    }
    public ArrayList<my_partner> search(ArrayList<boy> boyArrayList){
        System.out.println("Hash Method: ");
        ArrayList<my_partner> hash_partner = new ArrayList<my_partner>(10);
        my_partner my_partner;
        for(boy b: boyArrayList){
            current = Integer.parseInt(b.getname().substring(4, b.getname().length()));
            for(i=0;i<couplesArrayList.size();i++){
                if (boys[i] == current) {
                    break;
                }
            }
            if( i < couplesArrayList.size()) {
                for (couples c : couplesArrayList) {
                    if (c.getB_name().equals(b.getname())) {
                        System.out.println(b.getname() + " coupled with " + c.getG_name());
                        my_partner = new my_partner();
                        my_partner.setB_name(b.getname());
                        my_partner.setG_name(c.getG_name());
                        hash_partner.add(my_partner);
                        break;
                    }
                }

            }else{
                System.out.println("Sorry "+b.getname()+" not commited");
                my_partner = new my_partner();
                my_partner.setB_name(b.getname());
                my_partner.setG_name("NULL");
                hash_partner.add(my_partner);
            }
        }
        System.out.println("Size of ArrayList by Hash: "+hash_partner.size());
        return hash_partner;
    }
}
public class q7 {
     public void find_gf(ArrayList<couples> couplesArrayList,ArrayList<boy> boyArrayList) throws FileNotFoundException {
        find_gf_Arraylist find_gf_arraylist = new find_gf_Arraylist(couplesArrayList);
        find_gf_Arraylist find_gf_array = new find_gf_Array(couplesArrayList);
        find_gf_Arraylist find_gf_hash = new find_gf_hash(couplesArrayList);
        ArrayList<my_partner> match_check ;
         System.out.println("");
        CSVgenerator_Partner csVgenerator_partner = new CSVgenerator_Partner();
        find_gf_arraylist.generate();
        match_check = find_gf_arraylist.search(boyArrayList);
        csVgenerator_partner.generate(match_check,"ArrayList");
         System.out.println("");

        find_gf_array.generate();
        match_check = find_gf_array.search(boyArrayList);
         csVgenerator_partner.generate(match_check,"Array");
        System.out.println("");

        find_gf_hash.generate();
        match_check =find_gf_hash.search(boyArrayList);
         csVgenerator_partner.generate(match_check,"hashing");
         
     }
}

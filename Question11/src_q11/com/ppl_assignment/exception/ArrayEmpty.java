package com.ppl_assignment.exception;

import com.ppl_assignment.CSVgenerator_Boy;
import com.ppl_assignment.CSVgenerator_Gift;
import com.ppl_assignment.CSVgenerator_Girl;
import com.ppl_assignment.models.boy;
import com.ppl_assignment.models.girl;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ArrayEmpty extends Throwable {

    private int type;
    public ArrayEmpty(int type){
        this.type = type;
    }
    public void Message(){
        switch (type) {
            case 1:
                System.out.print("Boy ");
                break;
            case 2:
                System.out.print("Girl ");
                break;
            case 3:
                System.out.print("Gift ");
                break;
        }
        System.out.println(" ArrayList is Empty");
    }
    public ArrayList<boy> getBoy() throws FileNotFoundException {
        ArrayList<boy> boys = new ArrayList<boy>();
        CSVgenerator_Boy csVgeneratorBoy = new CSVgenerator_Boy();
        csVgeneratorBoy.raiseMin();
        try {
            boys = csVgeneratorBoy.generate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Now Boys are "+boys.size());
        return boys;
    }
    public ArrayList<girl> getGirl() throws FileNotFoundException {
        ArrayList<girl> girls = new ArrayList<girl>();
        CSVgenerator_Girl csVgeneratorGirl = new CSVgenerator_Girl();
        csVgeneratorGirl.raiseMin();
        try {
            girls = csVgeneratorGirl.generate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Now Girls are "+girls.size());
        return girls;
    }
    public int getType() {
        return type;
    }
}

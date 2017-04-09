package com.ppl_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVgenerator_Partner {
    public void generate(ArrayList<my_partner> arrayListcouples, String type) throws FileNotFoundException {
        String path = "Partners_"+type+"_method.csv";
        PrintWriter pw = new PrintWriter(new File(path));
        StringBuilder sb = new StringBuilder();
        sb.append("Boy_Name");
        sb.append(',');
        sb.append("Girl_Name");
        sb.append(',');
        sb.append('\n');

        for (my_partner couples : arrayListcouples) {
            sb.append(couples.getB_name());
            sb.append(',');
            sb.append(couples.getG_name());
            sb.append(',');
            sb.append('\n');
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("Partner_"+type+"_method.csv Done!");
    }
}

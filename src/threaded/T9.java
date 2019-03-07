/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaded;

import java.text.DecimalFormat;
import java.util.ArrayList;
import project1_444.Project1_444;

/**
 *
 * @author kevin
 */
public class T9 implements Runnable  {
    T2 t2 = new T2();
    int size = t2.getSize();
    T4 t4=new T4();
    
    public void run() {
         Project1_444 p1 = new Project1_444("t3");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        ArrayList<String> data = p1.accessData();
        String[] dataGroups = new String[26];
        char firstC = 'x';
        int rape=0;
       
        double perID = 0, perCAPe = 0, perCAS = 0, perCAPr = 0, perD = 0, perMj = 0, perCo = 0, perHe = 0, perRape = 0;
        for (int i = 0; i < size; i++) {

            line = data.get(i).toString();
            dataGroups = line.split(",");
            if (dataGroups[6].isEmpty()) {
                dataGroups[6] = "N";
            }
             if(dataGroups[6].contains("Pe")&&dataGroups[8].contains("RAPE")){
                      rape++;
                      //
                      
                 }
        }
        double CaP=t4.getCap();
         perRape=rape/CaP*100;
         
             System.out.println("the percent of rape  = "+ df.format(perRape));
    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaded;

import java.text.DecimalFormat;
import java.util.ArrayList;
import project1_444.Project1_444;
import static threaded.T2.data;



/**
 *
 *  @author Kevin Riley for 444 Professor Rinard Spring 18
 * 
 * Thread 7 counts the amount of heroin and calculates the % of heroin  compared to the other drugs
 */
public class T8 implements Runnable {

         T2 t2 = new T2("t7");
         T5 t5 = new T5("t7");
       
         String name;

    public T8(String n) {
        name = n;
    }

    public void run() {
        Project1_444 p1 = new Project1_444("t7");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        double her = 0;
        double  perHe = 0;
        
        System.out.println(this .name +" has requested data");
         synchronized (this) {
         
        String[] dataGroups = new String[26];
        char firstC = 'x';
        
        System.out.println(this .name +" has requested size");
        int size = t2.getSize();
        System.out.println(this .name +" has requested  the drug count");
        for (int i = 0; i < size; i++) {

            line = data.get(i).toString();
            dataGroups = line.split(",");
            if (dataGroups[6].isEmpty()) {
                dataGroups[6] = "N";
            }
             if(!dataGroups[7].isEmpty()){
                    if(dataGroups[7].contains("Drug")&&dataGroups[8].contains("HER")){
                        her++;
                    }
             }
           
        }
         }
        double drugC= t5.getDrugC();
        perHe=her/drugC*100;
        System.out.println("the percent of herion  = "+ df.format(perHe));
    }
}

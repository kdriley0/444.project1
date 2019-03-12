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
 *@author Kevin Riley for 444 Professor Rinard Spring 18 started on 2/13/19
 *
 * get the size from thread 2 and total number of crimes(tC) from thread 2
 * 
 * thread 3 counts the number and percentage of Crime Against Society (CaS)
 * and Crime Against Property (CaPr)
 * and Crime Against Person  (CaPe)
 * has a synchronized method to return the the Crime Against Person
 * 
 * Calculates and prints out the percent of Crime Against Society, Crime Against Property, and  Crime Against Person
 * 
 */
public class T4 implements Runnable {
    T2 t2 = new T2("t3");
    
    static int i=0;
    static double CaS = 0, CaPr = 0, CaP = 0;
    String name;

    public T4(String n) {
        name=n;
    }
    public void run() {
        System.out.println(this .name +" has requested size");
        int size = t2.getSize();
        Project1_444 p1 = new Project1_444("t3");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        System.out.println(this .name +" has requested data");
        ArrayList<String> data = p1.accessData();
        String[] dataGroups = new String[26];
        char firstC = 'x';
        int idT = 0;
      
        double  perCAPe = 0, perCAS = 0, perCAPr = 0;
        for (int i = 0; i < size; i++) {

            line = data.get(i).toString();
            dataGroups = line.split(",");
            if (dataGroups[6].isEmpty()) {
                dataGroups[6] = "N";
            }
             if( dataGroups[6].contains("So")){
                   CaS++;
              
               }
               if( dataGroups[6].contains("Pr")){
                   CaPr++;
              
               }
               if( dataGroups[6].contains("Pe")){
                   CaP++;
              
               }

        }
        double tC=t2.getTc();
             perCAPe=CaP/tC*100;
             perCAS=CaS/tC*100;
             perCAPr=CaPr/tC*100;
             
             System.out.println("the percent of crime against a person= "+ df.format(perCAPe));
             System.out.println("the percent of crime against property = "+ df.format(perCAPr));
             System.out.println("the percent of crime against society= "+ df.format(perCAS));

    }
       public synchronized double getCap() {
           System.out.println(  this.name + " has the crime against persons");
        return CaP;
    }
       public synchronized double getCas() {
           if(i==0){
               System.out.println(  this.name + " has the crime against society");
               i++;
           }
            
        return CaS;
    }


}

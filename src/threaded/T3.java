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
 * @author Kevin Riley for 444 Professor Rinard Spring 18 started on 2/13/19
 * 
 * Thread 2 counts the number of identity theft (idT)
 * 
 * 
 * get the size from thread 2 and total number of crimes(tC) from thread 2
 * 
 * Calculates and prints out the percent of identity theft
 */
public class T3 implements Runnable {
    T2 t2 = new T2("t2");
    
     String name;

    public T3(String n) {
        name = n;
    }
   

    public void run() {
        System.out.println("Thread 2 has requested size");
        int size = t2.getSize();
        
         Project1_444 p1 = new Project1_444("t2");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        System.out.println(this .name +" has requested data");
        ArrayList<String> data = p1.accessData();
        String[] dataGroups = new String[26];
        char firstC = 'x';
        int idT=0;
       // double tC=
        double perID = 0;
        for (int i = 0; i < size; i++) {

            line = data.get(i).toString();
            dataGroups = line.split(",");
            if (dataGroups[6].isEmpty()) {
                dataGroups[6] = "N";
            }
            if(!dataGroups[7].isEmpty()){
                   if( dataGroups[7].charAt(0)=='I'){
                  idT++;
                   }
              }
        }
        double tC=t2.getTc();
          perID=idT/tC*100;
             System.out.println("the percent of IDENTITY THEFT = "+ df.format(perID));
    }

}

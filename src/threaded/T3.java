/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaded;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project1_444.Project1_444;
import static threaded.T2.data;

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
    static T3 t3 = new T3("t2");
    static int k = 0;
    String name;
    int idT = 0;
            // double tC=
            double perID = 0;
    public T3(String n) {
        name = n;
    }

    public void run() {
        //       try {
        System.out.println(this.name +" has requested size");
        int size = t2.getSize();

        Project1_444 p1 = new Project1_444("t2");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        System.out.println(this.name + " has requested data");

        synchronized (this) {
      //      try {
              //  data = p1.accessData();
                //t3.wait(100);
                String[] dataGroups = new String[26];
                char firstC = 'x';
                
                for (int i = 0; i < size; i++) {
                    
                    line = data.get(i).toString();
                    dataGroups = line.split(",");
                    if (dataGroups[6].isEmpty()) {
                        dataGroups[6] = "N";
                    }
                    if (!dataGroups[7].isEmpty()) {
                        if (dataGroups[7].charAt(0) == 'I') {
                            idT++;
                        }
                    }
                }
           //} catch (InterruptedException ex) {
          //      Logger.getLogger(T3.class.getName()).log(Level.SEVERE, null, ex);
          //  }
        }
        if (k == 0) {//to prevent it from spaming the console
            System.out.println(this.name + " has requested total crimes");
            k++;
        }
        // t3.wait(10000);
        double tC = t2.getTc();
        perID = idT / tC * 100;
        System.out.println("the percent of IDENTITY THEFT = " + df.format(perID));
        //  } catch (InterruptedException ex) {
        //  Logger.getLogger(T3.class.getName()).log(Level.SEVERE, null, ex);
        // }
    }

}

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
 * @author Kevin Riley for 444 Professor Rinard Spring 18
 *
 * Thread 8 counts the number of rape offences and calculates the % of rape out
 * of the crimes against persons
 */
public class T9 implements Runnable {

    T2 t2 = new T2("t8");
   
    T4 t4 = new T4("t8");
    String name;

    public T9(String n) {
        name = n;
    }

    public void run() {
        
        
        Project1_444 p1 = new Project1_444("t8");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        int rape = 0;
        double perRape = 0;
        System.out.println(this .name +" has requested data");
         synchronized (this) {
        
        String[] dataGroups = new String[26];
        char firstC = 'x';
        
        System.out.println(this .name +" has requested size");
        int size = t2.getSize();
        System.out.println(this .name +" has requested the crime against person");
        for (int i = 0; i < size; i++) {

            line = data.get(i).toString();
            dataGroups = line.split(",");
            if (dataGroups[6].isEmpty()) {
                dataGroups[6] = "N";
            }
            if (dataGroups[6].contains("Pe") && dataGroups[8].contains("RAPE")) {
                rape++;
                //

            }
        }//end for
         }//end sync
        double CaP = t4.getCap();
        perRape = rape / CaP * 100;

        System.out.println("the percent of rape  = " + df.format(perRape));
    }

}

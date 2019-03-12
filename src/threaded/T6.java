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
 * @author Kevin Riley for 444 Professor Rinard Spring 18
 *
 * Thread 5 counts the amount of marijuana and calculates the % of marijuana
 * compared to the other drugs
 */
public class T6 implements Runnable {

    T2 t2 = new T2("t5");
    T5 t5 = new T5("t5");
   
    String name;

    public T6(String n) {
        name = n;
    }

    public void run() {
        Project1_444 p1 = new Project1_444("t5");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        System.out.println(this .name +" has requested data");
        ArrayList<String> data = p1.accessData();
        String[] dataGroups = new String[26];
        char firstC = 'x';
        double mj = 0;
    
        double perMj = 0;
        System.out.println(this .name +" has requested size");
        int size = t2.getSize();
        System.out.println(this .name +" has requested the drug count");
        for (int i = 0; i < size; i++) {

            line = data.get(i).toString();
            dataGroups = line.split(",");
            if (dataGroups[6].isEmpty()) {
                dataGroups[6] = "N";
            }
            if (!dataGroups[7].isEmpty()) {
                if (dataGroups[7].contains("Drug") && dataGroups[8].contains("MAR")) {
                    mj++;
                }
            }

        }
        double drugC = t5.getDrugC();
        perMj = mj / drugC * 100;
        System.out.println("The percent of marijuana  = " + df.format(perMj));
    }
}

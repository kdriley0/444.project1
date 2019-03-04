/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaded;

import java.text.DecimalFormat;
import java.util.ArrayList;
import project1_444.Project1_444;
import static threaded.T2.size;
import static threaded.T5.drugC;

/**
 *
 * @author kevin
 */
public class T6 implements Runnable {

  

    public void run() {
        Project1_444 p1 = new Project1_444("t3");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        ArrayList<String> data = p1.accessData();
        String[] dataGroups = new String[26];
        char firstC = 'x';
        double mj = 0;

        double perID = 0, perCAPe = 0, perCAS = 0, perCAPr = 0, perD = 0, perMj = 0, perCo = 0, perHe = 0, perRape = 0;
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
        perMj=mj/drugC*100;
        System.out.println("the percent of maryj  = "+ df.format(perMj));
    }
}

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
 * 
 * Thread 4 counts the number and percentage of drug crimes
 * 
 * get the size from thread 2 and total number of crimes(tC) from thread 2 and get the total crime against society from t3
 * 
 * 
 * 
 */
public class T5 implements Runnable {
    T2 t2 = new T2();
    int size = t2.getSize();
    T4 t4 = new T4();
    
    static  double drugC=0;
    public void run() {
        Project1_444 p1 = new Project1_444("t3");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        ArrayList<String> data = p1.accessData();
        String[] dataGroups = new String[26];
        char firstC = 'x';
        double mj = 0;
       
        double  perD = 0, perDrug;
        for (int i = 0; i < size; i++) {

            line = data.get(i).toString();
            dataGroups = line.split(",");
            if (dataGroups[6].isEmpty()) {
                dataGroups[6] = "N";
            }
            if(!dataGroups[7].isEmpty()){
                    if(dataGroups[7].contains("Drug")){
                  drugC++;
                  //System.out.println(drugC);
                   }
              }
             perDrug=0;
            double tC=t2.getTc();
            double caS= t4.getCas();
            perD=drugC/tC*100;
            perDrug=drugC/caS*100;
            
        }
        System.out.println("the percent of drug crimes out of total crimes = "+ df.format(perD));
        System.out.println("the percent of drug crimes out of crimes  against society = "+ df.format(perDrug));

    }//end run
    public synchronized double getDrugC() {
        return drugC;
    }

}

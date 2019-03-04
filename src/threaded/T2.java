/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaded;
import Project1_444.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import project1_444.Project1_444;
import static threaded.T1.size;
import static project1_444.Project1_444.crimes;
/**
 *
 * @author kevin
 */
public class T2 implements Runnable{
     static final int size=69501;
     static double tC= 69501, nAC=0, oth=0,idT=0, CaS=0, CaPr=0, CaP=0, drugC=0,mj=0, co=0, her=0, rape=0  ;
     
  
    public void run(){
         Project1_444 p1 = new Project1_444("t2");
        DecimalFormat df = new DecimalFormat("0.00");
        String line = null;
        ArrayList<String> data=p1.accessData();
        String[] dataGroups= new String[26];
        char firstC= 'x';
         double perO =0, perNAC, perID=0,perCAPe=0,perCAS=0,perCAPr=0, perD=0, perMj=0, perCo=0,perHe=0, perRape=0;
         for( int i=0; i< size;i++){
             
             line=data.get(i).toString();
             dataGroups= line.split(",");
             if(dataGroups[6].isEmpty())
              {
                  dataGroups[6]="N";
              }
              firstC= dataGroups[6].charAt(0);
            if(firstC=='N')
            {
                nAC++;
                
               //   System.out.println(tC+ "tC");
             }
              if(firstC=='O'){
                  oth++;
              }
             
         }
             tC-=(oth+ nAC);
             perO=(oth/size)*100;
             perNAC=(nAC/size)*100;
         System.out.println( "Not a Crime "+ nAC +"\nOther "+ oth);
         System.out.println("Percent of Other = "+df.format(perO)+"\nPercent of Not a Crime = "+df.format(perNAC));
             
    }
    public  synchronized double getTc(){
        return tC;
    }
    
}

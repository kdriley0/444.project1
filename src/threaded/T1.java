/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaded;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.*;

/**
 * @author Kevin Riley for 444 Professor Rinard Spring 18 started on 2/13/19
 *
 * T1 goes through every one of the 8 things and answers them
 * 
 *      ***********************************************************NOT REQUIRED********************************************
 */
public class T1 implements Runnable {
   
 //  static File data;
    static final int size=69501;
    //static int tC= 69501,nAC=0, oth=0,CaS=0,CaPr=0;
    static ArrayList data;
   //static BufferedReader scan = null;
    static Scanner s;
    public T1(ArrayList data){
        this.data=data;
    }
    static double tC= 69501, nAC=0, oth=0,idT=0, CaS=0, CaPr=0, CaP=0, drugC=0,mj=0, co=0, her=0, rape=0  ;
    static{
        try{
  //           scan = new BufferedReader(new FileReader(data));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
  public void  run(){
      boolean loop=true;
      String line = null;
      int i =0;
         
      
      double perO =0, perNAC, perID=0,perCAPe=0,perCAS=0,perCAPr=0, perD=0, perMj=0, perCo=0,perHe=0, perRape=0;
      char firstC= 'x';
       DecimalFormat df = new DecimalFormat("0.00");

      while(loop){
          try {
             
              String[] dataGroups= new String[26];
             for( i=0; i< size;i++)
             {
              
              line=data.get(i).toString();
             dataGroups= line.split(",");
            // System.out.println((dataGroups[6].charAt(0)));
            // firstC=dataGroups[6].charAt(0);
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
               if(!dataGroups[7].isEmpty()){
                   if( dataGroups[7].charAt(0)=='I'){
                  idT++;
                   }
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
                if(!dataGroups[7].isEmpty()){
                    if(dataGroups[7].contains("Drug")){
                  drugC++;
                  //System.out.println(drugC);
                   }
              }
                if(!dataGroups[7].isEmpty()){
                    if(dataGroups[7].contains("Drug")&&dataGroups[8].contains("MAR")){
                        mj++;
                    }
                }
                
                if(!dataGroups[7].isEmpty()){
                    if(dataGroups[7].contains("Drug")&&dataGroups[8].contains("CO")){

                        co++;
                    }
                }
                 if(!dataGroups[7].isEmpty()){
                    if(dataGroups[7].contains("Drug")&&dataGroups[8].contains("HER")){
                        her++;
                    }
                  }
                  if(!dataGroups[7].isEmpty()){
                    if(dataGroups[7].contains("Drug")&&dataGroups[8].contains("H")){

                        //co++;
                    }
                }
                 if(dataGroups[6].contains("Pe")&&dataGroups[8].contains("RAPE")){
                      rape++;
                      //
                      
                 }
             //  System.out.println(dataGroups[8]);
              
               
              
              }//end of for
             
             
             
             
           
            
            
             perID=idT/tC*100;
             tC-=(oth+ nAC);
             perO=(oth/size)*100;
             perNAC=(nAC/size)*100;
             perCAPe=CaP/tC*100;
             perCAS=CaS/tC*100;
             perCAPr=CaPr/tC*100;
             perD=drugC/tC*100;
             perMj=mj/drugC*100;
             perCo=co/drugC*100;
             perHe=her/drugC*100;
             perRape=rape/CaP*100;
                     
                     
                     
                     
             System.out.println( "Not a Crime "+ nAC +"\nOther "+ oth);
             System.out.println("Percent of Other = "+df.format(perO)+"\nPercent of Not a Crime = "+df.format(perNAC));
             System.out.println("the percent of IDENTITY THEFT = "+ df.format(perID));
             System.out.println("the percent of crime against a person= "+ df.format(perCAPe));
             System.out.println("the percent of crime against property = "+ df.format(perCAPr));
             System.out.println("the percent of crime against sociiaty= "+ df.format(perCAS));
             System.out.println("the percent of drug crimes = "+ df.format(perD));
             System.out.println("the percent of maryj  = "+ df.format(perMj));
             System.out.println("the percent of COCAINE  = "+ df.format(perCo));
             System.out.println("the percent of HEROINj  = "+ df.format(perHe));
             System.out.println("the percent crimes against a person are RAPE  = "+ df.format(perRape));
              break;
              
            
              
          } catch (Exception ex) {
             ex.printStackTrace();
          }
      }//end while
      
   
}//end run
  
public synchronized double getOther(){
    return oth;
}



  
}

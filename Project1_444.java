/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project1_444;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import threaded.*;

/**
 *
 * @author Kevin Riley on 2/13/19 
 * to go through a database and have 8 threads each do something and have 1 thread do 8 things and compare the time taken for distributed computing aka class 444 
 */
public class Project1_444 {
    
    static BufferedReader can = null;
    static File data ;
    
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> crimes = new ArrayList<>();
        String line = null;
        int i=0;
     data = new File("../Crime.csv");
     can = new BufferedReader(new FileReader(data));
     String d="";
     
     while(true){
           try {
               while(can.read()!=-1)
              line=can.readLine();
               
             System.out.println(line);
              crimes.add(line);
                  
              
              
          } catch (Exception  ex) {
              ex.printStackTrace();
          }
     }
        //Thread t1=new Thread(new T1(data));
       // t1.run();
     
     
    }
    
}

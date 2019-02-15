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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class T1 implements Runnable {
   
 //  static File data;
    static String data;
   //static BufferedReader scan = null;
    static Scanner s;
    public T1(String data){
        this.data=data;
    }
    static{
        try{
  //           scan = new BufferedReader(new FileReader(data));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
  public void  run(){
      String line = null;
      int i=0;
      while(true){
          try {
              s=new Scanner(data);
              while(s.hasNextLine()){
              
              line=s.nextLine();
             System.out.println(line);
              }
              
              
            
              
          } catch (Exception ex) {
              ex.printStackTrace();
          }
      }
      
   
}
    
}

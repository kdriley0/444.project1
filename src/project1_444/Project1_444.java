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
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;
import threaded.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Kevin Riley on 2/13/19 
 * to go through a database and have 8 threads each do something for distributed computing aka class 444 
 */
public class Project1_444 {
    
    static BufferedReader can = null;
    static File data ;
    static final int size=69501;
    String name;
    public static ArrayList<String> crimes;
    public Project1_444(String name){
         this.name=name;
    }
    public static void main(String[] args) throws FileNotFoundException {
        crimes = new ArrayList<>();
       //String line = null;
        int i=0;
     data = new File("../Crime.csv");
     can = new BufferedReader(new FileReader(data));
     String d="";
     

        try(BufferedReader br = new BufferedReader(new FileReader(data))) {
        for(String line; (line = br.readLine()) != null; ) {
        crimes.add(line);
     //   System.out.println(line);
        }
        // line is not visible here.
        } 

        catch (Exception  ex) {
        ex.printStackTrace();
        }
    
    Thread t1=new Thread(new T1(crimes));
    //t1.run();
    Thread t2=new Thread(new T2());
    t2.run();
     Thread t3=new Thread(new T3());
    t3.run();
    Thread t4=new Thread(new T4());
    t4.run();
    Thread t5=new Thread(new T5());
    t5.run();
    
    Thread t6=new Thread(new T6());
    t6.run();
    
    
    Thread t7=new Thread(new T7());
    t7.run();
    
    
    }
    public  synchronized ArrayList accessData(){
    return crimes;
}

}
class shared{
    private volatile ArrayList<String> crime;
    private final Lock lock;
    private volatile boolean aval;
    shared(){
        aval=false;
        lock = new ReentrantLock();
    }
    
    
}
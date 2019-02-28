/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaded;
import Project1_444.*;
import java.util.ArrayList;
import project1_444.Project1_444;
import static threaded.T1.size;
/**
 *
 * @author kevin
 */
public class T2 implements Runnable{
     static final int size=69501;
    static Project1_444 p1 = new Project1_444("t2");
    public void run(){
        ArrayList<String> crimes=p1.accessData();
         for( int i=0; i< size;i++){
             System.out.println(crimes.get(i));
         }
             
    }
    
}

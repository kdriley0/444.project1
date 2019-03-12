/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_444;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *@author Kevin Riley for 444 Professor Rinard Spring 18 
 * 
 * a attempt to use locks
 *  ***********************************************************NOT REQUIRED********************************************
 */
public class GoingThoughData {
    private final Lock queueLock = new ReentrantLock();
    ArrayList<String> data;
    
    public  GoingThoughData(ArrayList data) {
    this.data=data;
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PParty;
import gui.*;
import Objects.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

/*
Author:  Brian Ha - 190376250
         
Repository:
         https://github.com/PPartyImplementation

 -------------------------------------
 File:    PParty.java
 Description: Runs the program
 Version  4/5/2022
 -------------------------------------
 */
public class PParty {
	private static boolean exit = false;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	 
        Objects.Database database= new Objects.Database();
        JFrame login= gui.login.start(database);
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
            	boolean logged;
            	while(!exit) {

	                try {
	                	Thread.sleep(1000);
	                	 logged=isUserLogged(database);
	                     if(logged) {
	                     	JFrame mainPage = gui.mainpage.start(database);
	                     	login.setVisible(false);
	                     	((gui.login) login).hide_register();
	                     	stop();
	                     	Thread.currentThread().interrupt();
	                     }
	                	}
	                catch(InterruptedException e){
	                	System.out.println("We outta here");
	                	}
	            	}
            }
        }, 0, 1, TimeUnit.SECONDS);
 
        
    
    
    
    }

    public static void stop() {
    	exit=true;
    }

	public static boolean isUserLogged(Objects.Database db) {
		if(db.getCurrUser().isLoggedIn()) {
			System.out.println("Login found");
			return true;
		}
		else {
			System.out.println("No login found");
			return false;
		}
		
	}
	
    
}

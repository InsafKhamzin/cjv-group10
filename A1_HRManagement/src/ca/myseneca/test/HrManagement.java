package ca.myseneca.test;

import java.util.Scanner;

import ca.myseneca.model.DaManager;

public class HrManagement {
	
    public static void main(String[] args) {
        try {

        	Scanner sc = new Scanner(System.in);
        	System.out.println("Please type userid:");
        	String user = sc.next();
        	System.out.println("Please type password:");
        	String pass = sc.next();
        	
        	DaManager daManager = new DaManager();
        	daManager.verifyEmployee(user, pass);
        	
            
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

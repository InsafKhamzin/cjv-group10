package ca.myseneca.test;

import ca.myseneca.model.DaManager;

public class HrManagement {
    public static void main(String[] args) {
        try {

            //TODO
            DaManager.addEmployee(null);
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

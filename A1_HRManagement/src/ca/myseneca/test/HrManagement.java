package ca.myseneca.test;

import java.util.Scanner;

import ca.myseneca.model.DaManager;
import ca.myseneca.model.Employee;

/**
 * HrManagement - class for testing DAL
 */
public class HrManagement {

	public static void main(String[] args) {
        Scanner sc = null;
		try {
        	sc = new Scanner(System.in);
        	System.out.println("Please type user ID:");
        	String user = sc.next();
        	System.out.println("Please type user password:");
        	String pass = sc.next();

        	//Getting the employee's id
        	int employeeId = DaManager.getEmployeeID(user, pass);
        	if(employeeId == 0){
                System.out.println("Wrong user id or password");
                return;
            }
            System.out.println("User logged in!");

            Employee employee = DaManager.getEmployeeById(employeeId);
            if (employee == null){
                System.out.println("Employee not found");
                return;
            }
            System.out.println("Employee info:");
            System.out.println(employee.getInfoString());

            //TODO test the rest of the DAO method
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        finally {
        	if(sc != null) sc.close();
        }
    }
}

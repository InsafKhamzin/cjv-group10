/**
 * 
 */
package ca.myseneca.rmi.client;

import java.rmi.Naming;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import ca.myseneca.model.Employee;
import ca.myseneca.rmi.server.DAManager;

/**
 *
 * This is the Client class for testing the RMI application
 *
 */
public class RMIHRManagement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			DAManager manager = (DAManager) Naming.lookup("rmi://localhost:1099/DAManagerService");
        	sc = new Scanner(System.in);
        	System.out.println("Please type user ID:");
        	String user = sc.next();
        	System.out.println("Please type user password:");
        	String pass = sc.next();

        	//Getting the employee's id
        	int employeeId = manager.getEmployeeID(user, pass);
        	if(employeeId == 0){
                System.out.println("Wrong user id or password");
                return;
            }
            System.out.println("User logged in!");

            Employee employee = manager.getEmployeeById(employeeId);
            if (employee == null){
                System.out.println("Employee not found");
                return;
            }
            System.out.println("User info:");
            System.out.println(employee.getInfoString());

            Employee newEmployee =
                    new Employee(121212, "TestFirstName", "TestLastName",
                            "email@test.com", "534.353.333",
                            new Date(Calendar.getInstance().getTimeInMillis()), "IT_PROG",
                            200000, 0, 103, 60);

            System.out.println("------------------------------------------------------------------------");
            //Add Employee Test
            System.out.println("Test addEmployee");
            boolean addResult = manager.addEmployee(newEmployee);
            if(!addResult){
                System.out.println("Failed to add Employee");
                return;
            }
            System.out.println("Employee added. New Employee info:");
            System.out.println(newEmployee.getInfoString());

            System.out.println("------------------------------------------------------------------------");
            //Update Employee Test
            System.out.println("Test updateEmployee. Changing First and Last names");
            newEmployee.setFirstName("NewTestFirstName");
            newEmployee.setLastName("NewTestLastName");
            boolean updateResult = manager.updateEmployee(newEmployee);
            if(!updateResult){
                System.out.println("Failed to update Employee");
                return;
            }
            System.out.println("Employee " + newEmployee.getEmployeeId() + "  updated. Updated Employee info:");
            System.out.println(newEmployee.getInfoString());
            System.out.println("------------------------------------------------------------------------");

            System.out.println("Test deleteEmployeeById");
            boolean deleteResult = manager.deleteEmployeeById(newEmployee.getEmployeeId());
            if(!deleteResult){
                System.out.println("Failed to delete Employee");
                return;
            }
            System.out.println("Employee " + newEmployee.getEmployeeId() + " deleted");

            System.out.println("------------------------------------------------------------------------");
            System.out.println("Test getAllEmployees");
            ArrayList<Employee> allEmployees = manager.getAllEmployees();
            for(Employee emp : allEmployees){
                System.out.println(emp.getInfoString());
            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Test getEmployeesByDepartmentID 100");
            ArrayList<Employee> employeesByDepartment = manager.getEmployeesByDepartmentID(100);
            for(Employee emp : employeesByDepartment){
                System.out.println(emp.getInfoString());
            }
            System.out.println("------------------------------------------------------------------------");

            System.out.println("Test batchUpdate. Scripts:");
            String[] scripts = new String[]{
                    "UPDATE Employees SET PHONE_NUMBER='123.123.123' WHERE DEPARTMENT_ID=80",
                    "UPDATE Employees SET PHONE_NUMBER='321.321.321' WHERE DEPARTMENT_ID=90",
                    "UPDATE Employees SET PHONE_NUMBER='111.111.111' WHERE DEPARTMENT_ID=100"
            };
            for(String script : scripts){
                System.out.println(script);
            }
            boolean batchResult = manager.batchUpdate(scripts);
            if (!batchResult) {
                System.out.println("Failed to perform batch update");
            }
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
        finally {
        	if(sc != null) sc.close();
        }

	}

}

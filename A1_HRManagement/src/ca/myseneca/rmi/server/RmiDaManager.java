/**
 * 
 */
package ca.myseneca.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ca.myseneca.model.Employee;

/**
 *
 * This DA Manager Interface is similar to the DaManger Class implemented
 * in the data access layer of the application
 *
 */
public interface RmiDaManager extends Remote {

	/**
     * Add employee
     * @param employee - employee object
     */
    public boolean addEmployee(Employee employee) throws RemoteException;
    
    /**
     * Employee verification method. Returns 0 if user and password wasn't found
     * @param user - employee login
     * @param password - employee password
     * @return
     */
    public int getEmployeeID(String user, String password) throws RemoteException;
    
    /**
     * Get the list of all employees
     * @return
     */
    public ArrayList<Employee> getAllEmployees() throws RemoteException;
    
    /**
     * Get the list of employees by certain department
     * @param depid - department id
     * @return
     */
    public ArrayList<Employee> getEmployeesByDepartmentID (int depid) throws RemoteException;
    
    /**
     * Returns employee by employee id
     * @param employeeId employee id
     * @return
     */
    public Employee getEmployeeById(int employeeId) throws RemoteException;
    
    /**
     * Updating employee
     * @param employee employee object
     * @return
     */
    public boolean updateEmployee(Employee employee) throws RemoteException;
    
    /**
     * Delete employee
     * @param employeeId - employee id
     * @return
     */
    public boolean deleteEmployeeById(int employeeId) throws RemoteException;
    
    /**
     * Batch update. Commit on success, rollback if exception occurred
     * @param SQLs
     * @return
     */
    public boolean batchUpdate(String [] SQLs) throws RemoteException;
}

/**
 * 
 */
package ca.myseneca.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import ca.myseneca.model.DaManager;
import ca.myseneca.model.Employee;

/**
 *
 * This is the implementation class of for the RMI interface created.
 *
 */
public class RmiDaManagerImpl extends UnicastRemoteObject implements RmiDaManager {

	protected RmiDaManagerImpl() throws RemoteException {
		super();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return DaManager.addEmployee(employee);
	}

	@Override
	public int getEmployeeID(String user, String password) {
		// TODO Auto-generated method stub
		return DaManager.getEmployeeID(user, password);
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return DaManager.getAllEmployees();
	}

	@Override
	public ArrayList<Employee> getEmployeesByDepartmentID(int depid) {
		// TODO Auto-generated method stub
		return DaManager.getEmployeesByDepartmentID(depid);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return DaManager.getEmployeeById(employeeId);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return DaManager.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return DaManager.deleteEmployeeById(employeeId);
	}

	@Override
	public boolean batchUpdate(String[] SQLs) {
		// TODO Auto-generated method stub
		return DaManager.batchUpdate(SQLs);
	}
	
}

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
public class DAManagerImpl extends UnicastRemoteObject implements DAManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected DAManagerImpl() throws RemoteException {
		super();
	}

	@Override
	public boolean addEmployee(Employee employee) throws RemoteException {
		// TODO Auto-generated method stub
		return DaManager.addEmployee(employee);
	}

	@Override
	public int getEmployeeID(String user, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return DaManager.getEmployeeID(user, password);
	}

	@Override
	public ArrayList<Employee> getAllEmployees() throws RemoteException {
		// TODO Auto-generated method stub
		return DaManager.getAllEmployees();
	}

	@Override
	public ArrayList<Employee> getEmployeesByDepartmentID(int depid) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int employeeId) throws RemoteException {
		// TODO Auto-generated method stub
		return DaManager.getEmployeeById(employeeId);
	}

	@Override
	public boolean updateEmployee(Employee employee) throws RemoteException {
		// TODO Auto-generated method stub
		return DaManager.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployeeById(int employeeId) throws RemoteException {
		// TODO Auto-generated method stub
		return DaManager.deleteEmployeeById(employeeId);
	}

	@Override
	public boolean batchUpdate(String[] SQLs) throws RemoteException {
		// TODO Auto-generated method stub
		return DaManager.batchUpdate(SQLs);
	}
	
}

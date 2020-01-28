/**
 * 
 */
package ca.myseneca.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * 
 * This is the server class for the RMI application
 *
 */
public class DAManagerServer {
	
	public DAManagerServer() {
		try {
			DAManager manager = new DAManagerImpl();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/DAManagerService", manager);
		} catch (Exception e) {
			System.out.println("Something happened... ");
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DAManagerServer();
	}

}

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
public class RmiManagementServer {
	
	public RmiManagementServer() {
		try {
			int port = 1099;
			RmiDaManager manager = new RmiDaManagerImpl();
			LocateRegistry.createRegistry(port);
			Naming.rebind("rmi://localhost:"+port+"/DAManagerService", manager);
			System.out.println("RMI server runs on port " + port);
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
		new RmiManagementServer();
	}

}

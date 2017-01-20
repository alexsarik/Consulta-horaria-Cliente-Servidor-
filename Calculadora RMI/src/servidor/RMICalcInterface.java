package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMICalcInterface extends Remote {
	public int suma(int a, int b) throws RemoteException;

	public int resta(int a, int b) throws RemoteException;

	public int multip(int a, int b) throws RemoteException;

	public int div(int a, int b) throws RemoteException;
}

//La interfaz ha de ser visible para cliente y servidor. Sólo la implementa el servidor.
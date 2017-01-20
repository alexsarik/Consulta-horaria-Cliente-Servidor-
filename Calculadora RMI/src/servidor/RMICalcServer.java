package servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMICalcServer implements RMICalcInterface {
	public int suma(int a, int b) throws RemoteException {
		return (a + b);
	}

	public int resta(int a, int b) throws RemoteException {
		return (a - b);
	}

	public int multip(int a, int b) throws RemoteException {
		return (a * b);
	}

	public int div(int a, int b) throws RemoteException {
		return (a / b);
	}

	public static void main(String[] args) {
		Registry reg = null; //Declaro e inicializo a null un objeto Registry
		try {
			System.out.println("Crea el registro de objetos, escuchando en el puerto 555");
			reg = LocateRegistry.createRegistry(5555); //Creo el registro en el puerto ("Tablón de anuncios")
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido crear el registro");
			e.printStackTrace();
		}
		System.out.println("Creando el objeto servidor");
		RMICalcServer serverObject = new RMICalcServer(); //Creo un objeto de esta misma clase (objeto calculadora)
		try {
			System.out.println("Inscribiendo el objeto servidor en el registro");
			System.out.println("Se le da un nombre único: Calculadora");
			reg.rebind("Calculadora", (RMICalcInterface) UnicastRemoteObject.exportObject(serverObject, 0)); //Inscripción del objeto servidor en el registro(escribimos en el "tablón de anuncios"
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido inscribir el objeto servidor.");
			e.printStackTrace();
		}
	}
}

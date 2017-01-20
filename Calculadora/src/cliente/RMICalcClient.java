package cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import servidor.RMICalcInterface;

public class RMICalcClient {
	public static void main(String[] args) {
		RMICalcInterface calc = null; //referencio e inicializo obj calc
		try {
			System.out.println("Localizando el registro de objetos remitos");
			Registry registry = LocateRegistry.getRegistry("localhost", 5555); //Localiza el "tablón de anuncios". Lo ideal sería poner otra dirección IP, que corresponde a otra máquina (la ip del servidor se pone en lugar de "localhost")
			System.out.println("Obteniendo el stab del objeto remoto");
			calc = (RMICalcInterface) registry.lookup("Calculadora"); //STUB Localiza el objeto creado en servidor. Casteamos interfaz, pues sin ella, no hay realación entre cliente-servidor.
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (calc != null) {
			System.out.println("Realizando operaciones con el objeto remoto");
			try {
				System.out.println("2 + 2 = " + calc.suma(2, 2));
				System.out.println("99 - 45 = " + calc.resta(99, 45));
				System.out.println("125 * 3 = " + calc.multip(125, 3));
				System.out.println("1250 / 5 = " + calc.div(1250, 5));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}
}
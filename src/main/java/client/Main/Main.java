package client.Main;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import client.Controller.Controller;
import client.LP.InicioSesion_Registro;

public class Main {
	
	public static void main(String[] args) throws RemoteException {
		
		new Controller(args);
		
	}

}

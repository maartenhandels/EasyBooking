package client.Main;

import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import client.Controller.Controller;
import client.LP.InicioSesion_Registro;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				
				Controller controller;
				try 
				{
					controller = new Controller();
					InicioSesion_Registro frame = new InicioSesion_Registro(controller);
					frame.setVisible(true);
				
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		
			}
			
		});
		
	}

}

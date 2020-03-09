import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class clsBuscarVuelo extends JFrame 
{
	JLabel txt1, txt2, txt3;
	JTextField txtF1, txtF2, txtF3;
	
	public clsBuscarVuelo ()
	{
		setLayout(null);
		setTitle("Buscador de vuelos EasyBooking");
		
		//Datos del vuelo
		txt1 = new JLabel("Areopuuerto origen:");
		txt1.setFont(new Font("Serif", Font.BOLD, 22));
		txt1.setBounds(30, 260, 400, 40);
		
		txtF1 = new JTextField();
		txtF1.setBounds(425, 260, 50, 40);
		
		txt2 = new JLabel("Areopuuerto destino:");
		txt2.setFont(new Font("Serif", Font.BOLD, 22));
		txt2.setBounds(30, 260, 400, 40);
		
		txtF2 = new JTextField();
		txtF2.setBounds(425, 260, 50, 40);
		
		txt3 = new JLabel("Fecha:");
		txt3.setFont(new Font("Serif", Font.BOLD, 22));
		txt3.setBounds(30, 260, 400, 40);
		
		txtF3 = new JTextField();
		txtF3.setBounds(425, 260, 50, 40);
		//Fin datos del vuelo
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		clsBuscarVuelo ventanaBuscarVuelo = new clsBuscarVuelo();
		
		ventanaBuscarVuelo.setBounds(200, 40, 1000, 850);
		ventanaBuscarVuelo.setVisible(true);
		ventanaBuscarVuelo.setResizable(false);	
	}

}

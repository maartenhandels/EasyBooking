import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class clsBuscarVuelo extends JFrame 
{
	JLabel txt1, txt2, txt3, txt4, txt5;
	JTextField txtF1, txtF2, txtF3;
	JRadioButton rdbtnTarifa1,rdbtnTarifa2 ;
	JComboBox comboPasajeros;
	JButton btnBuscar;
	JPanel p1, p2;
	
	public clsBuscarVuelo ()
	{
		p1=new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p1.setBounds(30, 320, 900, 250);
		p1.setBackground(Color.LIGHT_GRAY);
		
//		p2=new JPanel();
//		p2.setLayout(null);
//		p2.setBounds(50, 30, 50, 50);
//		p2.setBackground(Color.white);
		
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
		
		//Seleccionar numero de pasajeros
		txt4 = new JLabel("Seleccionar pasajeros:");
		txt4.setFont(new Font("Serif", Font.BOLD, 22));
		txt4.setBounds(30, 260, 400, 40);
		
		comboPasajeros = new JComboBox();
		comboPasajeros.setBounds(40, 260, 400, 40);
		comboPasajeros.addItem("1 adulto");
		comboPasajeros.addItem("2 adulto");
		comboPasajeros.addItem("3 adulto");
		
		//Seleccionar tarifa
		txt5=new JLabel("Seleccionar tarifa de vuelo:");
		txt5.setFont(new Font("Serif", Font.BOLD, 22));
		txt5.setBounds(30, 655, 300, 40);
		
		rdbtnTarifa1=new JRadioButton("Turista");
		rdbtnTarifa1.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnTarifa1.setBounds(400, 655, 200, 40);
		
		rdbtnTarifa2=new JRadioButton("Premium");
		rdbtnTarifa2.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnTarifa2.setBounds(600, 655, 200, 40);
		
		//Botón buscar
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Serif", Font.BOLD, 20));
		btnBuscar.setBounds(100, 750, 200, 40);
		
		
		p1.add(txt1);
		p1.add(txtF1);
		p1.add(txt2);
		p1.add(txtF2);
		p1.add(txt3);
		p1.add(txtF3);
		
		
		p1.add(txt4);
		p1.add(comboPasajeros);
		p1.add(txt5);
		p1.add(rdbtnTarifa1);
		p1.add(rdbtnTarifa2);
		p1.add(btnBuscar);
		
		add(p1);
//		add(p2);
	}
	
	
	public static void main(String[] args) 
	{
		clsBuscarVuelo ventanaBuscarVuelo = new clsBuscarVuelo();
		
		ventanaBuscarVuelo.setBounds(200, 40, 1000, 850);
		ventanaBuscarVuelo.setVisible(true);
		ventanaBuscarVuelo.setResizable(false);	
	}

}

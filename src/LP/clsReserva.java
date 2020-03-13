package LP;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * 
 * @author Alumno
 * 
 * La clase permite seleccionar un vuelo, ver los detalles de dicho vuelo 
 * realizar la reserva si se desea. 
 * 
 * Cosas que faltan: 
 * Que funcione el scroll bar
 * La lista de vuelos tiene que proceder del frame de busqueda
 * Al seleccionar uno de los vuelos de la lista se tiene que ver su detalle
 * Al pulsar en reserva te tiene que redirigir a el formulario de reserva
 * El detalle de cada vuelo tiene que venir de la clase vuelo
 */

public class clsReserva extends JFrame 
{
	
	JLabel txt1, txt2;
	JLabel txt3, txt4;
	JLabel txt5, txt6;
	JLabel txt7, txt8;
	JLabel txt9, txt10;
	JPanel p1, p2;
	JList<String> listaVuelos;
	JButton btnReserva, btnVolver;
	JScrollPane scroll;
	
	public clsReserva()
	{
		setLayout(null);
		
		setTitle("Reserva Vuelo");
		
		p1=new JPanel();
		p1.setBounds(30, 60, 700, 200);
		
		txt1=new JLabel("Vuelos disponibles:");
		txt1.setFont(new Font("Serif", Font.BOLD, 24));
		txt1.setBounds(30, 20, 200, 40);
		
		//Array de prueba con vuelos para realizar reserva
		String vuelos[]= {"Vuelo Amsterdam", "Vuelo Sidney", "Vuelo Londres", "Vuelo Oslo", 
				"Vuelo Roma", "Vuelo Madrid", "Vuelo Nueva York"};
		listaVuelos = new JList(vuelos);
		listaVuelos.setSelectedIndex(0);
		listaVuelos.setFixedCellWidth(650);
		listaVuelos.setFixedCellHeight(40);
		listaVuelos.setFont(new Font("Serif", Font.PLAIN, 20));
		
		//No funciona
		scroll=new JScrollPane();
		scroll.setViewportView(listaVuelos);
		
		listaVuelos.setLayoutOrientation(JList.VERTICAL);
		
		btnReserva=new JButton("Reservar");
		btnReserva.setFont(new Font("Serif", Font.BOLD, 20));
		btnReserva.setBounds(750, 100, 175, 40);
		
		btnVolver=new JButton("Nueva B�squeda");
		btnVolver.setFont(new Font("Serif", Font.BOLD, 20));
		btnVolver.setBounds(750, 150, 175, 40);
		
		//Detalle vuelo
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(30, 350, 700, 250);
		p2.setBackground(Color.white);
		
		txt2=new JLabel("Detalle vuelo:");
		txt2.setFont(new Font("Serif", Font.BOLD, 22));
		txt2.setBounds(30, 300, 200, 40);
		
		txt3=new JLabel("Aeropuerto origen:");
		txt3.setFont(new Font("Serif", Font.BOLD, 20));
		txt3.setBounds(10, 10, 200, 25);
		
		txt4=new JLabel("Aeropuerto destino:");
		txt4.setFont(new Font("Serif", Font.BOLD, 20));
		txt4.setBounds(300, 10, 200, 25);
		
		txt7=new JLabel("Bilbao (BIO)");
		txt7.setFont(new Font("Serif", Font.PLAIN, 18));
		txt7.setBounds(10, 50, 200, 25);
		
		txt8=new JLabel("Amsterdam (AMS)");
		txt8.setFont(new Font("Serif", Font.PLAIN, 18));
		txt8.setBounds(300, 50, 200, 25);
		
		txt5=new JLabel("Hora salida:");
		txt5.setFont(new Font("Serif", Font.BOLD, 20));
		txt5.setBounds(10, 100, 200, 25);
		
		txt6=new JLabel("Hora llegada:");
		txt6.setFont(new Font("Serif", Font.BOLD, 20));
		txt6.setBounds(300, 100, 200, 25);
		
		txt9=new JLabel("10:20 am");
		txt9.setFont(new Font("Serif", Font.PLAIN, 20));
		txt9.setBounds(10, 150, 200, 25);
		
		txt10=new JLabel("12:30 pm");
		txt10.setFont(new Font("Serif", Font.PLAIN, 20));
		txt10.setBounds(300, 150, 200, 25);
		
		p1.add(listaVuelos);
		p1.add(scroll);
		
		p2.add(txt3);
		p2.add(txt4);
		p2.add(txt5);
		p2.add(txt6);
		p2.add(txt7);
		p2.add(txt8);
		p2.add(txt9);
		p2.add(txt10);
		
		add(btnReserva);
		add(btnVolver);
		add(p1);
		add(p2);
		add(txt1);
		add(txt2);
		
	}

	public static void main(String[] args) 
	{
		
		clsReserva ventanaReserva = new clsReserva();
		
		ventanaReserva.setBounds(200, 70, 1000, 700);
		ventanaReserva.setVisible(true);
		ventanaReserva.setResizable(false);	

	}
	
}

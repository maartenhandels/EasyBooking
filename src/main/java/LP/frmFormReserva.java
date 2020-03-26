package LP;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

/**
 * 
 * @author Alumno
 * Formulario necesario a rellenar para poder realizar una reserva
 * 
 * Cosas que faltan:
 * En los 5 primero items faltan JLabels para imprimir los datos del vuelo
 * En el TextField de asientos hay que realizar una comprobacion
 * Crear tantos formularios como asientos seleccionados en panel2
 */

public class frmFormReserva extends JFrame 
{

	JLabel txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9;
	JLabel txt10, txt11, txt12;
	JTextField txtF1, txtF2, txtF3, txtF4;
	JPanel p1, p2;
	JRadioButton rdbtnModoPago1,rdbtnModoPago2 ;
	JButton btnCancelar, btnReservar;
	
	public frmFormReserva()
	{
		
		setLayout(null);
		
		setTitle("Datos reserva");
		
		txt1 = new JLabel("El codigo del vuelo seleccionado es:");
		txt1.setFont(new Font("Serif", Font.BOLD, 22));
		txt1.setBounds(30, 20, 400, 40);
		
		txt2 = new JLabel("El origen del vuelo:");
		txt2.setFont(new Font("Serif", Font.BOLD, 22));
		txt2.setBounds(30, 80, 400, 40);
		
		txt3 = new JLabel("El destino del vuelo:");
		txt3.setFont(new Font("Serif", Font.BOLD, 22));
		txt3.setBounds(500, 80, 400, 40);
		
		txt4 = new JLabel("Aerolinea:");
		txt4.setFont(new Font("Serif", Font.BOLD, 22));
		txt4.setBounds(30, 140, 400, 40);
		
		txt5 = new JLabel("Nombre de usuario:");
		txt5.setFont(new Font("Serif", Font.BOLD, 22));
		txt5.setBounds(30, 200, 400, 40);
		
		txt6 = new JLabel("Numero de asientos a reservar:");
		txt6.setFont(new Font("Serif", Font.BOLD, 22));
		txt6.setBounds(30, 260, 400, 40);
		
		txtF1 = new JTextField();
		txtF1.setBounds(425, 260, 50, 40);
		
		p1=new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p1.setBounds(30, 320, 900, 250);
		p1.setBackground(Color.black);
		
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(50, 30, 50, 50);
		p2.setBackground(Color.white);
		
		//Meter en un for para que salgan tantos formularios como asientos
		//--------- FORMULARIO PASAJEROS ------------
		txt7=new JLabel("Nombre pasajero x:");
		txt7.setFont(new Font("Serif", Font.BOLD, 20));
		txt7.setBounds(50, 10, 200, 40);
		
		txtF2 = new JTextField();
		txtF2.setBounds(300, 10, 300, 40);
		
		txt8=new JLabel("Apellidos pasajero x:");
		txt8.setFont(new Font("Serif", Font.BOLD, 20));
		txt8.setBounds(50, 65, 200, 40);
		
		txtF3 = new JTextField();
		txtF3.setBounds(300, 65, 300, 40);
		
		txt9=new JLabel("DNI pasajero x:");
		txt9.setFont(new Font("Serif", Font.BOLD, 20));
		txt9.setBounds(50, 120, 200, 40);
		
		txtF4 = new JTextField();
		txtF4.setBounds(300, 120, 300, 40);
		
		//-------------- FIN FORM PASAJEROS --------------
		
		txt10=new JLabel("-------Realizar Pago---------");
		txt10.setFont(new Font("Serif", Font.BOLD, 30));
		txt10.setBounds(30, 600, 400, 40);
		
		txt11=new JLabel("Total a pagar:");
		txt11.setFont(new Font("Serif", Font.BOLD, 22));
		txt11.setBounds(650, 600, 400, 40);
		
		txt12=new JLabel("Seleccionar modo de pago:");
		txt12.setFont(new Font("Serif", Font.BOLD, 22));
		txt12.setBounds(30, 655, 300, 40);
		
		rdbtnModoPago1=new JRadioButton("PayPal");
		rdbtnModoPago1.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnModoPago1.setBounds(400, 655, 200, 40);
		
		rdbtnModoPago2=new JRadioButton("Tarjeta de credito");
		rdbtnModoPago2.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnModoPago2.setBounds(600, 655, 200, 40);
		
		btnCancelar = new JButton("Cancelar reserva");
		btnCancelar.setFont(new Font("Serif", Font.BOLD, 20));
		btnCancelar.setBounds(100, 750, 200, 40);
		
		btnReservar = new JButton("Confirmar reserva");
		btnReservar.setFont(new Font("Serif", Font.BOLD, 20));
		btnReservar.setBounds(700, 750, 200, 40);
		
		p2.add(txt7);
		p2.add(txtF2);
		p2.add(txt8);
		p2.add(txtF3);
		p2.add(txt9);
		p2.add(txtF4);
		
		p1.add(p2);
		
		add(txt1);
		add(txt2);
		add(txt3);
		add(txt4);
		add(txt5);
		add(txt6);
		add(txt10);
		add(txt11);
		add(txt12);
		add(txtF1);
		add(p1);
		add(rdbtnModoPago1);
		add(rdbtnModoPago2);
		add(btnCancelar);
		add(btnReservar);
	}
	
	
	public static void main(String[] args) 
	{
		frmFormReserva ventanaFormReserva = new frmFormReserva();
		
		ventanaFormReserva.setBounds(200, 40, 1000, 850);
		ventanaFormReserva.setVisible(true);
		ventanaFormReserva.setResizable(false);	
		ventanaFormReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

}

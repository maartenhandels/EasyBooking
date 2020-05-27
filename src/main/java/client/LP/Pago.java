package client.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Controller.Controller;
import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Pago extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	private JTextField textField_Nombre;
	private JTextField textField_Ape;
	private JTextField textField_Email;
	private JTextField textField_Saldo_Ini;
	private JTextField textField_Email_Pago;
	private JTextField textField_Concepto;
	
	private JLabel lblServicioPagos;
	private JLabel lblCrearCuenta;
	private JLabel lblEmail;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblSaldoInicialCuenta;
	private JLabel lblNewLabel;
	private JLabel lblCantidadAPagar;
	private JLabel lblEmail_1;
	private JLabel lblAquiSaldrPrecio;
	private JLabel lblConcepto;
	
	private JButton btnActualizarSaldo;
	private JButton btnCrear;
	private JButton btnRealizarPago;
	
	private static Controller controller;
	private VueloDTO vuelo;
	
	/**
	 * Create the frame.
	 */
	public Pago(Controller controller, VueloDTO vuelo) 
	{
		Pago.controller = controller;
		this.vuelo= vuelo;
		init_componentes(vuelo);
		setVisible(true);
	}
	
		public void init_componentes(VueloDTO vuelo)
		{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 636, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblServicioPagos = new JLabel("- SERVICIO PAGOS -");
		lblServicioPagos.setBounds(123, 8, 296, 40);
		lblServicioPagos.setFont(new Font("Century Gothic", Font.BOLD, 30));
		panel.add(lblServicioPagos);
		
		btnActualizarSaldo = new JButton("Actualizar Saldo");
		btnActualizarSaldo.setBounds(458, 8, 163, 29);
		btnActualizarSaldo.setFont(new Font("Century Gothic", Font.BOLD, 15));
		panel.add(btnActualizarSaldo);
		btnActualizarSaldo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				actualizarSaldo frame = new actualizarSaldo(controller, vuelo);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(10, 65, 302, 465);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblCrearCuenta = new JLabel("CREAR CUENTA");
		lblCrearCuenta.setForeground(Color.WHITE);
		lblCrearCuenta.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblCrearCuenta.setBounds(68, 13, 183, 20);
		panel_1.add(lblCrearCuenta);
		
		btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCrear.setBounds(90, 420, 115, 29);
		panel_1.add(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(textField_Ape.getText().isEmpty()||textField_Nombre.getText().isEmpty()|| textField_Email.getText().isEmpty() || textField_Saldo_Ini.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Introduzca todos los datos","Crear cuenta servicio pago",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(textField_Email.getText()) == true )
					{
						String email = textField_Email.getText();
						String name = textField_Nombre.getText();
						String username = textField_Ape.getText();
						
						Usuario us = new Usuario(name, username, email);
						
						String div = textField_Saldo_Ini.getText();
						
						//tendremos que comprobar que es un numero
						float divisa = Float.parseFloat(div);
						
						boolean verificar=false;
						
						try 
						{
							verificar = controller.create_User_Pago(us, divisa);
						} catch (RemoteException e1) 
						{
							System.out.println("No se puede crear usuario pago");
							e1.printStackTrace();
						}
						
						if(verificar == true)
						{
							JOptionPane.showMessageDialog(null,"Usuario creado con exito, ya puede realizar el pago de la reserva","Usuario Pago",JOptionPane.INFORMATION_MESSAGE);
							dispose();
							Pago frame = new Pago(controller, vuelo);
							frame.setVisible(true);
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Email no válido","Actualizar saldo",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(15, 52, 155, 20);
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblNombre);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setBounds(15, 88, 250, 26);
		panel_1.add(textField_Nombre);
		textField_Nombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(15, 140, 136, 20);
		lblApellido.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblApellido);
		
		textField_Ape = new JTextField();
		textField_Ape.setBounds(15, 176, 250, 26);
		panel_1.add(textField_Ape);
		textField_Ape.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(15, 229, 136, 20);
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblEmail);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(15, 265, 250, 26);
		panel_1.add(textField_Email);
		textField_Email.setColumns(10);
		
		lblSaldoInicialCuenta = new JLabel("Saldo inicial cuenta");
		lblSaldoInicialCuenta.setForeground(Color.WHITE);
		lblSaldoInicialCuenta.setBounds(15, 321, 250, 20);
		lblSaldoInicialCuenta.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_1.add(lblSaldoInicialCuenta);
		
		textField_Saldo_Ini = new JTextField();
		textField_Saldo_Ini.setBounds(15, 354, 250, 26);
		panel_1.add(textField_Saldo_Ini);
		textField_Saldo_Ini.setColumns(10);
		
		//--------------- Panel realizar pago --------------------
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(327, 65, 294, 465);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("REALIZAR PAGO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel.setBounds(40, 0, 210, 48);
		panel_2.add(lblNewLabel);
		
		lblCantidadAPagar = new JLabel("Cantidad");
		lblCantidadAPagar.setForeground(Color.WHITE);
		lblCantidadAPagar.setBounds(15, 51, 212, 26);
		lblCantidadAPagar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_2.add(lblCantidadAPagar);
		
		lblEmail_1 = new JLabel("Email");
		lblEmail_1.setForeground(Color.WHITE);
		lblEmail_1.setBounds(15, 229, 69, 20);
		lblEmail_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_2.add(lblEmail_1);
		
		textField_Email_Pago = new JTextField();
		textField_Email_Pago.setBounds(15, 262, 254, 26);
		panel_2.add(textField_Email_Pago);
		textField_Email_Pago.setColumns(10);
		
		btnRealizarPago = new JButton("Realizar Pago");
		btnRealizarPago.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRealizarPago.setBounds(66, 423, 172, 29);
		panel_2.add(btnRealizarPago);
		btnRealizarPago.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(textField_Email_Pago.getText().isEmpty()||textField_Concepto.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Introduzca todos los datos","Realizar pago pago",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(textField_Email_Pago.getText()) == true )
					{
						String email = textField_Email_Pago.getText();
						String concepto = textField_Concepto.getText();
					
						Float cant_total = vuelo.getPrecio();
						
						String id_pago="";
						
						
						try 
						{
							id_pago = controller.realizarPago( email, cant_total, concepto);
						} catch (RemoteException e1) 
						{
							System.out.println("No se puede realizar pago");
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Pago realizado con éxito. El id de su pago es:  " + id_pago , "USUARIO CREADO", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						UsuarioDTO usuario_prueba = new UsuarioDTO("Ibone", "Urquiola", "iboneurquiola@gmail.com", "72557745R");
//						buscadorPrincipal frame = new buscadorPrincipal(controller, usuario_prueba);
//						frame.setVisible(true);
//						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Email no válido","Actualizar saldo",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		panel_3 = new JPanel();
		panel_3.setBounds(15, 93, 264, 124);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		lblAquiSaldrPrecio = new JLabel(Float.toString(vuelo.getPrecio()) + "€");
		lblAquiSaldrPrecio.setBounds(93, 50, 117, 20);
		lblAquiSaldrPrecio.setFont(new Font("Century Gothic", Font.BOLD, 26));
		panel_3.add(lblAquiSaldrPrecio);
		
		lblConcepto = new JLabel("Concepto");
		lblConcepto.setForeground(Color.WHITE);
		lblConcepto.setFont(new Font("Dialog", Font.BOLD, 18));
		lblConcepto.setBounds(15, 323, 137, 20);
		lblAquiSaldrPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_2.add(lblConcepto);
		
		textField_Concepto = new JTextField();
		textField_Concepto.setBounds(15, 356, 252, 26);
		panel_2.add(textField_Concepto);
		textField_Concepto.setColumns(10);
	}
		
		 public static boolean ValidarMail(String email) 
		 {
		        // Patron para validar el email
		        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		 
		        Matcher mather = pattern.matcher(email);
		        return mather.find();
		}
}


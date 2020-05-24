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
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
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
		lblServicioPagos.setBounds(132, 0, 251, 40);
		lblServicioPagos.setFont(new Font("Century Gothic", Font.BOLD, 24));
		panel.add(lblServicioPagos);
		
		btnActualizarSaldo = new JButton("Actualizar Saldo");
		btnActualizarSaldo.setBounds(458, 8, 163, 29);
		btnActualizarSaldo.setFont(new Font("Century Gothic", Font.BOLD, 12));
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
		
		lblCrearCuenta = new JLabel("Crear cuenta");
		lblCrearCuenta.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblCrearCuenta.setBounds(82, 16, 183, 20);
		panel_1.add(lblCrearCuenta);
		
		btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnCrear.setBounds(90, 420, 115, 29);
		panel_1.add(btnCrear);
		btnCrear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(textField_1.getText().isEmpty()||textField.getText().isEmpty()|| textField_2.getText().isEmpty() || textField_3.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Introduzca todos los datos","Crear cuenta servicio pago",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(textField_2.getText()) == true )
					{
						String email = textField_2.getText();
						String name = textField.getText();
						String username = textField_1.getText();
						
						Usuario us = new Usuario(name, username, email);
						
						String div = textField_3.getText();
						
						//tendremos que comprobar que es un numero
						float divisa = Float.parseFloat(div);
						
						try 
						{
							controller.create_User_Pago(us, divisa);
						} catch (RemoteException e1) 
						{
							System.out.println("No se puede crear usuario pago");
							e1.printStackTrace();
						}
//						dispose();
//						Pago frame = new Pago(controller);
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
		
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 52, 69, 20);
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_1.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(26, 88, 250, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(15, 140, 69, 20);
		lblApellido.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_1.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 176, 250, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(15, 229, 69, 20);
		lblEmail.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_1.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(25, 265, 250, 26);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		lblSaldoInicialCuenta = new JLabel("Saldo inicial cuenta");
		lblSaldoInicialCuenta.setBounds(15, 321, 250, 20);
		lblSaldoInicialCuenta.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_1.add(lblSaldoInicialCuenta);
		
		textField_3 = new JTextField();
		textField_3.setBounds(26, 357, 250, 26);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		//--------------- Panel realizar pago --------------------
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(327, 65, 294, 465);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("Realizar pago");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(81, 0, 158, 48);
		panel_2.add(lblNewLabel);
		
		lblCantidadAPagar = new JLabel("Cantidad a pagar");
		lblCantidadAPagar.setBounds(15, 57, 158, 20);
		lblCantidadAPagar.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_2.add(lblCantidadAPagar);
		
		lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(15, 229, 69, 20);
		lblEmail_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_2.add(lblEmail_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(25, 265, 254, 26);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		btnRealizarPago = new JButton("Realizar Pago");
		btnRealizarPago.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnRealizarPago.setBounds(81, 420, 146, 29);
		panel_2.add(btnRealizarPago);
		btnRealizarPago.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(textField_4.getText().isEmpty()||textField_5.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Introduzca todos los datos","Realizar pago pago",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(textField_4.getText()) == true )
					{
						String email = textField_4.getText();
						String concepto = textField_5.getText();
					
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
						buscadorPrincipal frame = new buscadorPrincipal(controller, usuario_prueba);
						frame.setVisible(true);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblAquiSaldrPrecio.setBounds(63, 54, 128, 20);
		lblAquiSaldrPrecio.setFont(new Font("Century Gothic", Font.BOLD, 26));
		panel_3.add(lblAquiSaldrPrecio);
		
		lblConcepto = new JLabel("Concepto");
		lblConcepto.setBounds(15, 323, 69, 20);
		lblAquiSaldrPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_2.add(lblConcepto);
		
		textField_5 = new JTextField();
		textField_5.setBounds(27, 356, 252, 26);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
	}
		
		 public static boolean ValidarMail(String email) 
		 {
		        // Patron para validar el email
		        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		 
		        Matcher mather = pattern.matcher(email);
		        return mather.find();
		}
}


package client.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Controller.Controller;
import server.DTO.VueloDTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class actualizarSaldo extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	
	private JTextField textField;
	private JTextField textField_1;
	
	private JLabel lblActualizarSaldoCuenta;
	private JLabel lblEmail;
	private JLabel lblNuevaCantidad;
	
	private JButton btnActualizar;

	private static Controller controller;
	private VueloDTO vuelo;
	
	/**
	 * Create the frame.
	 */
	public actualizarSaldo(Controller controller, VueloDTO vuelo) 
	{
		actualizarSaldo.controller = controller;
		this.vuelo= vuelo;
		init_componentes(vuelo);
		setVisible(true);
	}
	
	public void init_componentes(VueloDTO vuelo)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 454, 345);
		setSize(454,345);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 488, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblActualizarSaldoCuenta = new JLabel("Actualizar saldo cuenta");
		lblActualizarSaldoCuenta.setBounds(94, 16, 277, 20);
		lblActualizarSaldoCuenta.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panel.add(lblActualizarSaldoCuenta);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(15, 57, 92, 20);
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 18));
		contentPane.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(15, 90, 328, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNuevaCantidad = new JLabel("Nueva cantidad");
		lblNuevaCantidad.setBounds(15, 144, 191, 20);
		lblNuevaCantidad.setFont(new Font("Century Gothic", Font.BOLD, 18));
		contentPane.add(lblNuevaCantidad);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 184, 328, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(95, 158, 160));
		btnActualizar.setBounds(142, 244, 141, 29);
		btnActualizar.setFont(new Font("Century Gothic", Font.BOLD, 20));
		contentPane.add(btnActualizar);
		btnActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()||textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Introduzca todos los datos","Actualizar saldo",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(textField.getText()) == true )
					{
						String email = textField.getText();
						String div = textField_1.getText();
						
						System.out.println("El email que manda es: " + email);
						
						//tendremos que comprobar que es un numero
						float currency = Float.parseFloat(div);
						
						try 
						{
							controller.update_currency(email, currency);
						} catch (RemoteException e1) 
						{
							System.out.println("Datos actualizar saldo incorrectos");
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null,"Saldo actualizado correctamente","Actualizar saldo",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						Pago frame = new Pago(controller, vuelo);
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
	}
	
	 public static boolean ValidarMail(String email) 
	 {
	        // Patron para validar el email
	        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	 
	        Matcher mather = pattern.matcher(email);
	        return mather.find();
	}

}

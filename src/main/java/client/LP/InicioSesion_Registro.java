package client.LP;

import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;

import client.Controller.Controller;
import server.LD.Aeropuerto;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Clase para crear la pantalla de inicio de sesión. En ella el usuario tendrá la posibilidad de iniciar sesión o de crearse una 
 * cuenta en caso de no tenerla. 
 * @author Human Compilers
 *
 */
public class InicioSesion_Registro extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_n;
	private JTextField textField_ape;
	private JTextField textField_dni;
	private JTextField textField_email;
	private JPasswordField contra_reg;
	private JPasswordField contraField;
	
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	
	private JLabel lblInicioDeSesion;
	private JLabel lblEmail;
	private JLabel label_1;
	private JLabel lblEasyBooking;
	private JLabel label;
	private JLabel lblImage;
	private JLabel lblDisfrutaDeLa;
	private JLabel label_nombre;
	private JLabel label_apellido;
	private JLabel label_dni;
	private JLabel label_email;
	private JLabel label_contra;
	private JLabel label_aero;
	private JLabel lblImage4;

	private ImageIcon img;
	private ImageIcon img2;
	private ImageIcon img3;
	private ImageIcon img4;
	
	private JButton btnEntrar;
	private JButton btn1;
	private JButton btn2;
	private JButton button;
	
	private JComboBox comboAero;

	private static Controller controller;
	private JLabel lblAjustes;
	
	public InicioSesion_Registro(Controller controller) {
		
		this.controller = controller;
		initComponents();
//		setVisible(true);
	}
	
	public void initComponents()
	{
		setTitle("Inicio de Sesión/Registro - EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 493);
		Image image = new ImageIcon("src/main/resources/images/Flight_prin.png").getImage();
		setIconImage(image);
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(1020, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBounds(15, 318, 336, 410);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		lblInicioDeSesion = new JLabel("INICIO DE SESION");
		lblInicioDeSesion.setForeground(new Color(255, 255, 255));
		lblInicioDeSesion.setBounds(49, 16, 232, 31);
		lblInicioDeSesion.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_3.add(lblInicioDeSesion);
		
		textField = new JTextField();
		textField.setBounds(15, 130, 306, 40);
		panel_3.add(textField);
		textField.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblEmail.setBounds(15, 83, 88, 31);
		panel_3.add(lblEmail);
		
		label_1 = new JLabel("Contrasenya");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		label_1.setBounds(15, 207, 142, 31);
		panel_3.add(label_1);
		
		contraField = new JPasswordField();
		contraField.setColumns(10);
		contraField.setBounds(15, 254, 306, 40);
		panel_3.add(contraField);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnEntrar.setBounds(101, 354, 119, 40);
		panel_3.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty() || contraField.getPassword()==null)
				{
					JOptionPane.showMessageDialog(null,"Te faltan campos de información por rellenar","INICIO SESIÓN",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					//Enviar a servicio externo autenticación --> Si es incorrecto decirle que se registre/revise datos
					dispose();
					String email = textField.getText();
					String contra = contraField.getPassword().toString();
					controller.iniciarSesion(email, contra);
					
					buscadorPrincipal frame = new buscadorPrincipal(controller, email);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});

		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(0, 0, 1020, 60);
		getContentPane().add(panel_1);
		
		lblEasyBooking = new JLabel("EASYBOOKING");
		lblEasyBooking.setForeground(new Color(255, 255, 255));
		lblEasyBooking.setFont(new Font("Century Gothic", Font.BOLD, 40));
		panel_1.add(lblEasyBooking);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(377, 318, 600, 410);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		label_nombre = new JLabel("Nombre");
		label_nombre.setForeground(new Color(255, 255, 255));
		label_nombre.setBounds(10, 60, 100, 30);
		label_nombre.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_2.add(label_nombre);
		
		textField_n = new JTextField();
		textField_n.setBounds(10, 90, 270, 30);
		panel_2.add(textField_n);
		
		label_apellido = new JLabel("Apellido");
		label_apellido.setForeground(new Color(255, 255, 255));
		label_apellido.setBounds(300, 60, 100, 30);
		label_apellido.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_2.add(label_apellido);
		
		textField_ape = new JTextField();
		textField_ape.setBounds(300, 90, 270, 30);
		panel_2.add(textField_ape);
		
		label_email = new JLabel("Email");
		label_email.setForeground(new Color(255, 255, 255));
		label_email.setBounds(10, 150, 100, 30);
		label_email.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_2.add(label_email);
		
		textField_email = new JTextField();
		textField_email.setBounds(10, 180, 270, 30);
		panel_2.add(textField_email);
		
		label_dni = new JLabel("DNI");
		label_dni.setForeground(new Color(255, 255, 255));
		label_dni.setBounds(300, 150, 100, 30);
		label_dni.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_2.add(label_dni);
		
		textField_dni = new JTextField();
		textField_dni.setBounds(300, 180, 270, 30);
		panel_2.add(textField_dni);
		
		label_contra = new JLabel("Contrasenya");
		label_contra.setForeground(new Color(255, 255, 255));
		label_contra.setBounds(10, 240, 200, 30);
		label_contra.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_2.add(label_contra);
		
		contra_reg = new JPasswordField();
		contra_reg.setBounds(10, 270, 270, 30);
		panel_2.add(contra_reg);
		
		label_aero = new JLabel("Aeropuerto Predeterminado");
		label_aero.setForeground(new Color(255, 255, 255));
		label_aero.setBounds(300, 240, 500, 30);
		label_aero.setFont(new Font("Century Gothic", Font.BOLD, 18));
		panel_2.add(label_aero);
		
		List<Aeropuerto> aeros = new ArrayList<>();
		
		Aeropuerto aer1 = new Aeropuerto("BIO", "Loiu");
		Aeropuerto aer2 = new Aeropuerto("MAD", "Barajas");
		Aeropuerto aer3 = new Aeropuerto("CDG", "Paris");
		
		aeros.add(aer1);
		aeros.add(aer2);
		aeros.add(aer3);
		
		List <String> aero_n = new ArrayList<>();
		
		for (Aeropuerto e: aeros)
		{
			String nombre = e.getNombre();
			aero_n.add(nombre);
		}
		
		comboAero = new JComboBox(aero_n.toArray());
		comboAero.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		comboAero.setBounds(300, 270, 270, 30);
		panel_2.add(comboAero);
		
		
		label = new JLabel("REGISTRO");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(250, 16, 232, 32);
		label.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_2.add(label);
		
		button = new JButton("Registrar");
		button.setFont(new Font("Century Gothic", Font.BOLD, 18));
		button.setBounds(250, 354, 119, 40);
		panel_2.add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(textField_n.getText().isEmpty() || contra_reg.getPassword()==null || textField_ape.getText().isEmpty()|| textField_email.getText().isEmpty()
						|| textField_dni.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Te faltan campos de información por rellenar","INICIO SESIÓN",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					//Enviar a servicio externo autenticación --> Si es incorrecto decirle que se registre/revise datos
					dispose();
					String nombre = textField_n.getText();
					String apellido = textField_ape.getText();
					String contrasenya = contra_reg.getPassword().toString();
					String email = textField_email.getText();
					String dni = textField_dni.getText();
					Aeropuerto aero = (Aeropuerto)comboAero.getSelectedItem();
				
					controller.nuevoUsuario(nombre, apellido, email, contrasenya, dni, aero, true, true);
					
					buscadorPrincipal frame = new buscadorPrincipal(controller, email);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});

		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(95, 158, 160));
		panel_4.setBounds(0, 58, 1020, 200);
		panel_4.setLayout(null);
		getContentPane().add(panel_4);
		
		img = new ImageIcon("src/main/resources/images/flight.png");
		lblImage = new JLabel(img);
		lblImage.setBounds(400, 0, 200, 200);
		panel_4.add(lblImage);
		
		panel_5 = new JPanel();
		panel_5.setForeground(new Color(255, 255, 255));
		panel_5.setBounds(0, 83, 400, 17);
		panel_4.add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setForeground(new Color(255, 255, 255));
		panel_6.setBounds(590, 83, 650, 17);
		panel_4.add(panel_6);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 258, 1000, 60);
		getContentPane().add(panel);
		
		img4 = new ImageIcon("src/main/resources/images/config.png");
		panel.setLayout(null);
		btn2 = new JButton(img4);
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(43, 5, 52, 47);
		panel.add(btn2);
		
		btn2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				Configuracion frame = new Configuracion(controller);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		lblDisfrutaDeLa = new JLabel("¡Disfruta de la experiencia completa!");
		lblDisfrutaDeLa.setBounds(277, 5, 454, 32);
		lblDisfrutaDeLa.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel.add(lblDisfrutaDeLa);
		
		lblAjustes = new JLabel("Ajustes");
		lblAjustes.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAjustes.setBounds(97, 15, 67, 29);
		panel.add(lblAjustes);
		
	}
	
	public static void main(String args[])
	{
		InicioSesion_Registro bp = new InicioSesion_Registro(controller);
		bp.setVisible(true);
	}
}


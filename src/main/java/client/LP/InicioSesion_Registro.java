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
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner.DefaultEditor;

import client.Controller.Controller;
import server.DTO.UsuarioDTO;
import server.LD.Aeropuerto;
import server.LD.Usuario;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Clase para crear la pantalla de inicio de sesión. En ella el usuario tendrá la posibilidad de iniciar sesión o de crearse una 
 * cuenta en caso de no tenerla. 
 * @author Human Compilers
 *
 */
public class InicioSesion_Registro extends JFrame{

	private JTextField TxtField_Email_Login;
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
	private JButton btnAjustes;
	private JButton btnRegistrar;
	
	private JComboBox comboAero;

	private static Controller controller;
	private JLabel lblAjustes;
	
	private UsuarioDTO usActual;
	
	public InicioSesion_Registro(Controller controller) {
		
		InicioSesion_Registro.controller = controller;
		initComponents();
//		setVisible(true);
	}
	
	public void initComponents()
	{
		setTitle("Inicio de Sesión/Registro - EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 900, 450);
		setSize(900,450);
		setLocationRelativeTo(null);
		Image image = new ImageIcon("src/main/resources/images/Flight_prin.png").getImage();
		setIconImage(image);
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(1020, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBounds(15, 318, 336, 380);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		lblInicioDeSesion = new JLabel("INICIO DE SESION");
		lblInicioDeSesion.setForeground(new Color(255, 255, 255));
		lblInicioDeSesion.setBounds(49, 16, 232, 31);
		lblInicioDeSesion.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_3.add(lblInicioDeSesion);
		
		TxtField_Email_Login = new JTextField();
		TxtField_Email_Login.setBounds(15, 130, 306, 40);
		panel_3.add(TxtField_Email_Login);
		TxtField_Email_Login.setColumns(10);
		
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
		contraField.setBounds(15, 254, 306, 40);
		panel_3.add(contraField);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnEntrar.setBounds(101, 330, 119, 40);
		panel_3.add(btnEntrar);
		
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				//para comprobar field de contra contraField.getPassword()==null
				if(TxtField_Email_Login.getText().isEmpty() || String.valueOf(contraField.getPassword()).isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Te faltan campos de información por rellenar","INICIO SESIÓN",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(TxtField_Email_Login.getText()) == true) 
					{
						String email = TxtField_Email_Login.getText();
						//String contra = contraField.getPassword().toString();
						String contra = String.valueOf(contraField.getPassword());
						
						System.out.println("La contraseña del passwordField es: "+ contra);
						
						System.out.println("La contrasenya en LP es: " + contra);
						
						UsuarioDTO usuario = null;
						
						try 
						{
							usuario = controller.iniciarSesion(email, contra);
						} catch (RemoteException e1) 
						{
							e1.printStackTrace();
						}
						
						//Si es incorrecto decirle que se registre/revise datos
						if(usuario != null) {
							dispose();
							buscadorPrincipal frameBuscador = new buscadorPrincipal(controller, usuario);
							frameBuscador.setVisible(true);
							frameBuscador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frameBuscador.setResizable(false);
							
						}else {
							JOptionPane.showMessageDialog(null,"Los datos introducidos no son correctos","INICIO SESIÓN",JOptionPane.INFORMATION_MESSAGE);
						}
						
			        } 
					else
					{
						JOptionPane.showMessageDialog(null,"Email no válido","INICIO SESIÓN",JOptionPane.INFORMATION_MESSAGE);

					}
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
		panel_2.setBounds(377, 318, 600, 380);
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
		
		label_aero = new JLabel("Aeropuerto Predeterminado");
		label_aero.setForeground(new Color(255, 255, 255));
		label_aero.setBounds(155, 240, 500, 30);
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
		comboAero.setBounds(155, 270, 270, 30);
		panel_2.add(comboAero);
		
		
		label = new JLabel("REGISTRO");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(250, 16, 232, 32);
		label.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_2.add(label);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnRegistrar.setBounds(250, 330, 119, 40);
		panel_2.add(btnRegistrar);
		
		btnRegistrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(textField_n.getText().isEmpty() || textField_ape.getText().isEmpty()|| textField_email.getText().isEmpty()
						|| textField_dni.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Te faltan campos de información por rellenar","INICIO SESIÓN",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(textField_dni.getText().length()!=9)
				{
					JOptionPane.showMessageDialog(null,"DNI no válido","INICIO SESIÓN",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(textField_email.getText()) == true )
					{
						//Enviar a servicio externo autenticación --> Si es incorrecto decirle que se registre/revise datos
						
						//CREO QUE PETA SI SE METE UN CORREO QUE YA SE HAYA REGISTRADO 
						
						String nombre = textField_n.getText();
						String apellido = textField_ape.getText();
						String email = textField_email.getText();
						String dni = textField_dni.getText();
						System.out.println("LLega aquii dni\n");
						String aero_nombre = (String)comboAero.getSelectedItem();
						
						UsuarioDTO user = new UsuarioDTO(email, nombre, apellido, dni);
						
						System.out.println("LLega aquii\n");
						
						Aeropuerto aero_seleccionado = new Aeropuerto();
						
						for(Aeropuerto a: aeros)
						{
							System.out.println("entro al for\n");
							if(a.getNombre().equalsIgnoreCase(aero_nombre)) 
							{
								aero_seleccionado = a;
								System.out.println("Aeropuerto Seleccionado: " +aero_seleccionado.getNombre());
								break;
							}
						}
					
						System.out.println("salgo del for\n");
						String contrasenya = null;
						
						try {
							System.out.println("voy al controller\n");
							contrasenya = controller.registroUsuario(nombre, apellido, email, dni, aero_nombre);
						} catch (RemoteException e1)
						{
							e1.printStackTrace();
						}
						
						System.out.println("Ha hecho la llamada a registroUsuario");
						
						if(contrasenya != null) {
							JOptionPane.showMessageDialog(null,"Tu contraseña es: " + contrasenya.toString() + " ¡NO LA OLVIDE!", "USUARIO CREADO", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							buscadorPrincipal frameBuscador = new buscadorPrincipal(controller, user);
							frameBuscador.setVisible(true);
							frameBuscador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frameBuscador.setResizable(false);
						} else {
							JOptionPane.showMessageDialog(null,"Este usuario no ha podido crearse, es posible que este email ya este registrado", "ERROR", JOptionPane.INFORMATION_MESSAGE);

						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Email no válido","INICIO SESIÓN",JOptionPane.INFORMATION_MESSAGE);
					}
					
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
		btnAjustes = new JButton(img4);
		btnAjustes.setBackground(Color.WHITE);
		btnAjustes.setBounds(43, 5, 52, 47);
		panel.add(btnAjustes);
		
		btnAjustes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Configuracion frameConfiguracion = new Configuracion(controller);
				frameConfiguracion.setVisible(true);
				frameConfiguracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameConfiguracion.setResizable(false);
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
	
	 public static boolean ValidarMail(String email) 
	 {
	        // Patron para validar el email
	        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	 
	        Matcher mather = pattern.matcher(email);
	        return mather.find();
	}
	 
	public static void main(String args[])
	{
		InicioSesion_Registro bp = new InicioSesion_Registro(controller);
		bp.setVisible(true);
		bp.setResizable(false);
	}
}


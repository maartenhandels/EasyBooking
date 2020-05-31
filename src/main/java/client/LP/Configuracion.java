package client.LP;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import client.Controller.Controller;

import javax.swing.JButton;

/**
 * Clase para crear la pantalla de inicio de sesión. En ella el usuario tendrá la posibilidad de iniciar sesión o de crearse una 
 * cuenta en caso de no tenerla. 
 * @author Human Compilers
 *
 */
public class Configuracion extends JFrame{
	private JTextField textField_1;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	
	private JLabel lblCambio;
	private JLabel lblContAntigua;
	private JLabel lblContNueva;
	private JLabel lblEasyBooking;
	private JLabel labelEliminar;
	private JLabel lblImage;
	private JLabel lblConfig;

	private ImageIcon img;
	private ImageIcon img2;
	private ImageIcon img3;
	
	private JButton btnCambiar;
	private JButton btnEliminar;

	private static Controller controller;
	private JPasswordField txtFieldContAnt;
	private JPasswordField txtFieldContNueva;
	private JLabel lblEmail1;
	private JTextField textFieldEmail;
	private JTextField textFieldEmail2;
	private JPasswordField txtFieldContra;
	
	public Configuracion (Controller controller) {
		
		this.controller = controller;
		initComponents();
//		setVisible(true);
	}
	
	public void initComponents()
	{
		setTitle("Inicio de Sesión/Registro - EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 763, 493);
		setSize(763,492);
		setLocationRelativeTo(null);
		Image image = new ImageIcon("src/main/resources/images/Flight_prin.png").getImage();
		setIconImage(image);
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(750, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBounds(15, 318, 336, 410);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		lblCambio = new JLabel("CAMBIO CONTRASENYA");
		lblCambio.setForeground(new Color(255, 255, 255));
		lblCambio.setBounds(15, 16, 306, 31);
		lblCambio.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_3.add(lblCambio);
		
		lblContAntigua = new JLabel("Contrasenya antigua");
		lblContAntigua.setForeground(new Color(255, 255, 255));
		lblContAntigua.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblContAntigua.setBounds(15, 152, 238, 31);
		panel_3.add(lblContAntigua);
		
		lblContNueva = new JLabel("Contrasenya nueva");
		lblContNueva.setForeground(new Color(255, 255, 255));
		lblContNueva.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblContNueva.setBounds(15, 257, 226, 31);
		panel_3.add(lblContNueva);
		
		txtFieldContNueva = new JPasswordField();
		txtFieldContNueva.setColumns(10);
		txtFieldContNueva.setBounds(15, 290, 306, 40);
		panel_3.add(txtFieldContNueva);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnCambiar.setBounds(101, 354, 119, 40);
		panel_3.add(btnCambiar);
		
		txtFieldContAnt = new JPasswordField();
		txtFieldContAnt.setColumns(10);
		txtFieldContAnt.setBounds(15, 185, 306, 40);
		panel_3.add(txtFieldContAnt);
		
		lblEmail1 = new JLabel("Email");
		lblEmail1.setForeground(Color.WHITE);
		lblEmail1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblEmail1.setBounds(15, 60, 238, 31);
		panel_3.add(lblEmail1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(15, 93, 306, 40);
		panel_3.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		btnCambiar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldEmail.getText().isEmpty() || String.valueOf(txtFieldContNueva).isEmpty() || String.valueOf(txtFieldContAnt).isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Te faltan campos de información por rellenar","CONFIGURACION",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(textFieldEmail.getText()) == true )
					{
						String contra = String.valueOf(txtFieldContAnt.getPassword());
						
						//Enviar a servicio externo autenticación --> Si es incorrecto decirle que se registre/revise datos
						
						String email = textFieldEmail.getText();
						String new_password = String.valueOf(txtFieldContNueva.getPassword());
						String old_password = String.valueOf(txtFieldContAnt.getPassword());
						
						try {
							controller.change_password(email, old_password, new_password);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "Contrasenya cambiada correctamente");
						dispose();
						InicioSesion_Registro reg = new InicioSesion_Registro(controller);
						reg.setVisible(true);
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
		panel_1.setBounds(0, 0, 728, 60);
		getContentPane().add(panel_1);
		
		lblEasyBooking = new JLabel("EASYBOOKING");
		lblEasyBooking.setForeground(new Color(255, 255, 255));
		lblEasyBooking.setFont(new Font("Century Gothic", Font.BOLD, 40));
		panel_1.add(lblEasyBooking);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(377, 318, 336, 410);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		labelEliminar = new JLabel("ELIMINAR USUARIO");
		labelEliminar.setForeground(new Color(255, 255, 255));
		labelEliminar.setBounds(49, 13, 232, 32);
		labelEliminar.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_2.add(labelEliminar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnEliminar.setBounds(109, 354, 119, 40);
		panel_2.add(btnEliminar);
		
		JLabel lblEmail2 = new JLabel("Email");
		lblEmail2.setForeground(Color.WHITE);
		lblEmail2.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblEmail2.setBounds(18, 96, 238, 31);
		panel_2.add(lblEmail2);
		
		textFieldEmail2 = new JTextField();
		textFieldEmail2.setColumns(10);
		textFieldEmail2.setBounds(18, 129, 306, 40);
		panel_2.add(textFieldEmail2);
		
		JLabel lblContra = new JLabel("Contrasenya ");
		lblContra.setForeground(Color.WHITE);
		lblContra.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblContra.setBounds(18, 196, 238, 31);
		panel_2.add(lblContra);
		
		JPasswordField passwordField = new JPasswordField();
		//txtFieldContra.setColumns(10);
		passwordField.setBounds(18, 229, 306, 40);
		panel_2.add(passwordField);
		
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(textFieldEmail2.getText().isEmpty() || String.valueOf(passwordField).isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Te faltan campos de información por rellenar","CONFIGURACION",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if (ValidarMail(textFieldEmail2.getText()) == true )
					{
						dispose();
						String email = textFieldEmail2.getText();
						String password = String.valueOf(passwordField.getPassword());
						try {
							controller.eliminarUsuario(email, password);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
						InicioSesion_Registro reg = new InicioSesion_Registro(controller);
						reg.setVisible(true);
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
		panel_4.setBounds(0, 58, 728, 200);
		panel_4.setLayout(null);
		getContentPane().add(panel_4);
		
		img = new ImageIcon("src/main/resources/images/flight.png");
		lblImage = new JLabel(img);
		lblImage.setBounds(270, 0, 200, 200);
		panel_4.add(lblImage);
		
		panel_5 = new JPanel();
		panel_5.setForeground(new Color(255, 255, 255));
		panel_5.setBounds(0, 83, 255, 17);
		panel_4.add(panel_5);
		
		panel_6 = new JPanel();
		panel_6.setForeground(new Color(255, 255, 255));
		panel_6.setBounds(464, 83, 264, 17);
		panel_4.add(panel_6);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 258, 728, 60);
		getContentPane().add(panel);
		
		lblConfig = new JLabel("- Ajustes -");
		lblConfig.setFont(new Font("Century Gothic", Font.BOLD, 30));
		panel.add(lblConfig);
	}

	public static boolean ValidarMail(String email) {
		// Patron para validar el email
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);
		return mather.find();
	}
	
	public static void main(String args[])
	{
		Configuracion bp = new Configuracion(controller);
		bp.setVisible(true);
	}
}


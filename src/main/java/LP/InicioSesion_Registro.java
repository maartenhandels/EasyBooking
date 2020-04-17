package LP;

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

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Clase para crear la pantalla de inicio de sesión. En ella el usuario tendrá la posibilidad de iniciar sesión o de crearse una 
 * cuenta en caso de no tenerla. 
 * @author Human Compilers
 *
 */
public class InicioSesion_Registro extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
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

	private ImageIcon img;
	private ImageIcon img2;
	private ImageIcon img3;
	
	private JButton btnEntrar;
	private JButton btn1;
	private JButton btn2;
	private JButton button;

	
	public InicioSesion_Registro() {
		setTitle("Inicio de Sesión/Registro - EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 493);
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
					buscadorPrincipal frame = new buscadorPrincipal();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		img2 = new ImageIcon("src/main/resources/images/facebook.jpg");
		btn1 = new JButton(img2);
		btn1.setBounds(70, 100, 200, 88);
		panel_2.add(btn1);
		
		img3 = new ImageIcon("src/main/resources/images/google.jpg");
		btn2 = new JButton(img3);
		btn2.setBounds(70, 200, 200, 100);
		panel_2.add(btn2);
		
		label = new JLabel("REGISTRO");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(109, 16, 232, 32);
		label.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_2.add(label);
		
		button = new JButton("Registrar");
		button.setFont(new Font("Century Gothic", Font.BOLD, 18));
		button.setBounds(109, 354, 119, 40);
		panel_2.add(button);
		
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
		
		lblDisfrutaDeLa = new JLabel("¡Disfruta de la experiencia completa!");
		lblDisfrutaDeLa.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel.add(lblDisfrutaDeLa);
	
	}
}

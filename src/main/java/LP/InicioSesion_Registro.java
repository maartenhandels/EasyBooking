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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class InicioSesion_Registro extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField contraField;

	/**
	 * Initialize the contents of the frame.
	 */
	public InicioSesion_Registro() {
//		frame = new JFrame();
		getContentPane().setBackground(new Color(255, 255, 255));
		setSize(750, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBounds(15, 318, 336, 410);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblInicioDeSesion = new JLabel("INICIO DE SESION");
		lblInicioDeSesion.setForeground(new Color(255, 255, 255));
		lblInicioDeSesion.setBounds(49, 16, 232, 31);
		lblInicioDeSesion.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_3.add(lblInicioDeSesion);
		
		textField = new JTextField();
		textField.setBounds(15, 130, 306, 40);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblEmail.setBounds(15, 83, 88, 31);
		panel_3.add(lblEmail);
		
		JLabel label_1 = new JLabel("Contrasenya");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		label_1.setBounds(15, 207, 142, 31);
		panel_3.add(label_1);
		
		contraField = new JPasswordField();
		contraField.setColumns(10);
		contraField.setBounds(15, 254, 306, 40);
		panel_3.add(contraField);
		
		JButton btnEntrar = new JButton("Entrar");
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
					dispose();
					buscadorPrincipal frame = new buscadorPrincipal();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});

		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(0, 0, 728, 60);
		getContentPane().add(panel_1);
		
		JLabel lblEasyBooking = new JLabel("EASYBOOKING");
		lblEasyBooking.setForeground(new Color(255, 255, 255));
		lblEasyBooking.setFont(new Font("Century Gothic", Font.BOLD, 40));
		panel_1.add(lblEasyBooking);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(377, 318, 336, 410);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		ImageIcon img2 = new ImageIcon("src/main/resources/images/facebook.jpg");
		JButton btn1 = new JButton(img2);
		btn1.setBounds(70, 100, 200, 88);
		panel_2.add(btn1);
		
		ImageIcon img3 = new ImageIcon("src/main/resources/images/google.jpg");
		JButton btn2 = new JButton(img3);
		btn2.setBounds(70, 200, 200, 100);
		panel_2.add(btn2);
		
		JLabel label = new JLabel("REGISTRO");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(109, 16, 232, 32);
		label.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel_2.add(label);
		
		JButton button = new JButton("Registrar");
		button.setFont(new Font("Century Gothic", Font.BOLD, 18));
		button.setBounds(109, 354, 119, 40);
		panel_2.add(button);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(95, 158, 160));
		panel_4.setBounds(0, 58, 728, 200);
		panel_4.setLayout(null);
		getContentPane().add(panel_4);
		
		ImageIcon img = new ImageIcon("src/main/resources/images/flight.png");
		JLabel lblImage = new JLabel(img);
		lblImage.setBounds(270, 0, 200, 200);
		panel_4.add(lblImage);
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(new Color(255, 255, 255));
		panel_5.setBounds(0, 83, 255, 17);
		panel_4.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setForeground(new Color(255, 255, 255));
		panel_6.setBounds(464, 83, 264, 17);
		panel_4.add(panel_6);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 258, 728, 60);
		getContentPane().add(panel);
		
		JLabel lblDisfrutaDeLa = new JLabel("¡Disfruta de la experiencia completa!");
		lblDisfrutaDeLa.setFont(new Font("Century Gothic", Font.BOLD, 25));
		panel.add(lblDisfrutaDeLa);
	
	}
}

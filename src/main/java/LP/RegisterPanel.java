package LP;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterPanel extends JPanel {
	
	private JLabel header;
	private JLabel nameLbl;
	private JLabel lastNameLbl;
	private JLabel userNameLbl;
	private JLabel dniLbl;
	private JLabel emailLbl;
	private JLabel passwordLbl;
	
	private JTextField nameField;
	private JTextField lastNameField;
	private JTextField userNameField;
	private JTextField dniField;
	private JTextField emailField;
	
	private JPasswordField passwordField;
	
	private JButton registerButton;
	
	private ImageIcon img;
	
	
	
	public RegisterPanel(JFrame frameRecibido) {
		
		JFrame frame = frameRecibido;
		
		
		Dimension size = getPreferredSize();
		size.width = 500;
		setPreferredSize(size);
		
		//setBorder(BorderFactory.createTitledBorder("Registro EasyBooking"));
		
		
		header = new JLabel("Registro Nuevo Usuario");
		nameLbl = new JLabel("Nombre:");
		lastNameLbl = new JLabel("Apellido:");
		userNameLbl = new JLabel("Nombre Usuario:");
		emailLbl = new JLabel("Email:");
		dniLbl = new JLabel("Dni:");
		passwordLbl = new JLabel("Contrasena:");
		
		nameField = new JTextField(20);
		lastNameField = new JTextField(20);
		userNameField = new JTextField(20);
		dniField = new JTextField(20);
		emailField = new JTextField(20);
		
		passwordField = new JPasswordField(20);
		
		
		registerButton = new JButton("Register");
		
		img = new ImageIcon("src/images/flight.png");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// Imagen Avion
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.gridheight = 1;
		
		gc.insets = new Insets(3,3,3,3);
		
		JLabel lblImage = new JLabel(img);
		
		add(lblImage, gc);
				
				
		// Titulo
		header.setFont(new Font("Verdana", Font.PLAIN, 24));
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.gridheight = 2;
		
		gc.insets = new Insets(3,3,20,3);
		
		gc.fill = GridBagConstraints.VERTICAL;
		
		add(header, gc);
		
		// Separacion entre campos 
		gc.insets = new Insets(3,3,3,3);
		
		// Campo nombre
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(nameLbl, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(nameField, gc);
		
		
		// Campo apellido
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(lastNameLbl, gc);
		
		gc.gridx = 1;
		gc.gridy = 4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(lastNameField, gc);
		
		
		// Campo nombre de usuario
		gc.gridx = 0;
		gc.gridy = 5;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(userNameLbl, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(userNameField, gc);
		
		
		// Campo dni
		gc.gridx = 0;
		gc.gridy = 6;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(dniLbl, gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(dniField, gc);
		
		
		// Campo email
		gc.gridx = 0;
		gc.gridy = 7;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(emailLbl, gc);
		
		gc.gridx = 1;
		gc.gridy = 7;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(emailField, gc);
		
		
		// Campo contraseña
		gc.gridx = 0;
		gc.gridy = 8;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(passwordLbl, gc);
		
		gc.gridx = 1;
		gc.gridy = 8;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		
		add(passwordField, gc);
		
		
		// Boton registrar
		gc.gridx = 0;
		gc.gridy = 9;
		gc.gridwidth = 2;
		gc.gridheight = 1;
		
		gc.insets = new Insets(20,3,3,3);
		
		
		add(registerButton, gc);
		
		
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = nameField.getText();
				String email = emailField.getText();
				
				System.out.println("Nombre: " + name + " Email: " + email);
				
				
				//metodo para cerrar el Frame Principal
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
		
	}
	
}

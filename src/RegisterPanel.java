import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	
	private JTextField nameField;
	private JTextField emailField;
	
	private JPasswordField passwordField;
	
	private JButton registerButton;
	
	
	
	public RegisterPanel() {
		Dimension size = getPreferredSize();
		size.width = 500;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Registro EasyBooking"));
		
		
		nameLabel = new JLabel("Nombre: ");
		emailLabel = new JLabel("Email: ");
		passwordLabel = new JLabel("Contraseña: ");
		
		nameField = new JTextField(15);
		emailField = new JTextField(20);
		passwordField = new JPasswordField(15);
		
		
		registerButton = new JButton("Register");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		////First Column /////
		
		gc.anchor = GridBagConstraints.LINE_END;
		
		gc.insets = new Insets(90,0,0,0);
		gc.weightx = 0.5;
		gc.weighty = 0.3;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(emailLabel, gc);
		
		gc.insets = new Insets(0,0,0,0);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(nameLabel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(passwordLabel, gc); 
		
		
		////Second Column ////
		
		gc.anchor = GridBagConstraints.LINE_START;
		
		gc.insets = new Insets(90,0,0,0);
		gc.gridx = 1;
		gc.gridy = 0;
		add(emailField, gc);
		
		gc.insets = new Insets(0,0,0,0);
		gc.gridx = 1;
		gc.gridy = 1;
		add(nameField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		add(passwordField, gc);
		
		
		/// Final Row ///
		
		gc.insets = new Insets(50,45,0,0);
		gc.weighty = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		
		gc.gridx = 1;
		gc.gridy = 3;
		
		add(registerButton, gc);
		
		
		
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = nameField.getText();
				String email = emailField.getText();
				
				System.out.println("Nombre: " + name + " Email: " + email);
			}
		});
		
	}
	
}

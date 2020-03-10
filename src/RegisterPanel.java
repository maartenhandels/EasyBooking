import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel {
	
	public RegisterPanel() {
		Dimension size = getPreferredSize();
		size.width = 500;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Registro EasyBooking"));
		
		
		JLabel nameLabel = new JLabel("Nombre: ");
		JLabel emailLabel = new JLabel("Email: ");
		JLabel passwordLabel = new JLabel("Password: ");
		
		JTextField nameField = new JTextField(10);
		JTextField emailField = new JTextField(10);
		JTextField passwordField = new JTextField(10);
		
		JButton registerButton = new JButton("Register");
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
	}
	
	

}

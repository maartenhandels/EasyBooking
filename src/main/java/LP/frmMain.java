package LP;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class frmMain extends JFrame {
	
	private JButton loginBtn; // Boton que lleva a panel de iniciar sesion
	private JButton registerBtn; // Boton que lleva a panel de registro
	
	private RegisterPanel registerPanel; // Panel de registro
	
	private JPanel container; // Panel para cambiar entre paneles registro e inicio sesion
	private JPanel btnContainer; // Panel para mostrar y ocultar los botones
	private JPanel secondPanel; // panel de prueba --> A cambiar por el de inicio sesion
	
	CardLayout cl = new CardLayout(); // Layout que permite cambiar entre paneles
	CardLayout cl2 = new CardLayout(); // Layout que permite cambiar entre paneles
	
	public frmMain(String title) {
		
		super(title);
		
		// Set Layout manager
		setLayout(new BorderLayout());
		
		
		// Create Swing component
		container = new JPanel();
		container.setLayout(cl);
		
		btnContainer = new JPanel();
		btnContainer.setLayout(cl2);
		
		registerPanel = new RegisterPanel(this);
		
		secondPanel = new JPanel();
		secondPanel.setBackground(Color.RED);
		
		loginBtn = new JButton("Login");
		registerBtn = new JButton("Register");
		
		
		
		// Add Swing Components to content pane
		//Container c = getContentPane();
		
		
		container.add(registerPanel, "1");
		container.add(secondPanel, "2");
		
		btnContainer.add(loginBtn, "1");
		btnContainer.add(registerBtn, "2");
		
		
		cl.show(container, "1");
		cl2.show(btnContainer, "1");
		
		
		
		//Add Behavior
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cl.show(container, "2");
				cl2.show(btnContainer, "2");
				
			}
		});
		
		registerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "1");
				cl2.show(btnContainer, "1");
				
			}
		});
		
		
		// Adding the containers to frame
		add(container, BorderLayout.CENTER);
		add(btnContainer, BorderLayout.SOUTH);
	}

}

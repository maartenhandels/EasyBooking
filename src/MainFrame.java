import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	
	private RegisterPanel registerPanel;
	
	public MainFrame(String title) {
		super(title);
		
		// Set Layout manager
		setLayout(new BorderLayout());
		
		// Create Swing component
		registerPanel = new RegisterPanel();
		
		// Add Swing Components to content pane
		Container c = getContentPane();
		
		c.add(registerPanel, BorderLayout.CENTER);
		
		//Add Behavior
	}

}

package LP;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class clsMain {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				
				JFrame frame = new frmMain("Pagina de Inicio");
				frame.setSize(500, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
			
		});
		
	}

}

package LP;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class frmAutorizacion extends JFrame {
	
	JButton btnGoogle;
	JButton btnFacebook;
	ImageIcon icon1;
	ImageIcon icon2;
	
	public frmAutorizacion()
	{
		setLayout(null);
		setTitle("Autorizacion - EasyBookign");
		Image image = new ImageIcon("src/main/resources/images/Flight_prin.png").getImage();
		setIconImage(image);
		
		btnGoogle = new JButton();
		icon1 = new ImageIcon("src/main/resources/images/google.png");
		btnGoogle.setIcon(icon1);
		btnGoogle.setBounds(20, 50, 300, 300);
		add(btnGoogle);
		
		btnGoogle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame frame = new frmMain("Pagina de Inicio");
				frame.setSize(500, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);	
			}
		});
		
		btnFacebook = new JButton();
		icon1 = new ImageIcon("src/main/resources/images/facebook.png");
		btnFacebook.setIcon(icon1);
		btnFacebook.setBounds(400, 50, 300, 300);
		add(btnFacebook);
		
		btnFacebook.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				JFrame frame = new frmMain("Pagina de Inicio");
				frame.setSize(500, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	public static void main(String[] args) 
	{
		frmAutorizacion ventana = new frmAutorizacion();
		ventana.setBounds(600,200,760,500);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

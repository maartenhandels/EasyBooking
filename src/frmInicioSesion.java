import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class frmInicioSesion extends JFrame
{
	private static final long serialVersionUID = 1L;

	JTextField txtUser;
	
	JPasswordField txtPassword; 
	
	JLabel lblLogin,lblUser,lblPass, lblImage, lblImage2, lblImage3, lblRegister;

	JButton btnLogin, btnRegister, btnPassword;

	JPanel panel, panel2; 
	
	ImageIcon img, img2, img3;
	
	Color blue;

	public frmInicioSesion() 
	{
		setLayout(null);
		setTitle("Login");
		
		blue=new Color(76, 129, 194);
		
		lblLogin = new JLabel("Member login");
		lblLogin.setBounds(180, 10, 300, 50);
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 35));
		
		panel= new JPanel();
		panel.setBackground(Color.black);
		panel.setBounds(50, 170, 120, 10);
		
		panel2= new JPanel();
		panel2.setBackground(Color.black);
		panel2.setBounds(380, 170, 130, 10);
		
		img = new ImageIcon("src/images/flight.png");
		lblImage = new JLabel(img);
		lblImage.setBounds(160,70,250,200);
		
		img2 = new ImageIcon("src/images/username.png");
		lblImage2 = new JLabel(img2);
		lblImage2.setBounds(10,220,250,200);
		
		img3 = new ImageIcon("src/images/password.png");
		lblImage3 = new JLabel(img3);
		lblImage3.setBounds(10,310,250,200);
		
		lblUser = new JLabel("Username ");
		lblUser.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblUser.setBounds(180, 280, 200, 20);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtUser.setBounds(180, 310, 300, 40);

		lblPass = new JLabel("Password ");
		lblPass.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPass.setBounds(180, 370, 200, 20);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		txtPassword.setBounds(180, 400, 300, 40);
		
		lblRegister = new JLabel("Sign up");
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnLogin.setBounds(180, 470, 300, 40);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnRegister.setBounds(180, 520, 300, 40);
		
		add(lblLogin);
		add(panel);
		add(panel2);
		add(lblUser);
		add(txtUser);
		add(lblImage);
		add(lblImage2);
		add(lblImage3);
		add(lblPass);
		add(txtPassword);
		add(btnLogin);
		add(btnRegister);
		

	}

	public static void main(String args[])
	{
		frmInicioSesion ventana = new frmInicioSesion();
		ventana.setBounds(600,200,600,700);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

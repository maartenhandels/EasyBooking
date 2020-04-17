package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Checkbox;
import java.awt.Button;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase para realizar la reserva del vuelo e introducir datos necesarios de los pasajeros. Para poder finalizar
 * reserva será necesario realizar un pago
 * @author Human Compilers
 *
 */
public class Reserva extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private Panel panel_3;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_5_1_1;
	private JLabel lblNewLabel_5_1_1_1;
	private JLabel lblNewLabel_5_1_1_1_1;
	
	private JComboBox<String> comboBox;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	
	private Canvas canvas;
	private Canvas canvas_1_1;
	private Canvas canvas_1_1_1;
	
	private Checkbox checkbox;
	private Checkbox checkbox_1;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public Reserva() {
		setTitle("Realizar reserva - EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 493);
		Image image = new ImageIcon("src/main/resources/images/Flight_prin.png").getImage();
		setIconImage(image);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 139, 139), 4));
		panel.setBackground(Color.WHITE);
		panel.setBounds(58, 27, 632, 121);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("AMS");
		lblNewLabel.setBounds(375, 85, 69, 20);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BIO");
		lblNewLabel_1.setBounds(174, 85, 69, 20);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("11:50 - 13:55");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 50));
		lblNewLabel_2.setBounds(118, 19, 407, 56);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("2h 05 min");
		lblNewLabel_3.setBounds(540, 51, 92, 20);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon ("src/main/resources/images/Iberia.png"));
		lblNewLabel_4.setBounds(15, 19, 88, 71);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_1_1 = new JLabel("Mie. 9 Sep");
		lblNewLabel_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(250, 85, 92, 20);
		panel.add(lblNewLabel_1_1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 139, 139), 3));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(58, 164, 632, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_5 = new JLabel("TARIFAS");
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_5.setBounds(269, 8, 97, 20);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Núm. pasajeros:");
		lblNewLabel_6.setBounds(15, 44, 117, 20);
		panel_1.add(lblNewLabel_6);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(147, 41, 67, 26);
		comboBox.addItem("1 per.");
		comboBox.addItem("2 pers.");
		comboBox.addItem("3 pers.");
		comboBox.addItem("4 pers.");
		comboBox.addItem("5 pers.");
		panel_1.add(comboBox);
		
		rdbtnNewRadioButton = new JRadioButton("Turista");
		rdbtnNewRadioButton.setBounds(269, 40, 109, 29);
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Premium");
		rdbtnNewRadioButton_1.setBounds(445, 40, 155, 29);
		panel_1.add(rdbtnNewRadioButton_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		panel_2.setBounds(58, 248, 256, 173);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_5_1 = new JLabel("Precio");
		lblNewLabel_5_1.setBounds(15, 16, 73, 20);
		lblNewLabel_5_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		panel_2.add(lblNewLabel_5_1);
		
		lblNewLabel_5_1_1 = new JLabel("IVA");
		lblNewLabel_5_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_5_1_1.setBounds(15, 48, 73, 20);
		panel_2.add(lblNewLabel_5_1_1);
		
		lblNewLabel_5_1_1_1 = new JLabel("Precio");
		lblNewLabel_5_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel_5_1_1_1.setBounds(15, 137, 73, 20);
		panel_2.add(lblNewLabel_5_1_1_1);
		
		lblNewLabel_5_1_1_1_1 = new JLabel("Gast. Gestión");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_5_1_1_1_1.setBounds(15, 84, 124, 20);
		panel_2.add(lblNewLabel_5_1_1_1_1);
		
		canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(145, 10, 7, 157);
		panel_2.add(canvas);
		
		canvas_1_1 = new Canvas();
		canvas_1_1.setBackground(Color.GRAY);
		canvas_1_1.setBounds(158, 76, 81, 4);
		panel_2.add(canvas_1_1);
		
		canvas_1_1_1 = new Canvas();
		canvas_1_1_1.setBackground(Color.GRAY);
		canvas_1_1_1.setBounds(158, 114, 81, 4);
		panel_2.add(canvas_1_1_1);
		
		lblNewLabel_7 = new JLabel("259,45 €");
		lblNewLabel_7.setBounds(163, 16, 69, 20);
		panel_2.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("25,05 €");
		lblNewLabel_8.setBounds(163, 48, 69, 20);
		panel_2.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("0,00 €");
		lblNewLabel_9.setBounds(168, 84, 69, 20);
		panel_2.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("285,40 €");
		lblNewLabel_10.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_10.setBounds(158, 138, 98, 20);
		panel_2.add(lblNewLabel_10);
		
		panel_3 = new Panel();
		panel_3.setBackground(new Color(176, 224, 230));
		panel_3.setBounds(342, 250, 348, 171);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_11 = new JLabel("¿Cómo prefieres a pagar?");
		lblNewLabel_11.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_11.setBackground(Color.WHITE);
		lblNewLabel_11.setBounds(25, 16, 209, 20);
		panel_3.add(lblNewLabel_11);
		
		checkbox = new Checkbox("VISA");
		checkbox.setBounds(25, 42, 110, 50);
		panel_3.add(checkbox);
		
		checkbox_1 = new Checkbox("PayPal");
		checkbox_1.setBounds(178, 42, 144, 50);
		panel_3.add(checkbox_1);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(40, 119, 115, 29);
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				buscadorPrincipal frame = new buscadorPrincipal();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		btnNewButton= new JButton("Pagar ahora");
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(185, 108, 137, 40);
		panel_3.add(btnNewButton);
	}
}

package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class buscadorPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblEasybooking;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblBooking;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buscadorPrincipal frame = new buscadorPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public buscadorPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 661);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1024, 54);
		panel.setToolTipText("");
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 80, 54);
		lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/images/Flight_prin.png"));
		panel.add(lblNewLabel_1);
		
		lblEasybooking = new JLabel("EasyBooking");
		lblEasybooking.setBounds(336, 0, 293, 54);
		lblEasybooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblEasybooking.setFont(new Font("Century Gothic", Font.BOLD, 35));
		panel.add(lblEasybooking);
		
		lblBooking = new JLabel("usuario");
		lblBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooking.setBounds(816, 0, 122, 54);
		lblBooking.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		panel.add(lblBooking);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(943, 0, 48, 54);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/images/user_P.png"));
		panel.add(lblNewLabel);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel_1, lblEasybooking}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(5, 63, 270, 526);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Filtros de busqueda");
		label.setBounds(0, 16, 204, 27);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel_1.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/images/filter.png"));
		lblNewLabel_2.setBounds(219, 16, 38, 38);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(290, 64, 580, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setIcon(new ImageIcon("src/main/resources/images/lupa.png"));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(879, 63, 150, 27);
		contentPane.add(btnNewButton);
	}
}

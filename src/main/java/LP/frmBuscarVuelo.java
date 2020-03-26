package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JCheckBox;

public class frmBuscarVuelo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBuscarVuelo frame = new frmBuscarVuelo();
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
	public frmBuscarVuelo() {
		setTitle("EasyBooking - Buscar vuelo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 40, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(800, 10, 100, 20);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				dispose();
				frmInicioSesion frameInicio = new frmInicioSesion();
				frameInicio.setBounds(600,200,600,700);
				frameInicio.setVisible(true);
				frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JLabel lblAeropuertoOrigen = new JLabel("Aeropuerto origen:");
		lblAeropuertoOrigen.setFont(new Font("Serif", Font.BOLD, 20));
		lblAeropuertoOrigen.setBackground(Color.BLACK);
		lblAeropuertoOrigen.setBounds(67, 59, 185, 30);
		contentPane.add(lblAeropuertoOrigen);
		
		textField = new JTextField();
		textField.setBounds(56, 105, 209, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAeropuertoDestino = new JLabel("Aeropuerto destino:");
		lblAeropuertoDestino.setFont(new Font("Serif", Font.BOLD, 20));
		lblAeropuertoDestino.setBounds(398, 59, 185, 30);
		contentPane.add(lblAeropuertoDestino);
		
		textField_1 = new JTextField();
		textField_1.setBounds(381, 105, 209, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFecha = new JLabel("Cuando te vas?");
		lblFecha.setFont(new Font("Serif", Font.BOLD, 20));
		lblFecha.setBounds(704, 64, 174, 20);
		contentPane.add(lblFecha);
		
		JLabel label = new JLabel("13/03/2020");
		label.setBackground(new Color(0, 0, 0));
		label.setFont(new Font("Serif", Font.PLAIN, 19));
		label.setBounds(734, 114, 104, 20);
		contentPane.add(label);
		
		JLabel lblSeleccionarTarifa = new JLabel("Seleccionar tarifa:");
		lblSeleccionarTarifa.setFont(new Font("Serif", Font.BOLD, 20));
		lblSeleccionarTarifa.setForeground(Color.BLACK);
		lblSeleccionarTarifa.setBounds(67, 322, 185, 20);
		contentPane.add(lblSeleccionarTarifa);
		
		JRadioButton rdbtnTurista = new JRadioButton("Turista");
		rdbtnTurista.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnTurista.setBounds(298, 322, 98, 29);
		contentPane.add(rdbtnTurista);
		
		JRadioButton rdbtnPremium = new JRadioButton("Premium");
		rdbtnPremium.setFont(new Font("Serif", Font.PLAIN, 20));
		rdbtnPremium.setBounds(424, 322, 109, 29);
		contentPane.add(rdbtnPremium);
		
		JLabel lblNmeroDePasajeros = new JLabel("Numero de pasajeros:");
		lblNmeroDePasajeros.setFont(new Font("Serif", Font.BOLD, 20));
		lblNmeroDePasajeros.setBounds(67, 250, 209, 20);
		contentPane.add(lblNmeroDePasajeros);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Serif", Font.PLAIN, 20));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(298, 250, 124, 26);
		comboBox.addItem("1 adulto(s)");
		comboBox.addItem("2 adulto(s)");
		comboBox.addItem("3 adulto(s)");
		comboBox.addItem("4 adulto(s)");
		comboBox.addItem("5 adulto(s)");
		contentPane.add(comboBox);
		
		JButton lblCambio = new JButton();
//		lblCambio.setIcon(new ImageIcon (frmBuscarVuelo.class.getResource("images/cambio.png")));
		lblCambio.setBounds(297, 105, 58, 39);
		contentPane.add(lblCambio);
		
		JCheckBox chckbxSeleccionarAeropuertosCercanos = new JCheckBox("Seleccionar aeropuertos cercanos");
		chckbxSeleccionarAeropuertosCercanos.setFont(new Font("Serif", Font.PLAIN, 19));
		chckbxSeleccionarAeropuertosCercanos.setBounds(56, 156, 299, 29);
		contentPane.add(chckbxSeleccionarAeropuertosCercanos);
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(300, 431, 185, 60);
		contentPane.add(btnNewButton);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setFont(new Font("Serif", Font.BOLD, 24));
		btnReservar.setBounds(500, 431, 185, 60);
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frmFormReserva frmReserva = new frmFormReserva();
				frmReserva.setBounds(200, 40, 1000, 850);
				frmReserva.setVisible(true);
				frmReserva.setResizable(false);	
				frmReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		contentPane.add(btnReservar);
		
	}
}

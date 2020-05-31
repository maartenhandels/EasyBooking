package client.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import client.Controller.Controller;
import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Usuario;
import server.LD.Vuelo;

import java.awt.Canvas;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
	
	private JComboBox<Integer> comboBox;
	private String strFloat2;
	private String precio;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	
	private Canvas canvas;
	private Canvas canvas_1_1;
	private Canvas canvas_1_1_1;
	
	private Checkbox checkbox;
	private Checkbox checkbox_1;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private static Controller controller;
	private UsuarioDTO usuario;
	private VueloDTO vuelo;
	
	private int numero_pasajeros;
	private float precio_total;
	private float iva;
	private float precio_total_con_iva;
//	private final float precio_con_iva;
	
	private String precio_total_string;
	private String iva_string;
//	private final String precio_con_iva_string;

	public Reserva(Controller controller, UsuarioDTO usuario, VueloDTO vuelo) {
		
		this.controller = controller;
		this.usuario = usuario;
		this.vuelo=vuelo;
		initComponents(vuelo);
		setVisible(true);
	}
		
	
	public void initComponents(VueloDTO vuelo)
	{
		setTitle("Realizar reserva - EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 763, 493);
		setSize(763,493);
		setLocationRelativeTo(null);
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
		
		lblNewLabel = new JLabel(vuelo.getAeropuertoDestino().getNombre());
		lblNewLabel.setBounds(375, 85, 69, 20);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(vuelo.getAeropuertoSalida().getNombre());
		lblNewLabel_1.setBounds(174, 85, 69, 20);
		panel.add(lblNewLabel_1);
		
		long salidaHora = vuelo.getSalida();
        Date datesalidaHora = new Date(salidaHora*1000L);
        SimpleDateFormat jdfSalidahora = new SimpleDateFormat("HH:mm");
        String fecha_salHora = jdfSalidahora.format(datesalidaHora);
        
        long llegadaHora = vuelo.getLlegada();
        Date datellegadaHora = new Date(llegadaHora*1000L);
        SimpleDateFormat jdfllegadaHora = new SimpleDateFormat("HH:mm");
        String fecha_llegHora = jdfllegadaHora.format(datellegadaHora);
        
        long digminutes = (datellegadaHora.getTime()  - datesalidaHora.getTime()) % 60;
        
        System.out.println("la dif en minutos es" + digminutes);
        
        Date diff = new Date(datellegadaHora.getTime() - datesalidaHora.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(diff);
        cal.add(Calendar.HOUR, -1);
        Date onehourback = cal.getTime();
        SimpleDateFormat jdfDuracion = new SimpleDateFormat("HH:mm");
        String duracion = jdfDuracion.format(onehourback);
        
		lblNewLabel_2 = new JLabel("  " + fecha_salHora + "-" + fecha_llegHora);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD, 50));
		lblNewLabel_2.setBounds(118, 19, 407, 56);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel(duracion + "h");
		lblNewLabel_3.setBounds(540, 51, 92, 20);
		panel.add(lblNewLabel_3);
		
		if(vuelo.getAerolinea().getNombre().toUpperCase()=="IBERIA")
		{
			lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon ("src/main/resources/images/Iberia.png"));
			lblNewLabel_4.setBounds(15, 19, 88, 71);
			panel.add(lblNewLabel_4);
		}
		else if(vuelo.getAerolinea().getNombre().toUpperCase()=="LUFTHANSA")
		{
			JLabel lblLuf = new JLabel("");
			lblLuf.setIcon(new ImageIcon ("src/main/resources/images/lufthansa.jpg"));
			lblLuf.setBounds(15, 19, 88, 71);
			panel.add(lblLuf);
		}
		else if(vuelo.getAerolinea().getNombre().toUpperCase()=="VUELING")
		{
			JLabel vueling = new JLabel("");
			vueling.setIcon(new ImageIcon ("src/main/resources/images/vueling.jpg"));
			panel.add(vueling);
		}
		else if(vuelo.getAerolinea().getNombre().toUpperCase()=="KLM")
		{
			JLabel klm = new JLabel("");
			klm.setIcon(new ImageIcon ("src/main/resources/images/klm.png"));
			panel.add(klm);
		}
		else if(vuelo.getAerolinea().getNombre().toUpperCase()=="RYANAIR")
		{
			JLabel ryanair = new JLabel("");
			ryanair.setIcon(new ImageIcon ("src/main/resources/images/Ryanair.jpg"));
			panel.add(ryanair);
		}
		else 
		{
			JLabel lblOtros = new JLabel("");
			lblOtros.setIcon(new ImageIcon ("src/main/resources/images/vuelo.png"));
			lblOtros.setBounds(15, 19, 88, 71);
			panel.add(lblOtros);
		}
		
		
		long salidaFecha = vuelo.getSalida();
        Date datesalida = new Date(salidaFecha*1000L);
        SimpleDateFormat jdfSalida = new SimpleDateFormat("EEE, d MMM ");
        String fecha_sal = jdfSalida.format(datesalida);
        JLabel fechaSalida = new JLabel(fecha_sal);
        fechaSalida.setFont(new Font("Century Gothic", Font.BOLD, 16));
        fechaSalida.setBounds(250, 85, 92, 20);
        panel.add(fechaSalida);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 139, 139), 3));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(58, 164, 632, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
//		lblNewLabel_5 = new JLabel("TARIFAS");
//		lblNewLabel_5.setFont(new Font("Century Gothic", Font.BOLD, 16));
//		lblNewLabel_5.setBounds(269, 8, 97, 20);
//		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Núm. pasajeros:");
		lblNewLabel_6.setBounds(15, 44, 117, 20);
		panel_1.add(lblNewLabel_6);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(147, 41, 67, 26);
		comboBox.addItem(1);
		comboBox.addItem(2);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		panel_1.add(comboBox);
		
		
				
//		rdbtnNewRadioButton = new JRadioButton("Turista");
//		rdbtnNewRadioButton.setBounds(269, 40, 109, 29);
//		panel_1.add(rdbtnNewRadioButton);
//		
//		rdbtnNewRadioButton_1 = new JRadioButton("Premium");
//		rdbtnNewRadioButton_1.setBounds(445, 40, 155, 29);
//		panel_1.add(rdbtnNewRadioButton_1);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 128, 128), 2));
		panel_2.setBounds(58, 248, 300, 173);
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
		
		lblNewLabel_7 = new JLabel( Float.toString(vuelo.getPrecio()) +"€");
		lblNewLabel_7.setBounds(163, 16, 69, 20);
		panel_2.add(lblNewLabel_7);
		
		iva = (float) (vuelo.getPrecio() * 0.21);
		precio_total_con_iva = vuelo.getPrecio() + iva;
		
		String precio_con_iva_string = String.format("%.2f", precio_total_con_iva);
		String iva_inicial_string = String.format("%.2f", iva);
		
		lblNewLabel_8 = new JLabel(iva_inicial_string + "€");
		lblNewLabel_8.setBounds(163, 48, 69, 20);
		panel_2.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("0,00€");
		lblNewLabel_9.setBounds(163, 84, 69, 20);
		panel_2.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel(precio_con_iva_string +"€");
		lblNewLabel_10.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel_10.setBounds(163, 138, 98, 20);
		panel_2.add(lblNewLabel_10);
		
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				
				numero_pasajeros = (int) comboBox.getSelectedItem();
				
				System.out.println("El numero_pasajeros se ha puesto a: " + numero_pasajeros);
				
				precio_total = vuelo.getPrecio() * numero_pasajeros;
				iva = (float) (precio_total * 0.21);
				precio_total_con_iva = precio_total + iva;
				
				precio_total_string = String.format("%.2f", precio_total);
				iva_string = String.format("%.2f", iva);
				String precio_con_iva_string = String.format("%.2f", precio_total_con_iva);
				
				lblNewLabel_7.setText(precio_total_string + "€");
				lblNewLabel_8.setText(iva_string + "€");
				lblNewLabel_10.setText(precio_con_iva_string + "€");
				
			}
		});
				

		
		panel_3 = new Panel();
		panel_3.setBackground(new Color(176, 224, 230));
		panel_3.setBounds(342, 250, 348, 171);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNewButton_1.setBounds(40, 108, 120, 40);
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
//				buscadorPrincipal frame = new buscadorPrincipal(controller, usuario);
//				frame.setVisible(true);
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		btnNewButton= new JButton("Pagar ahora");
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(185, 108, 137, 40);
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				
				dispose();
				Pago frame = new Pago(controller, usuario, vuelo, precio_total_con_iva);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}


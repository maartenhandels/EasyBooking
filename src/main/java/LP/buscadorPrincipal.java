package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import LN.Aerolinea;
import LN.Aeropuerto;
import LN.Vuelo;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;
import javax.swing.JList;
/**
 * Clase que contiene el buscador de vuelos. Para poder buscar vuelos que se ajusten a tus necesidades hemos creado
 * un apartado con filtros que se pueden aplicar. 
 * @author Human Compilers
 *
 */
public class buscadorPrincipal extends JFrame{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	private JLabel lblEasybooking;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblBooking;
	private JLabel lblAeropuertoOrigen;
	private JLabel lblAeropuertoDestino;
	private JLabel lblNPasajeros;
	private JLabel lblRangoDePrecio;
	private JLabel label_2;
	private JLabel lblFechaSalida;
	private JLabel label_1;
	private JLabel label;
	private JLabel lblNewLabel_2;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JButton btnNewButton_1;
	private JButton button;
	private JButton btnNewButton_2;
	private JButton btnNewButton;
	private JButton btnRealizarReserva;
	private JButton btn2;
	
	private JSlider slider;
	private JSpinner spinner;
	private ImageIcon img3;
	private JList<Vuelo> listaVuelos;
	
	/**
	 * Create the frame.
	 */
	public buscadorPrincipal() {
		setTitle("Buscador de vuelos - EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image image = new ImageIcon("src/main/resources/images/Flight_prin.png").getImage();
		setIconImage(image);
		setBounds(80, 10, 1067, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(5, 5, 1030, 54);
		panel.setToolTipText("");
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 80, 54);
		lblNewLabel_1.setIcon(new ImageIcon("src/main/resources/images/Flight_prin.png"));
		panel.add(lblNewLabel_1);
		
		lblEasybooking = new JLabel("EasyBooking");
		lblEasybooking.setBounds(336, 0, 350, 54);
		lblEasybooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblEasybooking.setFont(new Font("Century Gothic", Font.BOLD, 35));
		panel.add(lblEasybooking);
		
		lblBooking = new JLabel("usuario");
		lblBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblBooking.setBounds(800, 0, 122, 54);
		lblBooking.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		panel.add(lblBooking);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(895, 0, 69, 54);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("src/main/resources/images/user_P.png"));
		panel.add(lblNewLabel);
		
		img3 = new ImageIcon("src/main/resources/images/salir.png");
		btn2 = new JButton(img3);
		btn2.setBounds(980, 8, 40, 40);
		panel.add(btn2);
		btn2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				InicioSesion_Registro frame = new InicioSesion_Registro();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(5, 63, 270, 564);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("Filtros de busqueda");
		label.setBounds(0, 16, 204, 27);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel_1.add(label);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/images/filter.png"));
		lblNewLabel_2.setBounds(219, 16, 38, 38);
		panel_1.add(lblNewLabel_2);
		
		lblAeropuertoOrigen = new JLabel("Aeropuerto Origen");
		lblAeropuertoOrigen.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblAeropuertoOrigen.setBounds(10, 66, 142, 20);
		panel_1.add(lblAeropuertoOrigen);
		
		textField_1 = new JTextField();
		textField_1.setBounds(15, 87, 183, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("src/main/resources/images/lupa.png"));
		btnNewButton_1.setBounds(204, 86, 51, 27);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Aquí tendremos que aplicar un filtro para que solamente salgan vuelos con ese origen
				if(textField_1.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"No has seleccionado el origen del vuelo","Origen vuelo",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"No hay vuelos corresponientes a ese origen en el sistema","Origen vuelo",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		lblAeropuertoDestino = new JLabel("Aeropuerto Destino");
		lblAeropuertoDestino.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblAeropuertoDestino.setBounds(10, 126, 194, 20);
		panel_1.add(lblAeropuertoDestino);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(15, 150, 183, 26);
		panel_1.add(textField_2);
		
		button = new JButton("");
		button.setIcon(new ImageIcon("src/main/resources/images/lupa.png"));
		button.setBounds(204, 149, 51, 27);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Aquí tendremos que aplicar un filtro para que solamente salgan vuelos con ese origen
				if(textField_2.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"No has seleccionado el destino del vuelo","Destino vuelo",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"No hay vuelos corresponientes a ese destino en el sistema","Destino vuelo",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		lblNPasajeros = new JLabel("Nº Pasajeros");
		lblNPasajeros.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNPasajeros.setBounds(10, 223, 104, 20);
		panel_1.add(lblNPasajeros);
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner.setBounds(204, 204, 47, 38);
		((DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
		panel_1.add(spinner);
		
		lblRangoDePrecio = new JLabel("Rango de precios (€)");
		lblRangoDePrecio.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblRangoDePrecio.setBounds(10, 277, 204, 20);
		panel_1.add(lblRangoDePrecio);
		
		slider = new JSlider();
		slider.setToolTipText("");
		slider.setMinimum(25);
		slider.setMaximum(500);
		slider.setBounds(37, 333, 200, 26);
		panel_1.add(slider);
		
		label_1 = new JLabel("25");
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_1.setBounds(37, 313, 25, 20);
		panel_1.add(label_1);
		
		label_2 = new JLabel("500");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_2.setBounds(217, 313, 38, 20);
		panel_1.add(label_2);
		
		lblFechaSalida = new JLabel("Fecha salida (dd/mm/aaaa)");
		lblFechaSalida.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblFechaSalida.setBounds(15, 387, 222, 20);
		panel_1.add(lblFechaSalida);
		
		textField_3 = new JTextField();
		textField_3.setBounds(58, 423, 146, 26);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton_2 = new JButton("Aplicar filtros");
		btnNewButton_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNewButton_2.setBounds(37, 505, 200, 29);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Aquí tendremos que comprobar patrón de fecha bien escrito
				//Para coger info de spinner --> int value = (Integer) spinner.getValue();
				//Para coger info de slider --> int value = slider.getValue();

					JOptionPane.showMessageDialog(null,"Filtros aplicados","Filtros",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		textField = new JTextField();
		textField.setBounds(290, 64, 580, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setIcon(new ImageIcon("src/main/resources/images/lupa.png"));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnNewButton.setBounds(879, 63, 156, 27);
		contentPane.add(btnNewButton);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(279, 588, 756, 39);
		contentPane.add(panel_2);
		
		//Aqui tendremos que añadir los diferentes paneles a la lista con el metodo createListVuelos
		//Para eso tenemos que implemetar bien la clase Vuelo
		panel_3 = new JPanel();
		panel_3.setBounds(290, 99, 745, 473);
		//panel_3.add(new JScrollPane(listaVuelos = createListVuelos()),BorderLayout.CENTER);
		contentPane.add(panel_3);
		
		btnRealizarReserva = new JButton("Realizar reserva");
		btnRealizarReserva.setFont(new Font("Century Gothic", Font.BOLD, 16));
		panel_2.add(btnRealizarReserva);
		btnRealizarReserva.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reserva frameReserva = new Reserva();
				frameReserva.setBounds(100, 100, 763, 493);
				frameReserva.setVisible(true);
				frameReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
	
	
	public static void createListVuelos(List<Vuelo>vuelos)
	{

		for( int i=0; i<vuelos.size(); i++)
		{
			PanelVuelos panelV=new PanelVuelos(vuelos.get(i)); 
			panelV.setVisible(true);
			panelV.setSize(745, 100);
			
		}

	}
}

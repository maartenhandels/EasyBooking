package client.LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JDateChooser;

import client.Controller.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date; 

import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import server.org.eclipse.wb.swing.FocusTraversalOnArray;
import server.DAO.DAO;
import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Aerolinea;
import server.LD.Aeropuerto;
import server.LD.Usuario;
import server.LD.Vuelo;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

import javax.print.attribute.standard.PrinterLocation;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
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
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
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

	private static final int PREF_W = 745;
    private static final int PREF_H = 250;
	
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panelContenedorVuelos;
	
	private JPanel panelClase;
	private JPanel rowHolderPanel = new JPanel(new GridLayout(0, 1, 1, 1));
	
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
	private JTextField textField_Origen;
	private JTextField textField_Destino;
	private JDateChooser datIda;
	
	private JButton btnNewButton_1;
	private JButton button;
	private JButton btnAplicarFiltros;
	private JButton btnBuscar;
	private JButton btnRealizarReserva;
	private JButton btnLogout;
	
	private JSlider slider;
	private JSpinner spinner;
	private ImageIcon img3;
	private JList<Vuelo> listaVuelos;
	private JScrollPane scrollPane;
	
	private static Controller controller;
	private UsuarioDTO usuario;
	
	/**
	 * Create the controller
	 */
	public buscadorPrincipal(Controller controller, UsuarioDTO usuario) {
		
		buscadorPrincipal.controller = controller;
		this.usuario = usuario;
		initComponents(usuario);
		setVisible(true);
	}
	
	/**
	 * Create the frame
	 */
	public void initComponents(UsuarioDTO usuario)
	{
		setTitle("Buscador de vuelos - EasyBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image image = new ImageIcon("src/main/resources/images/Flight_prin.png").getImage();
		setIconImage(image);
		setBounds(80, 10, 1067, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PRUEBA
		panelClase=new JPanel();
		JPanel outerPanel = new JPanel(new BorderLayout());
		outerPanel.add(rowHolderPanel, BorderLayout.PAGE_START);
		JScrollPane scrollpane = new JScrollPane(outerPanel);
		
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       
        panelClase.setLayout(new BorderLayout());
        panelClase.setBounds(290, 99, 745, 473);
        panelClase.add(scrollpane, BorderLayout.CENTER);
        contentPane.add(panelClase);
		
        //FIN PRUEBA
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
		
		lblBooking = new JLabel(usuario.getNombre());
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
		btnLogout = new JButton(img3);
		btnLogout.setBounds(980, 8, 40, 40);
		panel.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				InicioSesion_Registro frame = new InicioSesion_Registro(controller);
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
		label.setBounds(14, 16, 205, 27);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel_1.add(label);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src/main/resources/images/filter.png"));
		lblNewLabel_2.setBounds(219, 16, 38, 38);
		panel_1.add(lblNewLabel_2);
		
		lblAeropuertoOrigen = new JLabel("Aeropuerto Origen");
		lblAeropuertoOrigen.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblAeropuertoOrigen.setBounds(15, 56, 227, 20);
		panel_1.add(lblAeropuertoOrigen);
		
		textField_Origen = new JTextField();
		textField_Origen.setBounds(15, 87, 183, 26);
		panel_1.add(textField_Origen);
		textField_Origen.setColumns(10);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("src/main/resources/images/lupa.png"));
		btnNewButton_1.setBounds(204, 86, 51, 27);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Aquí tendremos que aplicar un filtro para que solamente salgan vuelos con ese origen
				if(textField_Origen.getText().isEmpty())
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
		lblAeropuertoDestino.setBounds(15, 117, 194, 20);
		panel_1.add(lblAeropuertoDestino);
		
		textField_Destino = new JTextField();
		textField_Destino.setColumns(10);
		textField_Destino.setBounds(15, 150, 183, 26);
		panel_1.add(textField_Destino);
		
		button = new JButton("");
		button.setIcon(new ImageIcon("src/main/resources/images/lupa.png"));
		button.setBounds(204, 149, 51, 27);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Aquí tendremos que aplicar un filtro para que solamente salgan vuelos con ese origen
				if(textField_Destino.getText().isEmpty())
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
		lblNPasajeros.setBounds(73, 214, 104, 20);
		panel_1.add(lblNPasajeros);
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinner.setBounds(204, 204, 47, 38);
		((DefaultEditor)spinner.getEditor()).getTextField().setEditable(false);
		panel_1.add(spinner);
		
		lblRangoDePrecio = new JLabel("Rango de precios (€)");
		lblRangoDePrecio.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblRangoDePrecio.setBounds(15, 279, 204, 20);
		panel_1.add(lblRangoDePrecio);
		
		slider = new JSlider(50, 1000, 1000);
		slider.setToolTipText("");
//		slider.setMinimum(50);
//		slider.setMaximum(1000);
		slider.setBounds(37, 337, 200, 26);
		panel_1.add(slider);
		
		label_1 = new JLabel("De: 50 ");
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_1.setBounds(37, 313, 100, 20);
		panel_1.add(label_1);
		
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				label_2.setText("A: " + String.valueOf(slider.getValue()));
				
			}
			
		});
		
		label_2 = new JLabel("A: 1000");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		label_2.setBounds(170, 313, 100, 20);
		panel_1.add(label_2);
		
		lblFechaSalida = new JLabel("Fecha salida (dd/mm/aaaa)");
		lblFechaSalida.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblFechaSalida.setBounds(15, 387, 242, 20);
		panel_1.add(lblFechaSalida);
		
		datIda = new JDateChooser();
		datIda.setBounds(58, 423, 146, 26);
		Date date= new Date();
		SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
		format.format(date);
		datIda.setDate(date);
		panel_1.add(datIda);
			
		btnAplicarFiltros = new JButton("Aplicar filtros");
		btnAplicarFiltros.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnAplicarFiltros.setBounds(37, 505, 200, 29);
		panel_1.add(btnAplicarFiltros);
		btnAplicarFiltros.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// Para coger info de spinner --> 
				// int num_pasajeros = (Integer) spinner.getValue();
				// Para coger info de slider
				// int precio = slider.getValue();
				// Date fecha = datIda.getDate();
				
				
				ArrayList<VueloDTO> vuelos = new ArrayList<VueloDTO>();
				
				boolean filtroOrigen = false; 
				boolean filtroDestino = false;
				boolean filtroAsientos = false;
				boolean filtroFecha = false;
				boolean filtroPrecio = false;
				
				int num_pasajeros = 0;
				double precio = 0;
				Date fecha = datIda.getDate();
				String fecha_string = "";
				
				if(textField_Origen.getText().isEmpty() == false) {
					filtroOrigen = true;
				}
				
				if(textField_Destino.getText().isEmpty() == false) {
					filtroDestino = true;
				}
				
				if((Integer) spinner.getValue() > 1) {
					filtroAsientos = true;
					num_pasajeros = (Integer) spinner.getValue();
				}
				
				Date today = Calendar.getInstance().getTime();
				if(datIda.getDate().after(today)) {
					
					System.out.println("Se ha puesto filtroFecha a true");
					
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");  // dd-M-yyyy hh:mm:ss" 2020/06/14 15:00:00
	                fecha_string = dateFormat.format(fecha); 
					
	                filtroFecha = true;
					
					
				}
				
				if(slider.getValue() < 1000) {
					filtroPrecio = true;
					precio = slider.getValue();
				}
				
				
				if(filtroOrigen && filtroDestino) 
				{
					if(filtroAsientos)
					{
						if(filtroPrecio)
						{
							if(filtroFecha) {
								// Llamada a filtros con origen, destino, asientos, precio y fecha
								try {
									System.out.println("Ha hecho la llamada con filtro de origen, destino, asientos, precio y fecha: ");
									vuelos = controller.search_flights_with_filter_4(textField_Origen.getText(), textField_Destino.getText(),
											num_pasajeros, precio, fecha_string);
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else {
								// Llamada a filtros con origen, destino y precio
								try {
									System.out.println("Ha hecho la llamada con filtro de origen, destino, asientos y precio: ");
									vuelos = controller.search_flights_with_filter_3(textField_Origen.getText(), textField_Destino.getText(),
											num_pasajeros, precio);
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}else {
							// Llamada a filtros con origen destino y asientos
							try {
								System.out.println("Ha hecho la llamada con filtro de origen, destino y asientos: ");
								vuelos = controller.search_flights_with_filter_2(textField_Origen.getText(), textField_Destino.getText(),
										num_pasajeros);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					}else {
						if(filtroOrigen) {
							try {
								vuelos = controller.search_flights_with_filter_0(textField_Origen.getText());
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else {
							// Llamada a filtros con origen y destino
							try {
								System.out.println("Ha hecho la llamada con filtro de origen y destino: ");
								vuelos = controller.search_flights_with_filter_1(textField_Origen.getText(), textField_Destino.getText());
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					}
					
				}else {
					
					// Llamada sin filtros
					try {
						System.out.println("Ha hecho la llamada sin filtro: ");
						vuelos = controller.getAllFlights();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				createListVuelos(vuelos, usuario);
				
				JOptionPane.showMessageDialog(null,"Filtros aplicados","Filtros",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon("src/main/resources/images/lupa.png"));
		btnBuscar.setFont(new Font("Century Gothic", Font.BOLD, 16));
		btnBuscar.setBounds(879, 63, 156, 27);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Me dispongo a hacer la llamada...");
				// ArrayList<VueloDTO> allFlights =  controller.getAllFlights();
				ArrayList<VueloDTO> allFlights = new ArrayList<VueloDTO>();
				try {
					allFlights = controller.getAllFlights();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("La llamada se ha realizado");
				System.out.println("El aeropuerto de salida del primer vuelo en LP es: "+ 
						allFlights.get(0).getAeropuertoDestino().getNombre());
				
				
//				List<VueloDTO> vuelos2 = new ArrayList<VueloDTO>();
//				
//				System.out.println("La Aerolinea del primer vuelo es: " + allFlights.get(0).getAerolinea());
//				
//				Aerolinea a1 = new Aerolinea("124", "IBERIA");
//				Aeropuerto p1 = new Aeropuerto("p1", "BIL");
//				Aeropuerto p2 = new Aeropuerto("p2", "AMS");
//				Aeropuerto p3 = new Aeropuerto("p3", "CDG");
//				VueloDTO vuelo1 = new VueloDTO( a1, p1, p2, 100,1372339860, 1372339375, 234.75);
//				
//				Aerolinea a2 = new Aerolinea("123", "LUFTHANSA");
//				Aerolinea a3 = new Aerolinea("134", "KLM");
//				Aerolinea a5 = new Aerolinea("123", "RYANAIR");
//				Aerolinea a6 = new Aerolinea("123", "AIR FRANCE");
//				Aerolinea a8 = new Aerolinea("123", "VUELING");
//				VueloDTO vuelo2 = new VueloDTO(a2, p2, p1, 100, 1372339860, 1372339375, 120.32);
//				VueloDTO vuelo3 = new VueloDTO(a3, p3, p2, 100, 1372339860, 1372339375, 47.38);
//				VueloDTO vuelo4 = new VueloDTO(a2, p1, p3, 100, 1372339860, 1372339375, 143.00);
//				VueloDTO vuelo5 = new VueloDTO(a6, p3, p2, 100,1372339860, 1372339375, 97.50);
//				VueloDTO vuelo6 = new VueloDTO(a5, p2, p1, 100,1372339860, 1372339375, 107.50);
//				VueloDTO vuelo7 = new VueloDTO(a1, p3, p2, 100,1372339860, 1372339375, 43.90);
//				VueloDTO vuelo8 = new VueloDTO(a8, p3, p1, 100,1372339860, 1372339375, 217.20);
//				
//				vuelos2.add(vuelo1);
//				vuelos2.add(vuelo2);
//				vuelos2.add(vuelo3);
//				vuelos2.add(vuelo4);
//				vuelos2.add(vuelo5);
//				vuelos2.add(vuelo6);
//				vuelos2.add(vuelo7);
//				vuelos2.add(vuelo8);
				
				createListVuelos(allFlights, usuario);
			}
		});
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(279, 588, 756, 39);
		contentPane.add(panel_2);
		
	}
	public void createListVuelos(ArrayList<VueloDTO>vuelos, UsuarioDTO usuario)
	{
		
		rowHolderPanel.removeAll();
		
		for( VueloDTO v:vuelos)
		{
			PanelVuelos panelV=new PanelVuelos(v, usuario, controller); 
			panelV.setVisible(true);

            rowHolderPanel.add(panelV);
            rowHolderPanel.revalidate();
            rowHolderPanel.repaint();
			
		}
	}
	
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }
    
    
	public static void main(String args[])
	{
//		Usuario us = new Usuario("lau", "llorente", "lau@gmail.com");
//		DAO dao = new DAO();
//		dao.guardarElemto(us);
		UsuarioDTO usuario_prueba = new UsuarioDTO("iboneurquiola@gmail.com", "Ibone", "Urquiola", "72557745R");
		buscadorPrincipal bp = new buscadorPrincipal(controller, usuario_prueba);
		bp.setVisible(true);
	}
	
	
}
;
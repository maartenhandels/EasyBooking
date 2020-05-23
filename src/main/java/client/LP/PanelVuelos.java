package client.LP;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import client.Controller.Controller;
import server.DTO.UsuarioDTO;
import server.DTO.VueloDTO;
import server.LD.Vuelo;

/**
 * Clase que contiene la creacion de los paneles correspondientes a cada vuelo para que puedan aparecer 
 * en la pagina principal en una lista
 * @author Human Compilers
 *
 */

public class PanelVuelos extends JPanel {
	
	private JPanel panel_north;
	private JPanel panelPrecio;
	private JPanel panel_medio;
	private JPanel panelBoton;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel klm;
	private JLabel ryanair;
	private JLabel lblNewLabel_flecha;
	private JLabel vueling;
	private JLabel aeroDest;
	
	private Controller controller;
	private UsuarioDTO usuario;
	/**
	 * Create the panel.
	 */
	public PanelVuelos(VueloDTO vuelo, UsuarioDTO usuario, Controller controller)
	{
		
		this.controller = controller;
		this.usuario = usuario;
		initComponents(vuelo, usuario);
		setVisible(true);
	}
	public void initComponents(VueloDTO vuelo, UsuarioDTO usuario)
	{
		setLayout(new BorderLayout());
		
		JPanel fotosPanel = new JPanel();
		
		if(vuelo.getAerolinea().getNombre().toUpperCase()=="IBERIA")
		{
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon ("src/main/resources/images/Iberia.png"));
			fotosPanel.add(lblNewLabel_2);
		}
		else if(vuelo.getAerolinea().getNombre().toUpperCase()=="LUFTHANSA")
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon ("src/main/resources/images/lufthansa.jpg"));
			fotosPanel.add(lblNewLabel_1);
		}
		else if(vuelo.getAerolinea().getNombre().toUpperCase()=="VUELING")
		{
			vueling = new JLabel("");
			vueling.setIcon(new ImageIcon ("src/main/resources/images/vueling.jpg"));
			fotosPanel.add(vueling);
		}
		else if(vuelo.getAerolinea().getNombre().toUpperCase()=="KLM")
		{
			klm = new JLabel("");
			klm.setIcon(new ImageIcon ("src/main/resources/images/klm.png"));
			fotosPanel.add(klm);
		}
		else if(vuelo.getAerolinea().getNombre().toUpperCase()=="RYANAIR")
		{
			ryanair = new JLabel("");
			ryanair.setIcon(new ImageIcon ("src/main/resources/images/Ryanair.jpg"));
			fotosPanel.add(ryanair);
		}
		else
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon ("src/main/resources/images/vuelo.png"));
			fotosPanel.add(lblNewLabel);
		}
		
		panel_north = new JPanel();
		JLabel aeroSalida = new JLabel(vuelo.getAeropuertoSalida().getNombre());
		aeroSalida.setFont(new Font("Century Gothic", Font.BOLD, 23));
		panel_north.add(aeroSalida);
		
		lblNewLabel_flecha = new JLabel("");
		lblNewLabel_flecha.setIcon(new ImageIcon ("src/main/resources/images/flecha.png"));
		panel_north.add(lblNewLabel_flecha);
		
		aeroDest = new JLabel(vuelo.getAeropuertoDestino().getNombre());
		aeroDest.setFont(new Font("Century Gothic", Font.BOLD, 23));
		panel_north.add(aeroDest);
		
		panelPrecio = new JPanel();
		JLabel precio = new JLabel(Double.toString(vuelo.getPrecio())+"€");
		precio.setFont(new Font("Century Gothic", Font.BOLD, 23));
		panelPrecio.add(precio);
        
        panel_medio = new JPanel();
        long salida = vuelo.getSalida();
        Date date = new Date(salida*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy HH:mm z");
        //jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String fecha_sal = jdf.format(date);
        JLabel fechaSalida = new JLabel("Salida: " + fecha_sal + " ---- ");
        panel_medio.add(fechaSalida);
        
        
        long llegada = vuelo.getLlegada();
        Date datellegada = new Date(llegada*1000L);
        SimpleDateFormat jdfLlegada = new SimpleDateFormat("dd-MM-yyyy HH:mm z");
        //jdfLlegada.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        String fecha_lleg = jdfLlegada.format(datellegada);
        JLabel fechallegada = new JLabel("Llegada: " + fecha_lleg);
        panel_medio.add(fechallegada);
        
        
        add(panel_north, BorderLayout.NORTH);
        add(fotosPanel, BorderLayout.WEST);
        add(panel_medio, BorderLayout.CENTER);
        add(panelPrecio, BorderLayout.EAST);

        panelBoton = new JPanel();
        JButton btn_res = new JButton("Reservar");
        btn_res.setLayout(new GridLayout(0,1,1,1));
        panelBoton.add(btn_res);
        add(panelBoton, BorderLayout.SOUTH);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btn_res.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Reserva frameReserva = new Reserva(controller, usuario, vuelo);
				frameReserva.setBounds(100, 100, 763, 493);
				frameReserva.setVisible(true);
				frameReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	
			}
		});

        }
}

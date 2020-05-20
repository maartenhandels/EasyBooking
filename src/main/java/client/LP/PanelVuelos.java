package client.LP;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import client.Controller.Controller;
import server.LD.Vuelo;

/**
 * Clase que contiene la creacion de los paneles correspondientes a cada vuelo para que puedan aparecer 
 * en la pagina principal en una lista
 * @author Human Compilers
 *
 */

public class PanelVuelos extends JPanel {
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	
	private Controller controller;
	/**
	 * Create the panel.
	 */
	public PanelVuelos(Vuelo vuelo, Controller controller) {
		
		//Vuelo vuelos = new Vuelo(vuelo.getCodVuelo(), vuelo.getAerolinea(), vuelo.getAeropuertoSalida(), vuelo.getAeropuertoDestino(), 
		//vuelo.getAsientosTotales(), vuelo.getAsientosLibres(), vuelo.getSalida(), vuelo.getLlegada());
		this.controller = controller;
		initComponents(vuelo);
		setVisible(true);

	}
	public void initComponents(Vuelo vuelo)
	{
		//setBounds(80, 10, 745, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblNewLabel = new JLabel(vuelo.getAeropuertoSalida().getNombre());
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel.setBounds(150, 46, 211, 20);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(vuelo.getAeropuertoDestino().getNombre());
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel_1.setBounds(324, 46, 224, 20);
		add(lblNewLabel_1);
		
		//Creo que deberiamos añadir a la compañia un icono en su constructor
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon ("src/main/resources/images/Iberia.png"));
		lblNewLabel_2.setBounds(15, 16, 182, 151);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("fecha/hora salida"); //hay que hacer algo con los long
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_3.setBounds(150, 117, 163, 20);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("fecha/hora llegada");
		lblNewLabel_4.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		lblNewLabel_4.setBounds(324, 117, 155, 20);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("duración h"); //Calculo restando horas
		lblNewLabel_5.setFont(new Font("MS PGothic", Font.BOLD, 18));
		lblNewLabel_5.setBounds(500, 82, 98, 20);
		add(lblNewLabel_5);
		
	}

}

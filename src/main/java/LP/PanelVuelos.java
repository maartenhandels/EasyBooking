package LP;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;

import LN.Vuelo;

/**
 * Clase que contiene la creacion de los paneles correspondientes a cada vuelo para que puedan aparecer 
 * en la pagina principal en una lista
 * @author Human Compilers
 *
 */

public class PanelVuelos extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelVuelos(Vuelo vuelo) {
		setBorder(new LineBorder(new Color(95, 158, 160)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(vuelo.getAeropuertoSalida().getNombre());
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel.setBounds(236, 46, 211, 20);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(vuelo.getAeropuertoDestino().getNombre());
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblNewLabel_1.setBounds(524, 46, 224, 20);
		add(lblNewLabel_1);
		
		
		//Creo que deberiamos añadir a la compañia un icono en su constructor
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon ("src/main/resources/images/Iberia.png"));
		lblNewLabel_2.setBounds(15, 16, 182, 151);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("fecha/hora salida"); //hay que hacer algo con los long
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_3.setBounds(236, 117, 163, 20);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("fecha/hora llegada");
		lblNewLabel_4.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
		lblNewLabel_4.setBounds(524, 117, 155, 20);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("duración h"); //Calculo restando horas
		lblNewLabel_5.setFont(new Font("MS PGothic", Font.BOLD, 18));
		lblNewLabel_5.setBounds(734, 82, 98, 20);
		add(lblNewLabel_5);
		

	}

}

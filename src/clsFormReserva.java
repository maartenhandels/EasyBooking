import javax.swing.*;

/**
 * 
 * @author Alumno
 * Formulario necesario a rellenar para poder realizar una reserva
 */

public class clsFormReserva extends JFrame 
{

	public clsFormReserva()
	{
		setLayout(null);
		
		setTitle("Datos reserva");
	}
	
	
	public static void main(String[] args) 
	{
		clsFormReserva ventanaFormReserva = new clsFormReserva();
		
		ventanaFormReserva.setBounds(200, 70, 1000, 700);
		ventanaFormReserva.setVisible(true);
		ventanaFormReserva.setResizable(false);	

	}

}

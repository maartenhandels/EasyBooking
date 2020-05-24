package server.DTO;

import java.util.ArrayList;
import java.util.List;

import server.LD.Usuario;
import server.LD.Vuelo;

public class VueloAssembler 
{
	
	public ArrayList <VueloDTO> assembleTovueloDTO(ArrayList<Vuelo> vuelos)
	{
		ArrayList<VueloDTO> vueloDTO = new ArrayList<>();
		for (Vuelo u : vuelos)
		{
			VueloDTO vuDTO= new VueloDTO(u.getAerolinea(), u.getAeropuertoSalida(), 
					u.getAeropuertoDestino(), u.getAsientosLibres(), u.getSalida(), u.getLlegada(), u.getPrecio());
			
			vueloDTO.add(vuDTO);
		}
		System.out.println("* Assembling vuelos to vuelosDTO ...");
		
		return vueloDTO;
		
	}
	
	public ArrayList <Vuelo> assembletoVuelo(ArrayList<VueloDTO> vueloDTO)
	{
		ArrayList<Vuelo> vuelos = new ArrayList<>();
		for (VueloDTO u : vueloDTO)
		{
			Vuelo vu = new Vuelo();
			
			vu.setAerolinea(u.getAerolinea());
			vu.setAeropuertoSalida(u.getAeropuertoSalida());
			vu.setAeropuertoSalida(u.getAeropuertoSalida());
			vu.setAsientosLibres(u.getAsientosLibres());
			vu.setSalida(u.getSalida());
			vu.setLlegada(u.getLlegada());
			vu.setPrecio(u.getPrecio());
			
			vuelos.add(vu);
			
		}
		System.out.println("* Assembling usuariosDTO to usuarios ...");
		
		return vuelos;
		
	}

}

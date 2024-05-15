package fp.nobel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class FactoriaNobel {
	private Implementacion implementacion = Implementacion.STREAM;
	
	public Premio parsearPremio(String linea) {
		String[] lineas = linea.split(",");
		Checkers.check("El fichero está mal troceado.", lineas.length == 6);
		
		Integer año = Integer.parseInt(lineas[0].strip());
		String categoria = lineas[1].strip();
		String nombre = lineas[2].strip();
		String apellidos = lineas[3].strip();
		Genero genero = Genero.valueOf(lineas[4].strip());
		Integer añoNacimiento = Integer.parseInt(lineas[5].strip());
		Integer edadPremiado = año - añoNacimiento;
		return new Premio(año, categoria, nombre, apellidos, genero, añoNacimiento, edadPremiado);
	}
	
	public Premios leerPremios(String rutaFichero) {
		PremiosStream premiosStream = new PremiosStream();
		PremiosBucles premiosBucles = new PremiosBucles();
		
		try {
			List<String> lineas = Files.readAllLines(Paths.get(rutaFichero));
			lineas.remove(0);
			
			for (String linea: lineas) {
				if(this.implementacion == Implementacion.STREAM) {
					premiosStream.añadirPremio(parsearPremio(linea));
				} else {
					premiosBucles.añadirPremio(parsearPremio(linea));
				}
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(this.implementacion == Implementacion.STREAM) {
	        return premiosStream;
	    } else {
	        return premiosBucles;
	    }
	}
	
	public void setImplementacion(Implementacion nuevaImp) {
		this.implementacion = nuevaImp;
	}
}

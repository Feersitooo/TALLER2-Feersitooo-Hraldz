package Taller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Registro {
	
	// editar registro  y agregar el nombre.
	
	public void editarNombre(String nombre, String ruta) {
		
		try ( BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))){
			escritor.write(nombre + ";" );
			escritor.newLine();
		}catch (IOException e) {
			
		}
	}
	// Mostrar Nombre
	public String mostrarNombre(String ruta) {
		
		try(BufferedReader lector = new BufferedReader(new FileReader(ruta))){
			String linea = lector.readLine();
			if (linea != null) {
				String[] partes = linea.split(";");
				return partes[0];
			}else {
				return null;
			}		
		}catch(IOException e) {
			return null;
		}	
	}
	
	
	
	// añadirpokemon
	
	
	// editarEstadoDePokemon
	
	
	
	
	
	
	
	
	
	

}

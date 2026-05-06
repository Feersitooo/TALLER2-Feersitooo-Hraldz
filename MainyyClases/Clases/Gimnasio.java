package Taller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gimnasio {
	
	
	
	public static void mostrarGimnasios(String ruta) {
		//mostrar los gimnasios
		try (BufferedReader lector = new BufferedReader(new FileReader(ruta))){
			String linea;
			
			while((linea = lector.readLine()) != null) {
				
			}
			

		}catch(IOException e) {
			
		}
	}

	
	// editar estado del gimnasio
	
	
	
	
	
	
	
	
}

package Taller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Registro {
	
	// editar registro  y agregar el nombre.
	
	public void editarNombre(String nombre) {
		
		try ( BufferedWriter escritor = new BufferedWriter(new FileWriter("src/Registros.txt",true))){
			escritor.write(nombre + ";" );
			escritor.newLine();
		}catch (IOException e) {
			
		}
	}
	
	//limpiar el .txt en caso de nueva partida para reducir errores
	public void limpiarArchivo() {
		try ( BufferedWriter escritor = new BufferedWriter(new FileWriter("src/Registros.txt"))){
			
		}catch (IOException e) {
			
		}
	}
	
	//cargar el archivo
	
	public void cargarArchivo(PokedexAdmin admin) {
		try (BufferedReader lector = new BufferedReader(new FileReader("src/Registros.txt"))){
			lector.readLine();
			String linea;
			while ((linea = lector.readLine()) != null) {
				String[] partes = linea.split(";");
				// aqui salen los nombres de los pokemon, en partes[0]
				for(Pokemon pokemon : admin.getPokemons()) {
					if (partes[0].equals(pokemon.getNombre())) {
						admin.agregarInventario(pokemon);		
					}
				}
			}
					
		}catch(IOException e) {
			
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
	
	public void agregarPokemonTxt(String nombrePokemon) {
		try ( BufferedWriter escritor = new BufferedWriter(new FileWriter("src/Registros.txt", true))){
			escritor.write(nombrePokemon + ";Vivo" );
			escritor.newLine();
			
		}catch (IOException e) {
			
		}
		
		
		
	}
	
	
	
	// añadirpokemon
	
	
	// editarEstadoDePokemon
	
	
	
	
	
	
	
	
	
	

}

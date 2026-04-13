package Taller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Habitads {
	private String nombre;
	private ArrayList<String> habitads = new ArrayList<>();
	public ArrayList<Pokemon> pokemons = new ArrayList<>();
	public ArrayList<Pokemon> pFiltrados = new ArrayList<>();
	
	public Habitads(String rutaHabitads) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaHabitads));
				String linea;
				while((linea = lector.readLine()) != null) {
					this.habitads.add(linea);
				}	
		}catch(IOException e) {
			
		}
	}

	public Pokemon filtrarPorHabitad(String habitad) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("src/Pokedex.txt"));
			String linea;
			while ( (linea = lector.readLine()) != null) {
				
				String[] partes = linea.split(";");
				pokemons.add(new Pokemon(partes[0], partes[1]));			
			}			
		}catch(IOException e) {
			
		}	
		
		for (Pokemon a : pokemons) {
			
			if (a.getHabitad().equalsIgnoreCase(habitad)) {
				pFiltrados.add(a);
			}
		}	
		Random random = new Random();	
		return pFiltrados.get(random.nextInt(pFiltrados.size()));
			
		
		
	}
	
	
	
	
	
	
	
	
	public ArrayList<String> getHabitads() {
		return habitads;
	}
	
}

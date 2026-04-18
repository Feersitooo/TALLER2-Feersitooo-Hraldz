package Taller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PokedexAdmin {

	private ArrayList<String> habitads = new ArrayList<>();
	public ArrayList<Pokemon> pokemons = new ArrayList<>();
	public ArrayList<Pokemon> pFiltrados = new ArrayList<>();
	private ArrayList<Pokemon> pokemonsUsuario = new ArrayList<>();
	
	
	public PokedexAdmin(String rutaHabitads) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaHabitads));
				String linea;
				while((linea = lector.readLine()) != null) {
					this.habitads.add(linea);
				}	
		}catch(IOException e) {
			
		}
	}

	public void crearListaPokemons() {
		try {
			BufferedReader lector = new BufferedReader(new FileReader("src/Pokedex.txt"));
			String linea;
			while ( (linea = lector.readLine()) != null) {
				
				String[] partes = linea.split(";");
				String nombre = partes[0];
				String habitadP = partes[1];
				double porcAparicion = Double.parseDouble(partes[2]);
				int vida = Integer.parseInt(partes[3]);	
				int ataque = Integer.parseInt(partes[4]);		
				int defensa = Integer.parseInt(partes[5]);		
				int ataque2 = Integer.parseInt(partes[6]);	
				int defensa2 = Integer.parseInt(partes[7]);		
				int velocidad = Integer.parseInt(partes[8]);		
				String tipo = partes[9];
				
				pokemons.add(new Pokemon(nombre,habitadP,porcAparicion,vida,ataque,defensa,ataque2,defensa2,velocidad,tipo));			
			}			
		}catch(IOException e) {
			
		}			
		
	}
	
	public Pokemon randomPokemon(String habitad) {
		for (Pokemon a : pokemons) {		
			if (a.getHabitad().equalsIgnoreCase(habitad)) {
				pFiltrados.add(a);
			}
		}	
		Random random = new Random();	
		return pFiltrados.get(random.nextInt(pFiltrados.size()));
	}

	
	// agregar pokemons al inventario+
	public void agregarInventario(Pokemon a) {
		pokemonsUsuario.add(a);
		
	}
	
	public void mostrarInventario() {
		int i = 1;
		for (Pokemon a : pokemonsUsuario ) {
			int sumaStats = a.getAtaque() + a.getAtaqueEspecial() + a.getDefensa() + a.getDefensaEspecial() + a.getVelocidad() + a.getVida();
			System.out.println(i + ") " +a.getNombre() +"|"+ a.getTipo() +"|Stats totales: " + sumaStats);
			i++;
		}
	}


	
	public ArrayList<Pokemon> getPokemonsUsuario() {
		return pokemonsUsuario;
	}	
	public ArrayList<String> getHabitads() {
		return habitads;
	}
	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}
}

package Taller;

import java.util.ArrayList;

public class Pokemon {
	
	private String nombre;
	private String habitad;
	private ArrayList<Pokemon> pokemonsUsuario = new ArrayList<>();
	
	public Pokemon() {
		
	}
	
	public Pokemon(String nombre, String habitad) {
		super();
		this.nombre = nombre;
		this.habitad = habitad;
	}
	
	// agregar pokemon encontrado a una lista de los pokemons
	
	
	public void agregarPokemon(Pokemon a) {
		pokemonsUsuario.add(a);
		System.out.println(a.getNombre() + "ha sido agregado a tu equipo!");
	}
	


	public String getNombre() {
		return nombre;
	}

	public String getHabitad() {
		return habitad;
	}
	
	
	
	

}

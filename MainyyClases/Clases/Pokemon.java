package Taller;

import java.util.ArrayList;

public class Pokemon {
	
	private String nombre;
	private String habitad;
	private double porcAparicion;
	private int vida;
	private int ataque;
	private int defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private String tipo;
	
	private ArrayList<Pokemon> pokemonsUsuario = new ArrayList<>();


	public Pokemon() {
			
	}
	
	public Pokemon(String nombre, String habitad) {
		super();
		this.nombre = nombre;
		this.habitad = habitad;
	}
	
	// agregar pokemon encontrado a una lista de los pokemons
	public ArrayList<Pokemon> getPokemonsUsuario() {
		return pokemonsUsuario;
	}

	public void agregarPokemon(Pokemon a) {
		pokemonsUsuario.add(a);
		System.out.println(a.getNombre() + " ha sido agregado a tu equipo!");
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public String getHabitad() {
		return habitad;
	}
	
	public double getPorcAparicion() {
		return porcAparicion;
	}

	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public int getDefensaEspecial() {
		return defensaEspecial;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public String getTipo() {
		return tipo;
	}

	
	
	

}

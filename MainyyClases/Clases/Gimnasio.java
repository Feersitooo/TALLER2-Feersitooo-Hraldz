package Taller;

import java.util.ArrayList;


public class Gimnasio {
	
	private int id;
	private String lider;
	private String estado;
	private int cantPokemon;
	private ArrayList <Pokemon> pokemonsGym = new ArrayList<>();
	

	public Gimnasio(int id, String lider, String estado, int cantPokemon, ArrayList<Pokemon> pokemonsGym) {
		super();
		this.id = id;
		this.lider = lider;
		this.estado = estado;
		this.cantPokemon = cantPokemon;
		this.pokemonsGym = pokemonsGym;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ArrayList<Pokemon> getPokemonsGym() {
		return pokemonsGym;
	}

	public void setPokemonsGym(ArrayList<Pokemon> pokemonsGym) {
		this.pokemonsGym = pokemonsGym;
	}

	public String getLider() {
		return lider;
	}

	public void setLider(String lider) {
		this.lider = lider;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Gimnasio [id=" + id + ", lider=" + lider + ", estado=" + estado + ", cantPokemon=" + cantPokemon
				+ ", pokemonsGym=" + pokemonsGym + "]";
	}


	

	
	
	
	
	
	
	
	
	
	
}

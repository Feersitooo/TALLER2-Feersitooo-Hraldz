package Taller;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class app {
	public static ArrayList <String> registros = new ArrayList<>();
	public static ArrayList<Pokemon> pokemons = new ArrayList<>();
	public static ArrayList<String> habitads = new ArrayList<>();
	public static ArrayList<Pokemon> pFiltrados = new ArrayList<>();
	public static ArrayList<Pokemon> pokemonsUsuario = new ArrayList<>();
	
	
	public static void cargarArchivoVacio() {
		
		try (Scanner lector1 = new Scanner(new File("src/Registros.txt"))){
			while(lector1.hasNextLine()) {
				String linea = lector1.nextLine();
				registros.add(linea);	
			}
		}catch(IOException e) {
			
		}
		
	}
	
	public static void cargarPokemonsUsuario() {
		try (Scanner lector2 = new Scanner(new File("src/Registros.txt"))){
			while(lector2.hasNextLine()) {
				String linea = lector2.nextLine();
				String[] partes = linea.split(";");
				for(Pokemon b : pokemons) {
					if(partes[0].equalsIgnoreCase(b.getNombre())) {
						pokemonsUsuario.add(b);
					}
				}
			}
		}catch(IOException e) {
			
		}
	}
	
	public static void limpiarArchivo(String ruta) {
		try ( BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))){
			escritor.close();
		}catch (IOException e) {
			
		}
	}
	
	public static void crearListaPokemons() {

		try (Scanner lector = new Scanner(new File("src/Pokedex.txt"))){
			
			
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
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
	
	public static void crearHabitads(String rutaHabitads) {
		
		try (Scanner lector = new Scanner(new File(rutaHabitads))){
			
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
					habitads.add(linea);
				}	
		}catch(IOException e) {
			
		}
	}
	
	public static Pokemon randomPokemon(String habitad) {
		for (Pokemon a : pokemons) {		
			if (a.getHabitad().equalsIgnoreCase(habitad)) {
				pFiltrados.add(a);
			}
		}	
		Random random = new Random();	
		return pFiltrados.get(random.nextInt(pFiltrados.size()));
	}

	public static void agregarInventario(Pokemon a) {
		pokemonsUsuario.add(a);
		
	}
	
	public static void mostrarInventario() {
		int i = 1;
		for (Pokemon a : pokemonsUsuario ) {
			int sumaStats = a.getAtaque() + a.getAtaqueEspecial() + a.getDefensa() + a.getDefensaEspecial() + a.getVelocidad() + a.getVida();
			System.out.println(i + ") " +a.getNombre() +"|"+ a.getTipo() +"|Stats totales: " + sumaStats);
			i++;
		}
	}
	
	public static void guardarRegistros(String ruta) {
		
		try ( BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))){
			
			for (int i = 0; i < registros.size(); i++) {
				if (registros.get(i).contains(";")) {
					escritor.write(registros.get(i));
					escritor.newLine();
				}else {
					escritor.write(registros.get(i) + ";");
					escritor.newLine();
				}
					
					
				
					
			}
			escritor.close();
		}catch (IOException e) {
			
		}	
	}
	
	
	public static void curarPokemons() {
		for (int i = 0; i < registros.size(); i++) {
			String linea = registros.get(i);
			if(linea.contains("Debilitado")) {
				String[] partes = linea.split(";");
				linea = partes[0] + ";" + "Vivo";
				registros.set(i, linea);
			}
		}	
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	
		String rutaRegistro = "src/Registros.txt";
		String rutaHabitads = "src/Habitats.txt";
		
		crearListaPokemons();
		cargarArchivoVacio();
		crearHabitads(rutaHabitads);
		cargarPokemonsUsuario();
		
		int opcion1 = 0;
		do{	
		System.out.println("1) Continuar.");
		System.out.println("2) Nueva Partida.");
		System.out.println("3) Salir.");
		opcion1 = sc.nextInt();
		
		
		switch (opcion1) {
		
		case 2:
			registros.clear();
			limpiarArchivo(rutaRegistro);
			sc.nextLine();
			System.out.print("Ingrese su apodo de jugador :");
			String apodoNuevo = sc.nextLine();
			System.out.println("Bienvenido " + apodoNuevo);
			System.out.println(" ");
			registros.add(apodoNuevo);
			
			
		case 1 :
			int opcion2 = 0;
			if (registros.isEmpty()) {
				System.out.println("Debes crear una nueva partida....");
				opcion1 = 0;
				break;
			}

			do {
								
				System.out.println(registros.get(0) + ", que deseas hacer ?");
				System.out.println(" ");
				System.out.println("1) Revisar equipo.");
				System.out.println("2) Salir a capturar.");
				System.out.println("3) Acceso al PC (cambiar Pokemon del equipo).");
				System.out.println("4) Retar un gimnasio.");
				System.out.println("5) Desafio al Alto Mando.");
				System.out.println("6) Curar Pokemon.");
				System.out.println("7) Guardar.");
				System.out.println("8) Guardar y Salir.");
				System.out.print("Ingrese opcion:  ");
				
				opcion2 = sc.nextInt();
				System.out.println(" ");
			
				switch (opcion2) {
				
				case 1:
					//revisar equipo
					mostrarInventario();						
					opcion2 = 0;
					break;
				case 2:
					System.out.println("Zonas disponibles:");
					System.out.println(" ");
					
					int i = 1;
					for ( String zona : habitads ) {
						System.out.println(i + ") " + zona);
						i++;
					}
					
					int numeroHabitad = 0;
					do {	
						numeroHabitad = sc.nextInt();
						
						if (numeroHabitad < 1 || numeroHabitad > 6) {
							System.out.println("numero Invalido");
						}
					}while(numeroHabitad < 1 || numeroHabitad > 6);
					String habitadEscogida = habitads.get(numeroHabitad - 1);
					
					Pokemon a = randomPokemon(habitadEscogida);
					
					System.out.println("Oh!! Ha aparecido un increible " + a.getNombre() + "!!");
					System.out.println("");
					System.out.println("Que deseas hacer?");
					System.out.println("");
					System.out.println("1) Capturar");
					System.out.println("2) Huir");
					
					int opcionCapturar = sc.nextInt();
					
					switch(opcionCapturar) {
					
					case 1:
						//agregar al pokemon al equipo
						registros.add(a.getNombre() + ";Vivo");
						agregarInventario(a);
						System.out.println(a.getNombre() + " Capturado con exito!!");
						System.out.println(" ");
						System.out.println(a.getNombre() + " ha sido agregado a tu equipo!");	
						System.out.println(" ");
						
						opcion2 = 0;
						break;
						
					case 2:
						System.out.println("Has huido....");
						opcion2 = 0;
						break;
						
					default:
						System.out.println("Opcion invalida");
						opcion2 = 0;
						break;
					
					}
				
					
				case 3:
					System.out.println("1) Cambiar Pokemon");
					System.out.println();
					break;
					//cambiar pokemon
				case 4:
					//retar un gimnasio
				case 5:
					//desafiar alto mando
				case 6:
					curarPokemons();
					System.out.println("Pokemons Curados....");
					opcion2 = 0;
					break;
					//curar pokemon
				case 7:
					limpiarArchivo(rutaRegistro);
					guardarRegistros(rutaRegistro);
					System.out.println("Juego guardado.");
					opcion2 = 0;
					break;
				case 8:
					System.out.println("Nos vemos entrenador.....");
					limpiarArchivo(rutaRegistro);
					guardarRegistros(rutaRegistro);
					
					break;
					//guardar y salir
				case 9:
					for (String b : registros) {
						System.out.println(b);
					}
					
					
				}								
			}while(opcion2 == 0);	
			
		case 3:
			System.out.println("Saliendo....");
			System.out.println("............");
			System.out.println("Terminado.");
			break;	
			
		default:
			System.out.println("Opcion invalida....");
			System.out.println(" ");
			
		}
		}while (opcion1 == 0);		
			
			
			
			

		
	}
}

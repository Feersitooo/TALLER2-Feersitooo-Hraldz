package Taller;

import java.util.Scanner;

public class app {
	public static void main(String[] args) {
		
		String rutaRegistro = "src/Registros.txt";
		Registro registro = new Registro();
		Pokemon pokemon = new Pokemon();
		
		
		Scanner sc = new Scanner(System.in);
		int opcion1 = 0;
		do{	
		System.out.println("1) Continuar.");
		System.out.println("2) Nueva Partida.");
		System.out.println("3) Salir.");
		opcion1 = sc.nextInt();
		
		
		switch (opcion1) {
		
		case 2:
			sc.nextLine();
			System.out.print("Ingrese su apodo de jugador :");
			String apodoNuevo = sc.nextLine();
			System.out.println(" ");
		
			registro.editarNombre(apodoNuevo, rutaRegistro);
			
			
		case 1 :
			int opcion2 = 0;
			if ((registro.mostrarNombre(rutaRegistro)) == null) {
				System.out.println("Debes crear una nueva partida....");
				opcion1 = 0;
				break;
			}
			do {
				System.out.println("Bienvenido "+ registro.mostrarNombre(rutaRegistro));
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
			case 2:
				//capturar
				//mostrar habitads disponibles
				System.out.println("Zonas disponibles:");
				System.out.println(" ");
				Habitads habitad = new Habitads("src/Habitats.txt");
				int i = 1;
				for ( String zona : habitad.getHabitads() ) {
					System.out.println(i + ") " + zona);
					i++;
				}
				// el numeroHabitad es el indice -1 de la lista de Habitads
				int numeroHabitad = 0;
				do {	
					numeroHabitad = sc.nextInt();
					
					if (numeroHabitad < 1 || numeroHabitad > 6) {
						System.out.println("numero Invalido");
					}
				}while(numeroHabitad < 1 || numeroHabitad > 6);
				String habitadEscogida = habitad.getHabitads().get(numeroHabitad - 1);
				
				Pokemon a = habitad.filtrarPorHabitad(habitadEscogida);
				
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
					System.out.println(a.getNombre() + " Capturado con exito!!");
					System.out.println(" ");
					pokemon.agregarPokemon(a);
					System.out.println(" ");
					//Agregar pokemons que se capturan a una lista que contenga los que tiene el usuario
					opcion2 = 0;
					break;
					
				case 2:
					System.out.println("Has huido....");
					opcion2 = 0;
					break;
					
				default:
					System.out.println("Opcion invalida");
				
				
				}
			
				
				
			case 3:
				//cambiar pokemon
			case 4:
				//retar un gimnasio
			case 5:
				//desafiar alto mando
			case 6:
				//curar pokemon
			case 7:
				//guardar
			case 8:
				//guardar y salir
				
				opcion2 = 0;
				break;
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

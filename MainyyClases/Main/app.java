package Main;

import java.util.Scanner;

import Clases.Habitads;
import Clases.Pokemon;

public class app {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion1 = 0;
		do{
			
			System.out.println("1) Continuar.");
			System.out.println("2) Nueva Partida.");
			System.out.println("3) Salir.");
			opcion1 = sc.nextInt();
		}while (opcion1 < 1 || opcion1 > 3);	
		
		switch (opcion1) {
		
		case 2:
			sc.nextLine();
			System.out.print("Ingrese su apodo de jugador :");
			String apodoNuevo = sc.nextLine();
			System.out.println(" ");
			System.out.println("Bienvenido "+ apodoNuevo);
			opcion1 = 1;
			
		case 1 :
			int opcion2 = 0;
			do {
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
				
			}while(opcion2 < 1 || opcion2 > 8);
			
			switch (opcion2) {
			
			case 1:
				//revisar equipo
			case 2:
				//capturar
				
				//mostrar habitads disponibles
				System.out.println("Zonas disponibles:");
				System.out.println(" ");
				Habitads habitad = new Habitads("MainyyClases/Habitats.txt");
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
				
				opcion2 = 1;
				break;
			}								
			break;
			
			
			
		
			
		case 3:
			System.out.println("Saliendo....");
			System.out.println("............");
			System.out.println("Terminado.");
			break;	
			
		default:
			System.out.println("Opcion invalida....");
			System.out.println(" ");

		}
			
			
			
			
			

		
	}
}
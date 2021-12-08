package Mainapp;

import java.util.Scanner;

import Models.Baraja;
import Models.Carta;

public class SieteYMedia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----BIENVENIDO AL JUEGO DE LAS 7 Y MEDIA----");
		int opcion = 0;

		do {
			System.out.println(
					"Por favor elige qué tipo de baraja quieres usar: " + "\n1. baraja sencilla" + "\n2. Baraja doble");
			opcion = Integer.parseInt(sc.nextLine());

			if (opcion != 1 && opcion != 2) {
				System.out.println("Introduce una opción válida por favor");
			}
		} while (opcion != 1 && opcion != 2);

		Baraja b = new Baraja(opcion);
		b.barajar();

		String resp;
		int cont = 0;
		double suma = 0;
		boolean salir = true;

		Carta x = b.getLista_cartas().get(cont);
		cont++;
		System.out.println("Su primera carta es el " + x.getNombreCarta());
		suma += x.getValor7ymedia();
		System.out.println("Su puntuación total es " + suma);

		do {
			salir = true;
			System.out.println("¿Quieres más cartas?(S/N)");
			resp = sc.nextLine();
			Carta c = b.getLista_cartas().get(cont);
			if (resp.equalsIgnoreCase("S")) {
				System.out.println("Su carta es el " + c.getNombreCarta());
				cont++;
				suma += c.getValor7ymedia();
				System.out.println("Su puntuación total es " + suma);
			} else {
				salir = false;
			}
		} while (salir && suma <= 7.5);

		if (suma > 7.5) {
			System.out.println("Lo siento has perdido");
		} else {
			System.out.println("Enhorabuena!! Has ganado :D");
		}

		sc.close();
	}

}

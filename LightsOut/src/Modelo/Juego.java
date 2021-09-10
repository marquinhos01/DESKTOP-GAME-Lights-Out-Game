package Modelo;

import java.util.Objects;

public class Juego {
	private static int puntaje;
	
	public Juego(String nombre) {
		puntaje=0;
		
	}
	
	public static int SumaPuntos() {
		return puntaje ++;
	}

	public static int getPuntaje() {
		return puntaje;
	}	

	public static void setPuntaje(int puntaje) {
		Juego.puntaje = puntaje;
	}

	public static String getStringPuntaje() {
		StringBuilder puntos = new StringBuilder();
		puntos.append(puntaje);
		return puntos.toString();
	}
	
}

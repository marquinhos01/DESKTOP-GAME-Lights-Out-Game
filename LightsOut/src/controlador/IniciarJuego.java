package controlador;

import Modelo.Grilla;
import view.Menu;

public class IniciarJuego {
	private static int puntaje;

	public static void main(String[] args) {
		Menu menu = new Menu();
		Grilla grilla = new Grilla();
		Controlador controlador = new Controlador(menu, grilla);
		puntaje=0;
	}
	
	public static int SumaPuntos() {
		return puntaje ++;
	}

	public static int getPuntaje() {
		return puntaje;
	}

	public static String getStringPuntaje() {
		StringBuilder puntos = new StringBuilder();
		puntos.append(puntaje);
		return puntos.toString();
	}
	
}

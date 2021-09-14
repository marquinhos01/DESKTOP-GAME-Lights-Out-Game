package Main;

import controlador.Controlador;
import Modelo.Juego;
import view.Menu;

public class main {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		Juego juego = new Juego();
		Controlador controlador = new Controlador(menu, juego);
		controlador.inicializar();
	}
}

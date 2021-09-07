package controlador;

import Modelo.Grilla;
import view.Menu;

public class IniciarJuego {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Grilla grilla = new Grilla();
		Controlador controlador = new Controlador(menu, grilla);
	}

}

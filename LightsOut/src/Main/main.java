package Main;

import controlador.Controlador;
import Modelo.Grilla;
import view.Menu;

public class main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Grilla grilla = new Grilla();
		Controlador controlador = new Controlador(menu, grilla);
		controlador.inicializar();
	}
	
}


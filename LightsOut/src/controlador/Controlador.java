package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Grilla;
import view.Menu;
import view.VistaJuego;

public class Controlador {

	private Menu ventanaMenu;
	private VistaJuego ventanaJuego;
	private Grilla grilla;
	private int filaGrilla;
	private int columnaGrilla;

	public Controlador(Menu menu, Grilla grilla) {
		VistaJuego juego = new VistaJuego();
		this.ventanaJuego = juego;
		this.ventanaMenu = menu;
		this.grilla = grilla;

		ventanaMenu.show();

		ventanaMenu.getBtnJugar().addActionListener(e -> iniciar(e));

		ventanaJuego.getGrillaVista().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				filaGrilla = ventanaJuego.getGrillaVista().rowAtPoint(evt.getPoint());
				columnaGrilla = ventanaJuego.getGrillaVista().columnAtPoint(evt.getPoint());
				grilla.cambiarEstadoGrilla(filaGrilla, columnaGrilla);
				System.out.println(grilla.toString());
			}
		});
	}

	public void iniciar(ActionEvent e) {
		ventanaMenu.ocultar();
		ventanaJuego.show();
		grilla.iniciarGrilla();
		System.out.println(grilla.toString());
	}

	public static void main(String[] args) {

		Menu menu = new Menu();
		Grilla grilla = new Grilla();
		Controlador controlador = new Controlador(menu, grilla);
	}

}

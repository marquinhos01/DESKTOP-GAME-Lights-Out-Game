package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.BDJugador;
import Modelo.Grilla;
import Modelo.Jugador;
import view.Menu;
import view.VistaJuego;

public class Controlador {

	private Menu ventanaMenu;
	private VistaJuego ventanaJuego;
	private Grilla grilla;
	private int filaGrilla;
	private int columnaGrilla;
	private BDJugador jugadores;
	private String nombreJugador;

	public Controlador(Menu menu, Grilla grilla) {
		this.jugadores = new BDJugador();
		VistaJuego juego = new VistaJuego();
		this.ventanaJuego = juego;
		this.ventanaMenu = menu;
		this.grilla = grilla;

		ventanaMenu.show();

		ventanaMenu.getBtnJugar().addActionListener(e -> iniciar(e));
		ventanaJuego.getBtnTerminar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaJuego.ocultar();
				ventanaMenu.show();
			}
		});
		ventanaJuego.getGrillaVista().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				filaGrilla = ventanaJuego.getGrillaVista().rowAtPoint(evt.getPoint());
				columnaGrilla = ventanaJuego.getGrillaVista().columnAtPoint(evt.getPoint());
				grilla.cambiarEstadoGrilla(filaGrilla, columnaGrilla);
				IniciarJuego.SumaPuntos();
				ventanaJuego.actualizarPuntaje();
				System.out.println(IniciarJuego.getPuntaje());

				if (!grilla.todosFalse()) { // gane!
					ventanaJuego.getMainFrame().setVisible(false);
				}

				System.out.println(grilla.toString());

				for (int i = 0; i < grilla.casillas.length; i++) {
					for (int j = 0; j < grilla.casillas.length; j++) {
						if (grilla.estadoCasilla(i, j)) {
							ventanaJuego.cambiarImagenesFocoPrendido(i, j);
						} else
							ventanaJuego.cambiarImagenesFocoApagado(i, j);
					}
				}
					
			}
			
		});
	}

	public void iniciar(ActionEvent e) {
		
		if (ventanaMenu.getCampoNombre().getText().equals("")) {
			throw new RuntimeException("Complete el nombre para seguir");
		} 
		else {
			nombreJugador = ventanaMenu.getCampoNombre().getText();
			jugadores.ingresarJugador(new Jugador(nombreJugador));

			ventanaMenu.ocultar();
			ventanaJuego.show();
			grilla.iniciarGrilla();
			System.out.println(grilla.toString());
			for (int i = 0; i < grilla.casillas.length; i++) {
				for (int j = 0; j < grilla.casillas.length; j++) {
					if (grilla.estadoCasilla(i, j) == true) {
						ventanaJuego.cambiarImagenesFocoPrendido(i, j);
					} else {
						ventanaJuego.cambiarImagenesFocoApagado(i, j);
					}
				}

			}
		}

	}
}


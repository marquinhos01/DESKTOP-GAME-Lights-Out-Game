package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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

	public Controlador(Menu menu, Grilla grilla) {
		VistaJuego juego = new VistaJuego();
		this.ventanaJuego = juego;
		this.ventanaMenu = menu;
		this.grilla = grilla;

		ventanaMenu.show();

		ventanaMenu.getBtnJugar().addActionListener(ini -> iniciar(ini));
		ventanaJuego.getBtnTerminar().addActionListener(x -> cerrar(x));
		ventanaJuego.getGrillaVista().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				filaGrilla = ventanaJuego.getGrillaVista().rowAtPoint(evt.getPoint());
				columnaGrilla = ventanaJuego.getGrillaVista().columnAtPoint(evt.getPoint());
				grilla.cambiarEstadoGrilla(filaGrilla, columnaGrilla);
				IniciarJuego.SumaPuntos();
				ventanaJuego.actualizarPuntaje();
				
				//Cambia la imagen del foco segun su estado
				for (int i = 0; i < grilla.casillas.length; i++) {
					for (int j = 0; j < grilla.casillas.length; j++) {
						if (grilla.estadoCasilla(i, j)) {
							ventanaJuego.cambiarImagenesFocoPrendido(i, j);
						} else
							ventanaJuego.cambiarImagenesFocoApagado(i, j);
					}
				}
				
				// Si el jugador gana
				if (!grilla.todosFalse()) { 
					ventanaJuego.getMainFrame().setVisible(false);
				}	
			}
			
		});
	}

	public void iniciar(ActionEvent ini) {		
		if (ventanaMenu.getCampoNombre().getText().equals("")) {
			JOptionPane.showMessageDialog(ventanaMenu.getVentana(), "Complete el nombre para seguir");
		} 
		else {
//			nombreJugador = ventanaMenu.getCampoNombre().getText();
//			jugadores.ingresarJugador(new Jugador(nombreJugador));

			ventanaMenu.ocultar();
			ventanaJuego.show();
			grilla.iniciarGrilla();
			
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
	
	public void cerrar(ActionEvent x) {
		ventanaJuego.ocultar();
		ventanaMenu.setCampoNombre("");
		ventanaMenu.show();
	}
}


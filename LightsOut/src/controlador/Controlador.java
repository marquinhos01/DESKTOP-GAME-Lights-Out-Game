package controlador;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Modelo.Grilla;
import Modelo.Juego;
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

		//Boton Jugar - Menu
		ventanaMenu.getBtnJugar().addActionListener(ini -> iniciar(ini));
		//Boton Terminar - Pantalla juego
		ventanaJuego.getBtnTerminar().addActionListener(r -> reiniciar(r));
		//Acciones Click Mouse
		ventanaJuego.getBtnCambiarGrilla().addActionListener(camb -> reiniciarGrilla(camb));
		ventanaJuego.getGrillaVista().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				filaGrilla = ventanaJuego.getGrillaVista().rowAtPoint(evt.getPoint());
				columnaGrilla = ventanaJuego.getGrillaVista().columnAtPoint(evt.getPoint());
				grilla.cambiarEstadoGrilla(filaGrilla, columnaGrilla);
				Juego.SumaPuntos();
				ventanaJuego.actualizarPuntaje();
				
				//Cambia la imagen del foco segun su estado
				for (int i = 0; i < grilla.longitud(); i++) {
					for (int j = 0; j < grilla.longitud(); j++) {
						if (grilla.estadoCasilla(i, j)) {
							ventanaJuego.cambiarImagenesFocoPrendido(i, j);
						} else
							ventanaJuego.cambiarImagenesFocoApagado(i, j);
					}
				}
				
				// Si el jugador gana
				if (!grilla.todosFalse()) { 
					JOptionPane.showMessageDialog(ventanaJuego.getMainFrame(), ventanaMenu.getCampoNombre().getText() 
					+ " ¡Ganaste en " + Juego.getStringPuntaje() + " movimientos!");
				}	
			}
			
		});
		
	}
	
	//METODOS
	
	public void inicializar() {
		ventanaMenu.show();
	}

	public void iniciar(ActionEvent ini) {
		Juego.setPuntaje(0);
		ventanaJuego.actualizarPuntaje();
		if (ventanaMenu.getCampoNombre().getText().equals("")) {
			JOptionPane.showMessageDialog(ventanaMenu.getVentana(), "Ingrese un nombre para continuar");
		} 
		else {
			ventanaMenu.ocultar();
			ventanaJuego.show();
			reiniciarGrilla(ini);
		}
	}
	
	public void reiniciar(ActionEvent r) {
		ventanaJuego.ocultar();
		ventanaMenu.setCampoNombre("");
		ventanaJuego.actualizarPuntaje();
		JOptionPane.showMessageDialog(ventanaJuego.getMainFrame(), ventanaMenu.getCampoNombre().getText() 
				+ " ¡No lo terminaste, pero hiciste: " + Juego.getStringPuntaje() + " movimientos!");
		Juego.setPuntaje(0);
		ventanaMenu.show();
		
	}
	public void reiniciarGrilla(ActionEvent camb) {
		grilla.iniciarGrilla();
		for (int i = 0; i < grilla.longitud(); i++) {
			for (int j = 0; j < grilla.longitud(); j++) {
				if (grilla.estadoCasilla(i, j) == true) {
					ventanaJuego.cambiarImagenesFocoPrendido(i, j);
				} else {
					ventanaJuego.cambiarImagenesFocoApagado(i, j);
				}
			}
		}
	}
	
}


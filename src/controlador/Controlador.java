package controlador;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import Modelo.Juego;
import view.Menu;
import view.VentanaDificultad;
import view.VistaJuego;

public class Controlador {

	private Menu ventanaMenu;
	private VentanaDificultad ventanaDif;
	private VistaJuego ventanaJuego;
	private Juego juego;
	private int filaGrilla;
	private int columnaGrilla;
	private FileInputStream sondioTocar;
	private Player sonidoToque;

	public Controlador(Menu menu, Juego juego) {

		VentanaDificultad dialogo = new VentanaDificultad();
		VistaJuego ventana = new VistaJuego();
		this.ventanaDif=dialogo;
		this.ventanaJuego = ventana;
		this.ventanaMenu = menu;
		this.juego = juego;

		// Boton Jugar - Menu
		ventanaMenu.getBtnJugar().addActionListener(ini -> iniciar(ini));
		ventanaDif.getBtnNormal().addActionListener(n -> juegoNormal(n));
		ventanaDif.getBtnDificil().addActionListener(d -> juegoDificil(d));
		ventanaDif.getBtnFacil().addActionListener(f -> juegoFacil(f));
		// Boton Terminar - Pantalla juego
		ventanaJuego.getBtnTerminar().addActionListener(r -> reiniciar(r));
		// Acciones Click Mouse
		ventanaJuego.getBtnCambiarGrilla().addActionListener(camb -> reiniciarGrilla(camb));
		ventanaJuego.getGrillaVista().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//filGrilla = i de la grilla, culumnaGrilla = j de la grilla
				filaGrilla = ventanaJuego.getGrillaVista().rowAtPoint(evt.getPoint());
				columnaGrilla = ventanaJuego.getGrillaVista().columnAtPoint(evt.getPoint());
				juego.getGrilla().cambiarEstadoGrilla(filaGrilla, columnaGrilla);
				juego.SumaPuntos();
				ventanaJuego.actualizarPuntaje(juego);
				
				// Cambia la imagen del foco segun su estado
				for (int i = 0; i < juego.getGrilla().longitud() ; i++) {
					for (int j = 0; j < juego.getGrilla().longitud(); j++) {
						if (juego.getGrilla().estadoCasilla(i, j)) {
							ventanaJuego.cambiarImagenesFocoPrendido(i, j);
						} else
							ventanaJuego.cambiarImagenesFocoApagado(i, j);
					}
				}

				// sonido
				sonido("focoSoundx");

				// Si el jugador gana
				if (!juego.getGrilla().todosFalse()) {
					JOptionPane.showMessageDialog(ventanaJuego.getMainFrame(), ventanaMenu.getCampoNombre().getText()
							+ " ¡Ganaste en " + juego.getStringPuntaje() + " movimientos!");
				}
			}

		});

	}

	// METODOS
	public void inicializar() {
		ventanaMenu.show();
	}

	public void iniciar(ActionEvent ini) {
		juego.setPuntaje(0);
		ventanaJuego.actualizarPuntaje(juego);
		if (ventanaMenu.getCampoNombre().getText().equals(""))
			JOptionPane.showMessageDialog(ventanaMenu.getVentana(), "Ingrese un nombre para continuar");
		else {
			ventanaMenu.ocultar();
			ventanaDif.show();
		}
	}

	public void juegoNormal(ActionEvent n) {
		ventanaDif.ocultar();
		ventanaJuego.show();
		juego.crearGrilla(4);		
		juego.getGrilla().iniciarGrilla();
		ventanaJuego.tamanioGrilla(4);
		for (int i = 0; i < juego.getGrilla().longitud(); i++) {
			for (int j = 0; j < juego.getGrilla().longitud(); j++) {
				if (juego.getGrilla().estadoCasilla(i, j) == true) {
					ventanaJuego.cambiarImagenesFocoPrendido(i, j);
				} else {
					ventanaJuego.cambiarImagenesFocoApagado(i, j);
				}
			}
		}
	}	
	
	public void juegoDificil(ActionEvent d) {
		ventanaDif.ocultar();
		ventanaJuego.show();
		juego.crearGrilla(5);		
		juego.getGrilla().iniciarGrilla();
		ventanaJuego.tamanioGrilla(5);
		for (int i = 0; i < juego.getGrilla().longitud(); i++) {
			for (int j = 0; j < juego.getGrilla().longitud(); j++) {
				if (juego.getGrilla().estadoCasilla(i, j) == true) {
					ventanaJuego.cambiarImagenesFocoPrendido(i, j);
				} else {
					ventanaJuego.cambiarImagenesFocoApagado(i, j);
				}
			}
		}
	}
	
	public void juegoFacil(ActionEvent f) {
		ventanaDif.ocultar();
		ventanaJuego.show();
		juego.crearGrilla(1);		
		juego.getGrilla().iniciarGrilla();
		ventanaJuego.tamanioGrilla(1);
		for (int i = 0; i < juego.getGrilla().longitud(); i++) {
			for (int j = 0; j < juego.getGrilla().longitud(); j++) {
				if (juego.getGrilla().estadoCasilla(i, j) == true) {
					ventanaJuego.cambiarImagenesFocoPrendido(i, j);
				} else {
					ventanaJuego.cambiarImagenesFocoApagado(i, j);
				}
			}
		}
	}


	public void reiniciar(ActionEvent r) {
		ventanaJuego.ocultar();
		ventanaMenu.setCampoNombre("");
		ventanaJuego.actualizarPuntaje(juego);
		JOptionPane.showMessageDialog(ventanaJuego.getMainFrame(), ventanaMenu.getCampoNombre().getText()
				+ " ¡No lo terminaste, pero hiciste: " + juego.getStringPuntaje() + " movimientos!");
		juego.setPuntaje(0);
		ventanaMenu.show();
	}

	public void reiniciarGrilla(ActionEvent camb) {
		juego.getGrilla().iniciarGrilla();
		for (int i = 0; i < juego.getGrilla().longitud(); i++) {
			for (int j = 0; j < juego.getGrilla().longitud(); j++)
				if (juego.getGrilla().estadoCasilla(i, j) == true)
					ventanaJuego.cambiarImagenesFocoPrendido(i, j);
				else
					ventanaJuego.cambiarImagenesFocoApagado(i, j);
		}
	}

	private void sonido(String sonido) {
		try {
			sondioTocar = new FileInputStream("music/" + sonido + ".mp3");
			sonidoToque = new Player(sondioTocar);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			sonidoToque.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}

}

package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tamanios {

	protected int anchoFrame;
	protected int altoFrame;
	protected int centrarObjetoHorizontal;
	protected int anchoObjetos;
	
	
	public Dimension tamanoPantalla() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize(); 
		return tamanoPantalla;
	}
	public int getAnchoPantallaPC() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize(); 
		return tamanoPantalla.width;
	}
	public int getAltoPantallaPC() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize(); 
		return tamanoPantalla.height;
	}
	
	public int getAnchoFrame(JFrame panel) {
		return panel.getWidth();
	}
	public int getAltoFrame(JFrame panel) {
		return panel.getHeight();
	}
	public int centrarObjetoHorizontal(JFrame panel) {
		return panel.getWidth()/4;
	}
	public int getAnchoObjeto(JFrame panel) {
		return getAnchoFrame(panel)/2;
	}

}

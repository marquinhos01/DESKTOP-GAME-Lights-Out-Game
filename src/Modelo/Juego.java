package Modelo;

public class Juego {
	private Grilla grilla;
	private int puntaje;

	public Juego() {
		puntaje = 0;

	}
	
	public void crearGrilla(int i) {
		grilla = new Grilla(i);		
	}
	
	public Grilla getGrilla() {
		return this.grilla;
	}

	public int SumaPuntos() {
		return puntaje++;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getStringPuntaje() {
		StringBuilder puntos = new StringBuilder();
		puntos.append(puntaje);
		return puntos.toString();
	}

}

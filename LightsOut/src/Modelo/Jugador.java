package Modelo;

public class Jugador {
	private String _nombre;
	private int _puntaje;
	
	public Jugador(String nombre, int puntaje) {
		this._nombre=nombre;
		this._puntaje=puntaje;
		
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String _nombre) {
		this._nombre = _nombre;
	}

	public int getPuntaje() {
		return _puntaje;
	}

	public void setPuntaje(int _puntaje) {
		this._puntaje = _puntaje;
	}

}

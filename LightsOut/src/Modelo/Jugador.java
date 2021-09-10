package Modelo;


import java.util.Objects;

public class Jugador {
	private String nombre;
	private int puntaje;
	
	public Jugador(String nombre) {
		this.nombre=nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int _puntaje) {
		this.puntaje = _puntaje;
	}

	@Override
	public String toString() {
		return  nombre + ", " + puntaje;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}






	
}

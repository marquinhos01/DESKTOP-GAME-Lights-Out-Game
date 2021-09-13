package Modelo;

import java.util.ArrayList;

public class Grilla {
	private Boolean[][] casillas;

	public Grilla() {
		this.casillas = new Boolean[4][4];
	}

	// Devuelve un n�mero aleatorio m�dulo 4
	private int indiceAleatorio() {
		return (int) (Math.random() * 200) % 4;
	}

	// Suponiendo que inicialmente se pintan 4 casillas
	public void iniciarGrilla() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				this.casillas[i][j] = false;
			}
		}
		int k = 0;
		ArrayList<String> indices = new ArrayList<String>();
		while (k < 4) {
			int i = this.indiceAleatorio(); // los �ndices est�n en rango
			int j = this.indiceAleatorio();
			if (!indices.contains(i + "" + j)) {
				this.casillas[i][j] = true;
				indices.add(i + "" + j); //se van guardando las posiciones
				k++;
			}
		}
	}

	public void cambiarEstadoGrilla(int i, int j) {
		if (i >= 0 | i < 4 | j >= 0 | j < 4) {
			this.cambiarEstadoCasilla(i, j);
			if (i < 3)
				this.cambiarEstadoCasilla(i + 1, j);
			if (i > 0)
				this.cambiarEstadoCasilla(i - 1, j);
			if (j < 3)
				this.cambiarEstadoCasilla(i, j + 1);
			if (j > 0)
				this.cambiarEstadoCasilla(i, j - 1);
		}
	}

	// si la luz est� encendida, se apaga...si est� apagada, se enciende
	private void cambiarEstadoCasilla(int i, int j) {
		if (this.casillas[i][j]) {
			this.casillas[i][j] = false;
		} else {
			this.casillas[i][j] = true;
		}
	}

	public boolean estadoCasilla(int i, int j) {
		return this.casillas[i][j];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sb.append(casillas[i][j] + "   ");
			}
			sb.append("\n\n");
		}
		return sb.toString();
	}

	public boolean todosFalse() {
		boolean todosFalsos = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				todosFalsos = todosFalsos || estadoCasilla(i, j);
			}
		}
		return todosFalsos;
	}
	
	public int longitud() {
		return this.casillas.length;
	}

}

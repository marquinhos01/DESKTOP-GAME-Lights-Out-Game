package Modelo;

import java.util.ArrayList;

public class Grilla {
	private Boolean[][] casillas;

	public Grilla(int matriz) {
		this.casillas = new Boolean[matriz][matriz];
	}

	// Devuelve un número aleatorio
	private int indiceAleatorio() {
		return (int) (Math.random() * 100 * casillas.length) % casillas.length;
	}

	// Suponiendo que inicialmente se pintan 4 casillas
	public void iniciarGrilla() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				this.casillas[i][j] = false;
			}
		}
		int k = 0;
		ArrayList<String> indices = new ArrayList<String>();
		while (k < casillas.length) {
			int i = this.indiceAleatorio(); // los índices están en rango
			int j = this.indiceAleatorio();
			if (!indices.contains(i + "" + j)) {
				this.casillas[i][j] = true;
				indices.add(i + "" + j);
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

	// si la luz está encendida, se apaga... si está apagada, se enciende
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
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				sb.append(casillas[i][j] + "   ");
			}
			sb.append("\n\n");
		}
		return sb.toString();
	}

	public boolean todosFalse() {
		boolean todosFalsos = false;
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				todosFalsos = todosFalsos || estadoCasilla(i, j);
			}
		}
		return todosFalsos;
	}

	public int longitud() {
		return casillas.length;
	}
	
	

}
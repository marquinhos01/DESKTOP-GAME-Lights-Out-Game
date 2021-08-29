package Modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Grilla {
	private Boolean[][] casillas;
	public Grilla(){
		this.casillas=new Boolean[4][4];
	}
	
	//Devuelve un número aleatorio módulo 4
	private int indiceAleatorio() {
		return (int) (Math.random()*200)%4;
	}
	
	//Suponiendo que inicialmente se pintan 4 casillas
	private void crearGrilla() {
		int k=0;
		ArrayList<String> indices = new ArrayList<String>();
		while(k<4) {
			int i= this.indiceAleatorio(); //los índices están en rango
			int j= this.indiceAleatorio();
			if(!indices.contains(i+""+j)) {
				this.casillas[i][j]= true;
				indices.add(i+""+j);
				k++;
			}
		}
	}
	
	private void cambiarEstadoGrilla() {
		
	}
	
	private void cambiarEstadoCasilla(int i, int j) {
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				sb.append(casillas[i][j].toString() + "   ");
			}
			sb.append("\n\n");
		}
		return sb.toString();
	}
	
	
}

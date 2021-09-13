package Main;

import controlador.Controlador;

import javazoom.jl.player.Player;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;

import Modelo.Grilla;
import view.Menu;


import javax.sound.sampled.AudioSystem;

public class main {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		Grilla grilla = new Grilla();
		Controlador controlador = new Controlador(menu, grilla);
		controlador.inicializar();
	}


	 


}

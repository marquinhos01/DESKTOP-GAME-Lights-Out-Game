package Modelo;

public class Main {
	public static void main(String[] args) {
		Grilla nueva= new Grilla();
		System.out.print("Grilla inicial \n");
		System.out.print(nueva.toString());
		System.out.print("Se agregan valores iniciales \n");
		nueva.iniciarGrilla();
		System.out.print(nueva.toString());
		
	}
}

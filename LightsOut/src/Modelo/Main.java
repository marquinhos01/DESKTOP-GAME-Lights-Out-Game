package Modelo;

public class Main {
	public static void main(String[] args) {
		Grilla nueva= new Grilla();
		System.out.print("Grilla inicial \n \n");
		System.out.print(nueva.toString());
		System.out.print("Se agregan valores iniciales \n \n");
		nueva.iniciarGrilla();
		System.out.print(nueva.toString());
		System.out.print("Se clikea en el lugar 2 2 \n \n");
		nueva.cambiarEstadoGrilla(2, 2);
		System.out.print(nueva.toString());
		
	}
}

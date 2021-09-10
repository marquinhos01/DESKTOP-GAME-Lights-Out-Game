package view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Modelo.Grilla;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class Menu extends Tamanios {

	private JFrame ventana;

	private JTextField campoNombre;
	private JLabel tituloSuperior;
	private JButton btnJugar;
	private JButton btnVerRecord;
	private JButton btnCambiarMusica;
	private JLabel labelImagenFondo;
	private ImageIcon imgMenu;

	public Menu() {
		super();
		initialize();
	}

	public void initialize() {
		ventana = new JFrame();

		Toolkit miPantalla = Toolkit.getDefaultToolkit();  //devuelve un objeto toolkit ya que es abstracto, devuelve la ventana
		 Dimension tamanoPantalla = miPantalla.getScreenSize(); //la resolucion de la
		 
		int anchoPantallaPC = tamanoPantalla.width;
		int alto = tamanoPantalla.height;
//		
//		ventana.setBounds(100, 100, 650, 700);
		ventana.setSize(tamanoPantalla);
		ventana.setBounds(anchoPantallaPC/4, 0, anchoPantallaPC/2, alto - 50);
	//	frame.setUndecorated(true);
		
		ventana.setResizable(false);

		// frame.setExtendedState(6);
		ventana.setTitle("Menu");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);




		tituloSuperior = new JLabel("Lights Outs");

		tituloSuperior.setHorizontalAlignment(SwingConstants.CENTER);
		tituloSuperior.setFont(new Font("Snap ITC", Font.PLAIN, 44));

		tituloSuperior.setSize(super.getAnchoObjeto(ventana), 76);
		tituloSuperior.setLocation(tituloSuperior.getWidth() / 2, 0);

		ventana.getContentPane().add(tituloSuperior);

		btnJugar = new JButton("JUGAR");
		btnJugar.setBackground(Color.LIGHT_GRAY);

		btnJugar.setFont(new Font("Snap ITC", Font.PLAIN, 24));
		btnJugar.setBounds(centrarObjetoHorizontal(ventana), 360, getAnchoObjeto(ventana), 62);

		ventana.getContentPane().add(btnJugar);

		btnVerRecord = new JButton("MAXIMO RECORD");
		btnVerRecord.setBackground(Color.LIGHT_GRAY);
		btnVerRecord.setFont(new Font("Snap ITC", Font.PLAIN, 23));
		btnVerRecord.setBounds(super.centrarObjetoHorizontal(ventana), 445, super.getAnchoObjeto(ventana), 54);
		ventana.getContentPane().add(btnVerRecord);

		btnCambiarMusica = new JButton("CAMBIAR MUSICA");
		btnCambiarMusica.setBackground(Color.LIGHT_GRAY);
		btnCambiarMusica.setFont(new Font("Snap ITC", Font.PLAIN, 23));
		btnCambiarMusica.setBounds(super.centrarObjetoHorizontal(ventana), 526, super.getAnchoObjeto(ventana), 54);
		ventana.getContentPane().add(btnCambiarMusica);

		labelImagenFondo = new JLabel("");
		imgMenu = new ImageIcon(this.getClass().getResource("/fondoMenu.png"));
		labelImagenFondo.setIcon(imgMenu);
		labelImagenFondo.setBounds(0, 0, super.getAnchoFrame(ventana), super.getAltoFrame(ventana));
		ventana.getContentPane().add(labelImagenFondo);

		campoNombre = new JTextField();
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombre.setBounds(super.centrarObjetoHorizontal(ventana), 172, super.getAnchoObjeto(ventana), 42);
		ventana.getContentPane().add(campoNombre);
		campoNombre.setColumns(10);

	}	
	

	public JFrame getVentana() {
		return ventana;
	}

	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}

	public JTextField getCampoNombre() {
		return campoNombre;
	}

	public void setCampoNombre(String campoNombre) {
		this.campoNombre.setText(campoNombre);
	}

	public JLabel getTituloSuperior() {
		return tituloSuperior;
	}

	public void setTituloSuperior(JLabel tituloSuperior) {
		this.tituloSuperior = tituloSuperior;
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}

	public void setBtnJugar(JButton btnJugar) {
		this.btnJugar = btnJugar;
	}

	public JButton getBtnVerRecord() {
		return btnVerRecord;
	}

	public void setBtnVerRecord(JButton btnVerRecord) {
		this.btnVerRecord = btnVerRecord;
	}

	public JButton getBtnCambiarMusica() {
		return btnCambiarMusica;
	}

	public void setBtnCambiarMusica(JButton btnCambiarMusica) {
		this.btnCambiarMusica = btnCambiarMusica;
	}

	public JLabel getLabelImagenFondo() {
		return labelImagenFondo;
	}

	public void setLabelImagenFondo(JLabel labelImagenFondo) {
		this.labelImagenFondo = labelImagenFondo;
	}

	public ImageIcon getImgMenu() {
		return imgMenu;
	}

	public void setImgMenu(ImageIcon imgMenu) {
		this.imgMenu = imgMenu;
	}
	public void show() {
		this.ventana.setVisible(true);
	}
	public void ocultar() {
		this.ventana.dispose();
	}

}

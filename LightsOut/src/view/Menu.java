package view;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;


public class Menu extends Tamanios {

	private JFrame ventana;

	private JTextField campoNombre;
	private JLabel tituloSuperior;
	private JButton btnJugar;
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

		ventana.setBounds(anchoPantallaPC/4, 0, anchoPantallaPC/2, alto - 50);

		ventana.setResizable(false);

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
		btnJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJugar.setBackground(Color.LIGHT_GRAY);

		btnJugar.setFont(new Font("Snap ITC", Font.PLAIN, 24));
		btnJugar.setBounds(ventana.getWidth()/4, 360, ventana.getWidth()/2, 62);

		ventana.getContentPane().add(btnJugar);

		

		labelImagenFondo = new JLabel("");
		imgMenu = new ImageIcon(this.getClass().getResource("/fondoMenu.png"));
//		imgMenu = new ImageIcon("C:\\Users\\Romina\\git\\trabajo_practico_progra\\lightsout\\LightsOut\\images\\fondoMenu.png");
		labelImagenFondo.setIcon(imgMenu);
		labelImagenFondo.setBounds(0, 0, super.getAnchoFrame(ventana), super.getAltoFrame(ventana));
		ventana.getContentPane().add(labelImagenFondo);

		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Stencil", Font.PLAIN, 20));
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombre.setBounds(ventana.getWidth()/4, 172, ventana.getWidth()/2, 42);
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

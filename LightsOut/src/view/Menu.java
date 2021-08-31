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

	private JFrame frame;
	private int anchoFrame;
	private int anchoObjetos;
	private JTextField campoNombre;
	
	

	/**
	 * Create the application.
	 */
	public Menu() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void refrezcar() {
		initialize();
	}

	public void initialize() {

		Toolkit miPantalla = Toolkit.getDefaultToolkit();  //devuelve un objeto toolkit ya que es abstracto, devuelve la ventana
		 Dimension tamanoPantalla = miPantalla.getScreenSize(); //la resolucion de la
		// pantalla pc 1200x2320
		int anchoPantallaPC = tamanoPantalla.width;
		int alto = tamanoPantalla.height;
//		
		frame = new JFrame();
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setSize(tamanoPantalla);
		frame.setBounds(anchoPantallaPC/4, 0, anchoPantallaPC/2,
				alto - 50);
	//	frame.setUndecorated(true);
		frame.setVisible(true);
		anchoFrame = frame.getWidth();
		frame.setResizable(false);

		// frame.setExtendedState(6);
		frame.setTitle("primera tabla");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		altoFrame = frame.getHeight();
		centrarObjetoHorizontal = anchoFrame / 4;

		anchoObjetos =super.getAnchoObjeto(frame);

		JLabel titulo = new JLabel("Lights Outs");

		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Snap ITC", Font.PLAIN, 44));

		titulo.setSize(anchoObjetos, 76);
		titulo.setLocation(titulo.getWidth() / 2, 0);

		frame.getContentPane().add(titulo);

		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			        frame.dispose();
			        VistaJuego window = new VistaJuego();
					window.getMainFrame().setVisible(true);
				
					Grilla n = new Grilla();
					n.iniciarGrilla();
					System.out.println(n.toString());
			}
		});
		btnJugar.setBackground(Color.LIGHT_GRAY);

		btnJugar.setFont(new Font("Snap ITC", Font.PLAIN, 24));
		btnJugar.setBounds(centrarObjetoHorizontal(frame), 360, getAnchoObjeto(frame), 62);

		frame.getContentPane().add(btnJugar);

		JButton btnVerRecord = new JButton("MAXIMO RECORD");
		btnVerRecord.setBackground(Color.LIGHT_GRAY);
		btnVerRecord.setFont(new Font("Snap ITC", Font.PLAIN, 23));
		btnVerRecord.setBounds(super.centrarObjetoHorizontal(frame), 445, super.getAnchoObjeto(frame), 54);
		frame.getContentPane().add(btnVerRecord);

		JButton cambiarMusica = new JButton("CAMBIAR MUSICA");
		cambiarMusica.setBackground(Color.LIGHT_GRAY);
		cambiarMusica.setFont(new Font("Snap ITC", Font.PLAIN, 23));
		cambiarMusica.setBounds(super.centrarObjetoHorizontal(frame), 526, super.getAnchoObjeto(frame), 54);
		frame.getContentPane().add(cambiarMusica);

		JLabel fondoMenu = new JLabel("");
		ImageIcon imgMenu = new ImageIcon(this.getClass().getResource("/fondoMenu.png"));
		fondoMenu.setIcon(imgMenu);
		fondoMenu.setBounds(0, 0, super.getAnchoFrame(frame), super.getAltoFrame(frame));
		frame.getContentPane().add(fondoMenu);

		campoNombre = new JTextField();
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		campoNombre.setBounds(super.centrarObjetoHorizontal(frame), 172, super.getAnchoObjeto(frame), 42);
		frame.getContentPane().add(campoNombre);
		campoNombre.setColumns(10);

	}

	// ++++++++++++++++++++++++++++++++++++++++++++ Main
	// +++++++++++++++++++++++++++++++++++++++++++++

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

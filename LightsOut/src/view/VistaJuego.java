package view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import java.awt.Font;

public class VistaJuego {

	private JFrame mainFrame;
	private JTable table;
	private JFrame barraAbajo;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaJuego window = new VistaJuego();
					window.getMainFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaJuego() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit();  //devuelve un objeto toolkit ya que es abstracto, devuelve la ventana
		 Dimension tamanoPantalla = miPantalla.getScreenSize(); //la resolucion de la
		// pantalla pc 1200x2320
		int anchoPantallaPC = tamanoPantalla.width;
		int alto = tamanoPantalla.height;
		mainFrame = new JFrame();
		getMainFrame().setBackground(Color.BLACK);
		getMainFrame().setSize(tamanoPantalla);
		getMainFrame().setBounds(anchoPantallaPC/4, 0, anchoPantallaPC/2,
				alto - 50);
//		mainFrame.setBounds(100, 100, 650, 700);
		getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getMainFrame().getContentPane().setLayout(new BorderLayout(20, 40));

		
		
		
		
		
//		JButton btnNewButton_1 = new JButton("New button");
//		JButton btnNewButton_2 = new JButton("New button");
//		mainFrame.getContentPane().add(btnNewButton_1, BorderLayout.SOUTH);
		
		JPanel panelAbajo = new JPanel();
		
		getMainFrame().getContentPane().add(panelAbajo, BorderLayout.SOUTH); //añado
		panelAbajo.setLayout(new GridLayout(1, 4, 30, 10));
		
//		panelAbajo.add(btnNewButton_1);
//		panelAbajo.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("  Puntuacion:");
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelAbajo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		panelAbajo.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Terminar");
		btnNewButton_1.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panelAbajo.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cambiar");
		btnNewButton_2.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panelAbajo.add(btnNewButton_2);

		
		JButton btnNewButton_3 = new JButton("New button");
		getMainFrame().getContentPane().add(btnNewButton_3, BorderLayout.CENTER);
		
	
		
//		java.net.URL url = VistaJuego.class.getResource("/gif.gif");
//		ImageIcon imageIcon = new ImageIcon(url);
//		JLabel label1 = new JLabel(imageIcon);
//		label1.setVerticalAlignment(SwingConstants.TOP);
		JLabel label1 = new JLabel("Lights Outs");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Snap ITC", Font.PLAIN, 34));
		getMainFrame().getContentPane().add(label1, BorderLayout.NORTH);
		}

	public JFrame getMainFrame() {
		return mainFrame;
	}
}

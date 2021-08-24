package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;

public class Menu {

	private JFrame FrameMenu;
	private JTextField nombreUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.FrameMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		FrameMenu = new JFrame();
		FrameMenu.getContentPane().setBackground(new Color(0, 0, 51));
		FrameMenu.setBounds(100, 100, 450, 300);
		FrameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameMenu.getContentPane().setLayout(null);
		
		
		//botones
		Button btn_verHistorial = new Button("Historial");
		btn_verHistorial.setBounds(10, 204, 70, 22);
		FrameMenu.getContentPane().add(btn_verHistorial);
		
		Button btn_jugar = new Button("Jugar");
		btn_jugar.setEnabled(false);
		btn_jugar.setBounds(10, 156, 70, 22);
		FrameMenu.getContentPane().add(btn_jugar);
		
		JLabel labelRecordMaximo = new JLabel("Record maximo:");
		labelRecordMaximo.setFont(new Font("Menlo", Font.BOLD, 11));
		labelRecordMaximo.setForeground(UIManager.getColor("Button.background"));
		labelRecordMaximo.setBounds(173, 206, 133, 20);
		FrameMenu.getContentPane().add(labelRecordMaximo);
		
		JLabel labelUsuario = new JLabel("Ingrese usuario");
		labelUsuario.setForeground(UIManager.getColor("Button.background"));
		labelUsuario.setFont(new Font("Menlo", Font.BOLD, 13));
		labelUsuario.setBounds(10, 37, 153, 32);
		FrameMenu.getContentPane().add(labelUsuario);

		nombreUsuario = new JTextField();
		nombreUsuario.setFont(new Font("Menlo", Font.BOLD, 12));
		nombreUsuario.setBackground(Color.GRAY);
		nombreUsuario.setForeground(Color.WHITE);
		nombreUsuario.setBounds(173, 44, 192, 20);
		FrameMenu.getContentPane().add(nombreUsuario);
		nombreUsuario.setColumns(10);

		JLabel labelSeleccionaGrilla = new JLabel("Seleccione grilla:");
		labelSeleccionaGrilla.setForeground(SystemColor.menu);
		labelSeleccionaGrilla.setFont(new Font("Menlo", Font.BOLD, 13));
		labelSeleccionaGrilla.setBounds(10, 88, 153, 32);
		FrameMenu.getContentPane().add(labelSeleccionaGrilla);

		JRadioButton btnRadioCuatro = new JRadioButton("4");
		btnRadioCuatro.setBackground(new Color(153, 153, 153));
		btnRadioCuatro.setBounds(173, 94, 43, 23);
		FrameMenu.getContentPane().add(btnRadioCuatro);

		JRadioButton btnRadioCinco = new JRadioButton("5");
		btnRadioCinco.setBackground(new Color(153, 153, 153));
		btnRadioCinco.setBounds(246, 94, 43, 23);
		FrameMenu.getContentPane().add(btnRadioCinco);
		
		//imagen background menu
		ImageIcon backgroundImageMenu = new ImageIcon(this.getClass().getResource("/backgroundMenu.jpg"));
		JLabel contenedorImg = new JLabel("");
		contenedorImg.setVerticalAlignment(SwingConstants.BOTTOM);
		contenedorImg.setIcon(backgroundImageMenu);
		contenedorImg.setBounds(0, 0, 434, 261);
		FrameMenu.getContentPane().add(contenedorImg);		
	
		
		
		
		
	}
}

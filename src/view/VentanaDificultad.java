package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;

public class VentanaDificultad extends JFrame {
	private JPanel contentPanel;
	private JFrame ventanaDif;
	private JButton btnNormal;
	private JButton btnDificil;
	private JLabel lblTitulo;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDificultad frame = new VentanaDificultad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaDificultad() {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int anchoPantallaPC = tamanoPantalla.width;
		int alto = tamanoPantalla.height;
		
		ventanaDif= new JFrame();
		ventanaDif.getContentPane().setBackground(new Color(0, 153, 153));
		ventanaDif.setBackground(Color.WHITE);
		ventanaDif.setBounds(anchoPantallaPC/2-175, alto/2-140, 350, 280);
		
		contentPanel = new JPanel();
		setBounds(100, 100, 347, 280);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		ventanaDif.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Seleccione la dificultad");
		lblTitulo.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblTitulo.setBounds(49, 37, 232, 30);
		ventanaDif.getContentPane().add(lblTitulo);
				
				
		//Boton dificultad dificil
		btnDificil = new JButton("Dificil");
		btnDificil.setPreferredSize(new Dimension(75, 25));
		btnDificil.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		btnDificil.setBackground(new Color(255, 255, 255));
		btnDificil.setBounds(115, 154, 100, 30);
		ventanaDif.getContentPane().add(btnDificil);
		
		//Boton dificultad normal
		btnNormal = new JButton("Normal");
		btnNormal.setPreferredSize(new Dimension(75, 25));
		btnNormal.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		btnNormal.setBackground(new Color(255, 255, 255));
		btnNormal.setBounds(115, 102, 100, 30);
		ventanaDif.getContentPane().add(btnNormal);
	
	}
		
	public JButton getBtnNormal() {
		return btnNormal;
	}

	public void setBtnNormal(JButton btnNormal) {
		this.btnNormal = btnNormal;
	}

	public JButton getBtnDificil() {
		return btnDificil;
	}

	public void setBtnDificil(JButton btnDificil) {
		this.btnDificil = btnDificil;
	}

	public void show() {
		this.ventanaDif.setVisible(true);
	}
	
	public void ocultar() {
		this.ventanaDif.dispose();
	}

}

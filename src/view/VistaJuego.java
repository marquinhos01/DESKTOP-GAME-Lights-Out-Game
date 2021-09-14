package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Modelo.Juego;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;
import java.awt.Rectangle;

public class VistaJuego extends Tamanios {

	private JFrame mainFrame;
	private JTable grillaVista;
	private JPanel panelAbajo;
	private JLabel labelPuntuacion;
	private JLabel labelpPuntuacionActualizar;
	private JLabel labelTitulo;
	private JButton btnTerminar;
	private JButton btnCambiarGrilla;
	private DefaultTableModel model;
	private JLabel labelImagenFocoApagado;
	private ImageIcon iconoFocoPrendido;
	private ImageIcon iconoFocoApagado;
	private JLabel labelImagenFocoPrendido;

	public VistaJuego() {
		super();
		initialize();
	}

	public void initialize() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit(); // devuelve un objeto toolkit ya que es abstracto, devuelve la
															// ventana
		Dimension tamanoPantalla = miPantalla.getScreenSize(); // la resolucion de la
	
		int anchoPantallaPC = tamanoPantalla.width;
		int alto = tamanoPantalla.height;
		mainFrame = new JFrame();
		mainFrame.getContentPane().setBackground(new Color(204, 255, 255));

		getMainFrame().setBackground(Color.BLACK);

		getMainFrame().setBounds(anchoPantallaPC / 4, 0, anchoPantallaPC / 2, alto - 50);

		getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);

		panelAbajo = new JPanel();
		panelAbajo.setBounds(new Rectangle(0, 639, 667, 40));
		panelAbajo.setForeground(Color.BLUE);
		panelAbajo.setBackground(new Color(0, 153, 153));
		getMainFrame().getContentPane().add(panelAbajo);
		panelAbajo.setLayout(new GridLayout(1, 4, 30, 10));

		labelPuntuacion = new JLabel("Movimientos:");
		labelPuntuacion.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		labelPuntuacion.setHorizontalAlignment(SwingConstants.RIGHT);
		panelAbajo.add(labelPuntuacion);

		labelpPuntuacionActualizar = new JLabel("0");
		labelpPuntuacionActualizar.setHorizontalAlignment(SwingConstants.LEFT);
		labelpPuntuacionActualizar.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panelAbajo.add(labelpPuntuacionActualizar);

		btnTerminar = new JButton("Terminar");
		btnTerminar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnTerminar.setPreferredSize(new Dimension(75, 40));
		btnTerminar.setBackground(Color.WHITE);
		btnTerminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnTerminar.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panelAbajo.add(btnTerminar);

		btnCambiarGrilla = new JButton("Cambiar");
	
		btnCambiarGrilla.setBackground(Color.WHITE);
		btnCambiarGrilla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnCambiarGrilla.setPreferredSize(new Dimension(71, 40));
		btnCambiarGrilla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCambiarGrilla.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panelAbajo.add(btnCambiarGrilla);

		labelTitulo = new JLabel("Lights Outs");
		labelTitulo.setBounds(0, 25, 667, 45);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Snap ITC", Font.PLAIN, 34));
		getMainFrame().getContentPane().add(labelTitulo);

		grillaVista = new JTable() { // evita que se editen las celdas al tocar click
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;

			}

		};
		grillaVista.setBounds(8, 93, 650, 480);
		grillaVista.setBackground(new Color(0, 153, 153));
		grillaVista.setRowHeight(120);
		grillaVista.setFont(new Font("Tahoma", Font.PLAIN, 54));

		mainFrame.getContentPane().add(grillaVista);

		model = (DefaultTableModel) grillaVista.getModel();
		grillaVista.setDefaultRenderer(Object.class, new RenderizadorImg());

		labelImagenFocoApagado = new JLabel(); // aca meto las imagenes
		labelImagenFocoPrendido = new JLabel(); // aca meto las imagenes

		Image imagenFocoPrendido = new ImageIcon(getClass().getResource("/focoPrendido.png")).getImage();
		Image imagenFocoApagado = new ImageIcon(getClass().getResource("/focoApagado.png")).getImage();

		Image imagenFocoPrendidoEscalada = imagenFocoPrendido.getScaledInstance(super.getAnchoFrame(mainFrame) /5,
				grillaVista.getRowHeight(), java.awt.Image.SCALE_SMOOTH);
		Image imagenFocoApagadoEscalada = imagenFocoApagado.getScaledInstance(super.getAnchoFrame(mainFrame) / 5,
				grillaVista.getRowHeight(), java.awt.Image.SCALE_SMOOTH);

		iconoFocoPrendido = new ImageIcon(imagenFocoPrendidoEscalada);
		iconoFocoApagado = new ImageIcon(imagenFocoApagadoEscalada);

	}
	
	public void tamanioGrilla(int i) {
		grillaVista.setRowHeight(480/i);
		model.setColumnCount(i);
		model.setRowCount(i);
	}
	
	public void actualizarPuntaje(Juego j) {
		labelpPuntuacionActualizar.setText(j.getStringPuntaje());
	}

	public void cambiarImagenesFocoPrendido(int i, int j) {
		labelImagenFocoPrendido.setIcon(iconoFocoPrendido);
		grillaVista.setValueAt(labelImagenFocoPrendido, i, j);
	}

	public void cambiarImagenesFocoApagado(int i, int j) {
		labelImagenFocoApagado.setIcon(iconoFocoApagado);
		grillaVista.setValueAt(labelImagenFocoApagado, i, j);
	}

	public ImageIcon getIconoFocoPrendido() {
		return iconoFocoPrendido;
	}

	public ImageIcon getIconoFocoApagado() {
		return iconoFocoApagado;
	}

	public JTable getGrillaVista() {
		return grillaVista;
	}

	public JLabel getLabelPuntuacion() {
		return labelPuntuacion;
	}

	public void setLabelPuntuacion(JLabel labelPuntuacion) {
		this.labelPuntuacion = labelPuntuacion;
	}

	public JLabel getLabelpPuntuacionActualizar() {
		return labelpPuntuacionActualizar;
	}

	public void setLabelpPuntuacionActualizar(JLabel labelpPuntuacionActualizar) {
		this.labelpPuntuacionActualizar = labelpPuntuacionActualizar;
	}

	public JButton getBtnTerminar() {
		return btnTerminar;
	}

	public JButton getBtnCambiarGrilla() {
		return btnCambiarGrilla;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void show() {
		this.mainFrame.setVisible(true);
	}
	
    public void ocultar() {
		this.mainFrame.dispose();
	}

}

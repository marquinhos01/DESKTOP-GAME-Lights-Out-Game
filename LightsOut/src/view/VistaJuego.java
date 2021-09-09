package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Modelo.Grilla;
import controlador.IniciarJuego;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		mainFrame.getContentPane().setBackground(SystemColor.activeCaption);

		getMainFrame().setBackground(Color.BLACK);

		getMainFrame().setBounds(anchoPantallaPC / 4, 0, anchoPantallaPC / 2, alto - 50);

		getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getMainFrame().getContentPane().setLayout(new BorderLayout(20, 40));

		panelAbajo = new JPanel();
		panelAbajo.setBackground(SystemColor.textHighlight);
		getMainFrame().getContentPane().add(panelAbajo, BorderLayout.SOUTH);
		panelAbajo.setLayout(new GridLayout(1, 4, 30, 10));

		labelPuntuacion = new JLabel("Movimientos:");
		labelPuntuacion.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		labelPuntuacion.setHorizontalAlignment(SwingConstants.RIGHT);
		panelAbajo.add(labelPuntuacion);

		labelpPuntuacionActualizar = new JLabel(IniciarJuego.getStringPuntaje());
		labelpPuntuacionActualizar.setHorizontalAlignment(SwingConstants.LEFT);
		labelpPuntuacionActualizar.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panelAbajo.add(labelpPuntuacionActualizar);

		btnTerminar = new JButton("Terminar");
		
		btnTerminar.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panelAbajo.add(btnTerminar);

		btnCambiarGrilla = new JButton("Cambiar");
		btnCambiarGrilla.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		panelAbajo.add(btnCambiarGrilla);

		labelTitulo = new JLabel("Lights Outs");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Snap ITC", Font.PLAIN, 34));
		getMainFrame().getContentPane().add(labelTitulo, BorderLayout.NORTH);

		grillaVista = new JTable(4, 4) { // evita que se editen las celdas al tocar click
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;

			}

		};

		grillaVista.setBackground(Color.WHITE);
		grillaVista.setCellSelectionEnabled(true);
		grillaVista.setRowHeight(120);
		grillaVista.setFont(new Font("Tahoma", Font.PLAIN, 54));

		mainFrame.getContentPane().add(grillaVista, BorderLayout.CENTER);

		model = (DefaultTableModel) grillaVista.getModel();
		grillaVista.setDefaultRenderer(Object.class, new RenderizadorImg());

		labelImagenFocoApagado = new JLabel(); // aca meto las imagenes
		labelImagenFocoPrendido = new JLabel(); // aca meto las imagenes

		Image imagenFocoPrendido = new ImageIcon(getClass().getResource("/focoPrendido.png")).getImage();
		Image imagenFocoApagado = new ImageIcon(getClass().getResource("/focoApagado.png")).getImage();

		Image imagenFocoPrendidoEscalada = imagenFocoPrendido.getScaledInstance(super.getAnchoFrame(mainFrame) / 4,
				grillaVista.getRowHeight(), java.awt.Image.SCALE_SMOOTH);
		Image imagenFocoApagadoEscalada = imagenFocoApagado.getScaledInstance(super.getAnchoFrame(mainFrame) / 4,
				grillaVista.getRowHeight(), java.awt.Image.SCALE_SMOOTH);

		iconoFocoPrendido = new ImageIcon(imagenFocoPrendidoEscalada);
		iconoFocoApagado = new ImageIcon(imagenFocoApagadoEscalada);

	}
	
	public void actualizarPuntaje() {
		labelpPuntuacionActualizar.setText(IniciarJuego.getStringPuntaje());
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

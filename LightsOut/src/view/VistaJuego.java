package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Modelo.Grilla;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaJuego {

	private JFrame mainFrame;
	private JTable grillaVista;
	private JPanel panelAbajo;
	private JLabel labelPuntuacion;
	private JLabel labelpPuntuacionActualizar;
	private JLabel labelTitulo;
	private JButton btnTerminar;
	private JButton btnCambiarGrilla;


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
		initialize();
	}


	public void initialize() {
		Toolkit miPantalla = Toolkit.getDefaultToolkit(); // devuelve un objeto toolkit ya que es abstracto, devuelve la
															// ventana
		Dimension tamanoPantalla = miPantalla.getScreenSize(); // la resolucion de la
		// pantalla pc 1200x2320
		int anchoPantallaPC = tamanoPantalla.width;
		int alto = tamanoPantalla.height;
		mainFrame = new JFrame();
		getMainFrame().setBackground(Color.BLACK);
//		getMainFrame().setSize(tamanoPantalla);
//		getMainFrame().setBounds(anchoPantallaPC/4, 0, anchoPantallaPC/2,
//				alto - 50);
		mainFrame.setBounds(100, 100, 650, 700);
		getMainFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getMainFrame().getContentPane().setLayout(new BorderLayout(20, 40));

		panelAbajo = new JPanel();
		getMainFrame().getContentPane().add(panelAbajo, BorderLayout.SOUTH);
		panelAbajo.setLayout(new GridLayout(1, 4, 30, 10));

		labelPuntuacion = new JLabel("  Puntuacion:");
		labelPuntuacion.setFont(new Font("Snap ITC", Font.PLAIN, 18));
		labelPuntuacion.setHorizontalAlignment(SwingConstants.LEFT);
		panelAbajo.add(labelPuntuacion);

		labelpPuntuacionActualizar = new JLabel("2");
		labelpPuntuacionActualizar.setFont(new Font("Snap ITC", Font.PLAIN, 20));
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

		grillaVista = new JTable(4, 4);
		grillaVista.setCellSelectionEnabled(true);
		grillaVista.setRowHeight(120);
		grillaVista.setFont(new Font("Tahoma", Font.PLAIN, 54));

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();

		Grilla n = new Grilla();
		n.iniciarGrilla();

		mainFrame.getContentPane().add(grillaVista, BorderLayout.CENTER);
		DefaultTableModel model = (DefaultTableModel) grillaVista.getModel();

//		grillaVista.addMouseListener(new java.awt.event.MouseAdapter() {
//				@Override
//			public void mouseClicked(java.awt.event.MouseEvent evt) {
//				for (int i = 0; i < n.casillas.length; i++) {
//					for (int j = 0; j < n.casillas.length; j++) {
//						int row = grillaVista.rowAtPoint(evt.getPoint());
//						int col = grillaVista.columnAtPoint(evt.getPoint());
//
//						if (row == i && col == j) {
//							n.cambiarEstadoGrilla(i, j);
//							if (n.estadoCasilla(i, j)) {
//								dtcr.setBackground(Color.RED);
//								System.out.println("esta en true");
//							} else if (n.estadoCasilla(i, j) == false)
//								System.out.println("esta en false");
//							System.out.println(n.toString());
////							System.out.println(i + " " + j);
//						}
//					}
//
//				}
//
//			}
//
//		});

		// meter un boton en alguna casilla de la tabla
		// 2 2
//		JButton aceptar = new JButton("Aceptar");
//		
//		aceptar.setBackground(Color.BLACK);
//		aceptar.setSelectedIcon(new ImageIcon("C:\\Users\\marco\\Desktop\\foco.png"));
//		aceptar.setFont(new Font("Snap ITC", Font.PLAIN, 18));
//		grillaVista.add(aceptar);
//		model.setValueAt(aceptar, 2, 2);

//		for (int i = 0; i < n.casillas.length; i++) {
//			for (int j = 0; j < n.casillas.length; j++) {
//				model.setValueAt(new JButton("boton"), i, j);
//				
//			}
//						
//		}
		grillaVista.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {

			}
		});

		System.out.println(n.toString());

	}

	public JTable getGrillaVista() {
		return grillaVista;
	}

	public void setGrillaVista(JTable grillaVista) {
		this.grillaVista = grillaVista;
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

	public void setBtnTerminar(JButton btnTerminar) {
		this.btnTerminar = btnTerminar;
	}

	public JButton getBtnCambiarGrilla() {
		return btnCambiarGrilla;
	}

	public void setBtnCambiarGrilla(JButton btnCambiarGrilla) {
		this.btnCambiarGrilla = btnCambiarGrilla;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}
}

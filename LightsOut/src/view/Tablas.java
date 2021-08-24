package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Tablas {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablas window = new Tablas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tablas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		scrollPane.setBounds(10, 11, 400, 250);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		//creamos el modelo
		DefaultTableModel model = new DefaultTableModel(); 
		//agregamos las columnas
		model.addColumn("DNI");
		model.addColumn("Nombre");
		model.addColumn("Domicilio");
		//agregamos las filas
		model.addRow(new String[]{"45307940","Marcos" ,"Alfredo Palacio",});
		model.addRow(new String[]{"15307940","Juan" ,"San miguel",});
		model.addRow(new String[]{"25307940","Lucia" ,"Grand Bourg",});
		//al final incorporamos el modelo a la tabla
				table.setModel(model);
		
	}
	
}

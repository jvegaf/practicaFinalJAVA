package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import dao.DAOManager;
import model.ProfesorTableModel;
import javax.swing.JButton;

public class ProfesorFrame extends JFrame {

	private JPanel contentPane;
	private JTable profesorTabla;
	private DAOManager manager;
	private JButton btnAgregar;


	/**
	 * Create the frame.
	 */
	public ProfesorFrame(DAOManager man) {
		this.manager = man;
		ProfesorTableModel ptm = new ProfesorTableModel(manager.getProfesorDAO());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnAgregar = new JButton("Agregar");
		toolBar.add(btnAgregar);
		profesorTabla = new JTable();
		profesorTabla.setModel(ptm);
		JScrollPane scrollPane = new JScrollPane(profesorTabla);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
	}

}

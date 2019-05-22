package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.DAOException;
import dao.DAOManager;
import model.AlumnoTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class AlumnoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaAlumnos;
	private AlumnoTableModel alumnoTM;
	private DAOManager manager;
	private JScrollPane scrollPane;
	private JToolBar toolBar;
	private JButton btnAgregar;
	
	
	

	/**
	 * Create the frame.
	 * @throws DAOException 
	 */
	public AlumnoFrame(DAOManager man) throws DAOException {
		this.manager = man;
		this.alumnoTM = new AlumnoTableModel(this.manager.getAlumnoDAO());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		tablaAlumnos = new JTable();
		tablaAlumnos.setCellSelectionEnabled(true);
		tablaAlumnos.setModel(alumnoTM);
		
		tablaAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(new JScrollPane(tablaAlumnos), BorderLayout.CENTER);
		
		toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnAgregar = new JButton("Agregar");
		toolBar.add(btnAgregar);
	}

}

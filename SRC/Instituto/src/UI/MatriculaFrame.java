package UI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import dao.DAOException;
import dao.DAOManager;
import model.MatriculaTableModel;

public class MatriculaFrame extends JFrame {

	private JPanel contentPane;
	private DAOManager dm;
	private JTable matriculaTabla;

	/**
	 * Create the frame.
	 */
	public MatriculaFrame(DAOManager man) throws DAOException {
		this.dm = man;
		MatriculaTableModel mtm = new MatriculaTableModel(this.dm.getMatriculaDAO(), this.dm.getAsignaturaDAO());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnAgregar = new JButton("Agregar");
		toolBar.add(btnAgregar);
		
		matriculaTabla = new JTable();
		matriculaTabla.setModel(mtm);
		
		JScrollPane scrollPane = new JScrollPane(matriculaTabla);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

}

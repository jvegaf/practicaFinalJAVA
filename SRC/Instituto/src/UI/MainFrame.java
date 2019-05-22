package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JButton btnAlumnos = new JButton("Alumnos");
		contentPane.add(btnAlumnos);
		
		JButton btnProfesores = new JButton("Profesores");
		contentPane.add(btnProfesores);
		
		JButton btnAsignaturas = new JButton("Asignaturas");
		contentPane.add(btnAsignaturas);
		
		JButton btnMatriculas = new JButton("Matriculas");
		contentPane.add(btnMatriculas);
	}
}

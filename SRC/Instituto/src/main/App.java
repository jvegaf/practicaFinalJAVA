package main;

import java.awt.EventQueue;

import UI.AlumnoFrame;
import dao.DAOManager;

public class App {

	public static void main(String[] args) {
		
		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlumnoFrame frame = new AlumnoFrame(new DAOManager("localhost", "usuario", "password", "BD_INSTITUTO"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

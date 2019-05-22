package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.AsignaturaDAO;
import dao.DAOException;
import dao.ProfesorDAO;

public class AsignaturaTableModel extends AbstractTableModel{

	private  AsignaturaDAO asDAO;
	private List<Asignatura> datos = new ArrayList<Asignatura>();
	private String[] columnas = {"Id", "Nombre", "Precio", "Profesor"};
	
	public AsignaturaTableModel(AsignaturaDAO pd) {
		this.asDAO = pd;
	}
	
	
	public void updateModel()  throws DAOException{
		datos = this.asDAO.obtenerTodos();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnas[col];
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return datos.size();
	}

	@Override
	public Object getValueAt(int col, int row) {
		Asignatura as = datos.get(row);
		switch (col) {
		case 0:
			return as.getCodAsignatura();
		case 1:
			return as.getNombre();
		case 2:
			return as.getPrecio();
		case 3:
			// TODO : cambiar el codigo por el nombre del profesor
			return as.getCodProfesor();
		default:
			return "";
		}
	}

}

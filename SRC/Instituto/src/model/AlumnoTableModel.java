package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.AlumnoDAO;
import dao.DAOException;

public class AlumnoTableModel extends AbstractTableModel{


	private static final long serialVersionUID = 1L;
	private AlumnoDAO alumnoDAO;
	private List<Alumno> datos = new ArrayList<Alumno>();
	private String[] columnas = {"Id","Nombre", "Primer Apellido", "Segundo Apellido", "DNI" };
	
	public AlumnoTableModel(AlumnoDAO dao) throws DAOException {
		this.alumnoDAO = dao;
		this.updateModel();
	}
	
	public void updateModel() throws DAOException {
		datos = alumnoDAO.obtenerTodos();
	}
	
	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Alumno al = datos.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return al.getCodigo().toString();
		case 1:
			return al.getNombre();
		case 2:
			return al.getApellido1();
		case 3:
			return al.getApellido2();
		case 4:
			return al.getDni();
		default:
			return "";
		}
	}

}

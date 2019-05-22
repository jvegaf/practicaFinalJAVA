package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.AsignaturaDAO;
import dao.DAOException;
import dao.MatriculaDAO;

public class MatriculaTableModel extends AbstractTableModel{

	private List<Matricula> datos = new ArrayList<>();
	private MatriculaDAO md;
	private AsignaturaDAO ad;
	private String[] columnas = {"Id", "Alumno", "Asignatura", "Curso", "Nota"};
	
	
	public MatriculaTableModel(MatriculaDAO md, AsignaturaDAO pd) {
		this.md = md;
		this.ad = pd;
		this.updateModel();
	}
	
	public void updateModel() throws DAOException {
		datos = md.obtenerTodos();
	}
	
	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return columnas[arg0];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}
	
	private String obtenAsignatura(int codigo) throws DAOException {
		Asignatura a = ad.obtener(codigo);
		return a.getNombre();
	}

	@Override
	public Object getValueAt(int col, int row) {
		Matricula m = datos.get(row);
		switch (col) {
		case 0:
			return String.valueOf(m.getCodigo());
		case 1:
			return m.getAlumno();
		case 2:
			try {
				return  this.obtenAsignatura(m.getAsignatura());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case 3:
			return String.valueOf(m.getYear());
		case 4:
			return m.getNota();
		default:
			return "";
		}
	}

}
 
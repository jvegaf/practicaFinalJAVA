package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.ProfesorDAO;

public class ProfesorTableModel  extends AbstractTableModel {

	private List<Profesor> datos = new ArrayList<>();
	private ProfesorDAO pd;
	private String[] columnas = {"Id", "Nombre", "Primer Apellido", "Segundo Apellido", "DNI"};
	
	
	public ProfesorTableModel(ProfesorDAO pd) {
		this.pd = pd;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnas[column];
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		Profesor p = datos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getCodigo();
		case 1:
			return p.getNombre();
		case 2: 
			return p.getApellido1();
		case 3:
			return p.getApellido2();
		case 4:
			return p.getDni();
		default:
			return "";
		}
	}
}

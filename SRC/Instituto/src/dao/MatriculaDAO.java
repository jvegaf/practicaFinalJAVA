package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Matricula;

public class MatriculaDAO implements DAO<Matricula, Integer>{
	
	private Connection conn;
	
	private final String INSERT = "INSERT IN TO MATRICULA ( CODIGO_ALUMNO, CODIGO_ASIGNATURA, CODIGO_PROFESOR, YEAR) VALUES( ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE MATRICULA SET CODIGO_ALUMNO = ?, CODIGO_ASIGNATURA = ?, CODIGO_PROFESOR = ?, YEAR = ?,  NOTA = ? WHERE CODIGO_MATRICULA = ?";
	private final String DELETE = "DELETE FROM MATRICULA WHERE CODIGO_MATRICULA = ?";
	private final String GETALL = "SELECT CODIGO_MATRICULA, CODIGO_ALUMNO, CODIGO_ASIGNATURA, CODIGO_PROFESOR, YEAR, NOTA FROM MATRICULA";
	private final String GETONE = "SELECT CODIGO_ALUMNO, CODIGO_ASIGNATURA, CODIGO_PROFESOR, YEAR, NOTA FROM MATRICULA WHERE CODIGO_MATRICULA = ?";
	private final String GETCODPROFESOR = "SELECT CODIGO_PROFESOR FROM ASIGNATURA WHERE CODIGO_ASIGNATURA = ?";
	
	public MatriculaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Matricula m) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setInt(1, m.getAlumno());
			stat.setInt(2, m.getAsignatura());
			stat.setInt(3, this.codigoProfesor(m.getAsignatura()));
			stat.setInt(4, m.getYear());
			if(stat.executeUpdate()==0) {
				throw new DAOException("puede que no se haya guardado");
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL", e);
		} finally {
			if(stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
	}

	@Override
	public void modificar(Matricula m) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setInt(1, m.getAlumno());
			stat.setInt(2, m.getAsignatura());
			stat.setInt(3, this.codigoProfesor(m.getAsignatura()));
			stat.setInt(4, m.getYear());
			stat.setInt(5, m.getNota());
			stat.setInt(6, m.getNota());
			if (stat.executeUpdate()==0) {
				throw new DAOException("puede que no se haya guardado");
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL",e);
		} finally {
			if(stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
	}

	@Override
	public void eliminar(Matricula m) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE);
			stat.setInt(1, m.getCodigo());
			if (stat.executeUpdate()==0) {
				throw new DAOException("puede que no se haya borrado");
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL", e);
		} finally {
			if (stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
		
	}

	@Override
	public List<Matricula> obtenerTodos() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Matricula> matriculas = new ArrayList<Matricula>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while (rs.next()) {
				matriculas.add(convierte(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL", e);
		}
		return matriculas;
	}

	@Override
	public Matricula obtener(Integer id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Matricula mat = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if (rs.next()) {
				mat = convierte(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL", e);
		}
		return mat;
	}

	private Integer codigoProfesor(int codigoAsigntura) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Integer codigoProfesor = null; 
		try {
			stat = conn.prepareStatement(GETCODPROFESOR);
			stat.setInt(1, codigoAsigntura);
			rs = stat.executeQuery();
			if(rs.next()) {
				codigoProfesor = rs.getInt("CODIGO_PROFESOR");
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL", e);
		} finally {
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
			if (stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
		return codigoProfesor;
	}
	
	private Matricula convierte(ResultSet rs) throws SQLException {
		int codigo = rs.getInt("CODIGO_MATRICULA");
		int alumno = rs.getInt("CODIGO_ALUMNO");
		int asignatura = rs.getInt("CODIGO_ASIGNATURA");
		int year = rs.getInt("YEAR");
		int nota = rs.getInt("NOTA");
		return new Matricula(codigo, alumno, asignatura, year, nota);
	}
	
}

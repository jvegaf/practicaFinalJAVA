package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Alumno;

public class AlumnoDAO implements DAO<Alumno, Integer>{
	
	private Connection conn;
	
	private final String INSERT = "INSERT IN TO ALUMNO(NOMBRE_ALUMNO, "
			+ "APELLIDO1_ALUMNO, APELLIDO2_ALUMNO, DI_ALUMNO) VALUES (?, ?, ?, ?)";
	
	private final String UPDATE = "UPDATE ALUMNO SET NOMBRE_ALUMNO = ?, APELLIDO1_ALUMNO = ?"
			+ "APELLIDO2_ALUMNO = ?, DI_ALUMNO = ? WHERE CODIGO_ALUMNO = ?";
	
	private final String DELETE = "DELETE FROM ALUMNO WHERE CODIGO_ALUMNO = ?";
	
	private final String GETALL = "SELECT CODIGO_ALUMNO, NOMBRE_ALUMNO, "
			+ "APELLIDO1_ALUMNO, APELLIDO2_ALUMNO, DI_ALUMNO FROM ALUMNO";
	
	private final String GETONE = "SELECT NOMBRE_ALUMNO, APELLIDO1_ALUMNO, "
			+ "APELLIDO2_ALUMNO, DI_ALUMNO FROM ALUMNO WHERE CODIGO_ALUMNO = ?";
	
	
	
	public AlumnoDAO(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insertar(Alumno a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = (PreparedStatement) conn.prepareStatement(INSERT);
			stat.setString(1, a.getNombre());
			stat.setString(2, a.getApellido1());
			stat.setString(3, a.getApellido2());
			stat.setString(4, a.getDni());
			if(stat.executeUpdate()== 0) {
				throw new DAOException("Puede que no se haya guardado");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en SQL", e);
		}finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					new DAOException("Error en el SQL", e);
				}
			}
		}
	}

	@Override
	public void modificar(Alumno a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = (PreparedStatement) conn.prepareStatement(UPDATE);
			stat.setString(1, a.getNombre());
			stat.setString(2, a.getApellido1());
			stat.setString(3, a.getApellido2());
			stat.setString(4, a.getDni());
			stat.setInt(5, a.getCodigo());
			if(stat.executeUpdate()== 0) {
				throw new DAOException("Puede que no se haya actualizado");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en el SQL", e);
		}finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					new DAOException("Error en el SQL", e);
				}
			}
		}
	}

	@Override
	public void eliminar(Alumno a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = (PreparedStatement) conn.prepareStatement(DELETE);
			stat.setInt(1, a.getCodigo());
			if(stat.executeUpdate()== 0) {
				throw new DAOException("Puede que no se haya borrado");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en el SQL",e);
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					new DAOException("Error en el SQL", e);
				}
			}
		}
	}
	
	private Alumno convertir(ResultSet rs) throws SQLException {
		Integer codigo = rs.getInt("CODIGO_ALUMNO");
		String nombre = rs.getString("NOMBRE_ALUMNO");
		String apellido1 = rs.getString("APELLIDO1_ALUMNO");
		String apellido2 = rs.getString("APELLIDO2_ALUMNO");
		String dni = rs.getString("DI_ALUMNO");
		return new Alumno(codigo, nombre, apellido1, apellido2, dni);
	}

	@Override
	public List<Alumno> obtenerTodos() throws DAOException {
		ResultSet rs = null;
		PreparedStatement stat = null;
		List<Alumno> alumnos = new ArrayList<>();
		try {
			stat = (PreparedStatement) conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while(rs.next()) {
				alumnos.add(convertir(rs)); 
			}
		}catch (SQLException ex) {
			throw new DAOException("error en el SQL", ex);
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
			if(stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
		return alumnos;
	}

	@Override
	public Alumno obtener(Integer id) throws DAOException {
		PreparedStatement stat = null;
		Alumno a = null;
		ResultSet rs = null;
		try {
			stat = (PreparedStatement) conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next()) {
				a = this.convertir(rs);
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
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("Error en el SQL", e);
				}
			}
		}
		return a;
	}
}

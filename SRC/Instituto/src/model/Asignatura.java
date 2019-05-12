package model;

public class Asignatura {
	private Integer codAsignatura;
    private String nombre;
    private Integer precio;
    private Integer codProfesor;
	
    public Asignatura(){}
    
    public Asignatura(Integer codAsignatura, String nombre, Integer precio, Integer codProfesor) {
		super();
		this.codAsignatura = codAsignatura;
		this.nombre = nombre;
		this.precio = precio;
		this.codProfesor = codProfesor;
	}

	public Integer getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(Integer codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getCodProfesor() {
		return codProfesor;
	}

	public void setCodProfesor(Integer codProfesor) {
		this.codProfesor = codProfesor;
	}

	@Override
	public String toString() {
		return "Asignatura [codAsignatura=" + codAsignatura + ", nombre=" + nombre + ", precio=" + precio
				+ ", codProfesor=" + codProfesor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAsignatura == null) ? 0 : codAsignatura.hashCode());
		result = prime * result + ((codProfesor == null) ? 0 : codProfesor.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (codAsignatura == null) {
			if (other.codAsignatura != null)
				return false;
		} else if (!codAsignatura.equals(other.codAsignatura))
			return false;
		if (codProfesor == null) {
			if (other.codProfesor != null)
				return false;
		} else if (!codProfesor.equals(other.codProfesor))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}
    
    
    
}

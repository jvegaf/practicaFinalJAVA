package model;

public class Alumno {
    /**
     * Propiedades
     */
	
    private Integer codigo = null;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
	
    
    
    public Alumno() {}

	public Alumno(Integer codigo, String nombre, String apellido1, String apellido2, String dni) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
	}
	
	/**
     * getters / setters
     */
    
    public Integer getCodigo() {
    	return codigo;
    }
    
    
    public void setCodigo(Integer codigo) {
    	this.codigo = codigo;
    }
    
    
    public String getNombre() {
    	return nombre;
    }
    
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    
    public String getApellido1() {
    	return apellido1;
    }
    
    
    public void setApellido1(String apellido1) {
    	this.apellido1 = apellido1;
    }
    
    
    public String getApellido2() {
    	return apellido2;
    }
    
    
    public void setApellido2(String apellido2) {
    	this.apellido2 = apellido2;
    }
    
    
    public String getDni() {
    	return dni;
    }
    
    
    public void setDni(String dni) {
    	this.dni = dni;
    };
    

	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", dni=" + dni + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
		result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Alumno other = (Alumno) obj;
		if (apellido1 == null) {
			if (other.apellido1 != null)
				return false;
		} else if (!apellido1.equals(other.apellido1))
			return false;
		if (apellido2 == null) {
			if (other.apellido2 != null)
				return false;
		} else if (!apellido2.equals(other.apellido2))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}  
}

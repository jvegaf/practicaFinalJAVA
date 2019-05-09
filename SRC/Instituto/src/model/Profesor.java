package model;

public class Profesor {

	private int cod;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	
	/*
	 * getters & setters
	 */
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
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
	}
	
	/**
	 * constructor
	 */
	
	public Profesor(){};

	public Profesor(int cod, String nombre, String apellido1, String apellido2, String dni) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
	}
}

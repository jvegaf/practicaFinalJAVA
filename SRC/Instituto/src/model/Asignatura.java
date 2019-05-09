package model;

public class Asignatura {
	private int codAsignatura;
    private String nombre;
    private int precio;
    private int codProfesor;

    /**
     * getters & setters
     */
    
    public int getCodAsignatura() {
    	return this.codAsignatura;
    }
    
    public void setCodAsignatura(int cod) {
    	this.codAsignatura = cod;
    }
    
    public int getCodProfesor() {
    	return this.codProfesor;
    }
    
    public void setCodProfesor(int cp) {
    	this.codProfesor = cp;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getPrecio(){
        return this.precio;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    /**
     * Contructores
     */

    public Asignatura(){

    }

	public Asignatura(int codAsignatura, String nombre, int precio, int codProfesor) {
		super();
		this.codAsignatura = codAsignatura;
		this.nombre = nombre;
		this.precio = precio;
		this.codProfesor = codProfesor;
	}





}

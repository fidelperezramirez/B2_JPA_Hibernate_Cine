package entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 * uniqueConstraints = {
		@UniqueConstraint(columnNames = "CODEMPLEADO")
 * Permite definir restricciones de integridad
	sobre la tabla que estamos creando
 	En general es usada cuando utilizamos la
	auto-creación de esquema
	
	
	
	@Column
		String name: nombre de la columna en la tabla de BD
		boolean unique: indica si es único
		boolean nullable: permite o no nulos
		String table: nombre de la tabla donde se crea
		length (255): longitud 
 *
 */

@Entity

@Table(name="EMPLEADO", catalog = "ejercicio3", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CODEMPLEADO"),@UniqueConstraint(columnNames = "DIRECCION_FK")
})

//El empleado es el dueño de la relación

public class Empleado implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CODEMPLEADO", unique = true, nullable = false)
	private String codEmpleado;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDOS")
       private String apellidos;
	
	//3.1 Asociación unidirecciona sobre Empleado y Dirección
	
	//
	@OneToOne
	@JoinColumn(name="DIRECCION_FK", unique=true, nullable=false, updatable=false)
	private Direccion dir;
		
//	private PlazaParking plaza;
	

    public Empleado() {
	}
    
    public Empleado(String codEmpleado, String nombre, String apellidos, Direccion dir ) {
		this.codEmpleado=codEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dir = dir;
		
	}
//	public Empleado(String codEmpleado, String nombre, String apellidos, Direccion dir) ,PlazaParking p ) {
//		this.codEmpleado=codEmpleado;
//		this.nombre = nombre;
//		this.apellidos = apellidos;
//		this.dir = dir;
//		this.plaza = p;
//	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Direccion getDir() {
		return dir;
	}

	public void setDir(Direccion dir) {
		this.dir = dir;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEmpleado == null) ? 0 : codEmpleado.hashCode());
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
		Empleado other = (Empleado) obj;
		if (codEmpleado == null) {
			if (other.codEmpleado != null)
				return false;
		} else if (!codEmpleado.equals(other.codEmpleado))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "Empleado [codEmpleado=" + codEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", plaza="
//				+ plaza + ", dir=" + dir + "]"+ "\n";
//	}
//	
	@Override
	public String toString() {
		return "Empleado [codEmpleado=" + codEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", plaza="
				 + ", dir=" + dir + "]"+ "\n";
	}

//	public PlazaParking getPlaza() {
//		return plaza;
//	}
//
//	public void setPlaza(PlazaParking plaza) {
//		this.plaza = plaza;
//	}
    
    
    
}

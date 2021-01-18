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
//@Table(name="EMPLEADO", catalog = "ejercicio3", uniqueConstraints = {
//		@UniqueConstraint(columnNames = "CODEMPLEADO")
//})
@Table(name="EMPLEADO1", catalog = "ejercicio6", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CODEMPLEADO"),@UniqueConstraint(columnNames = "DIRECCION_FK")
})

//,@UniqueConstraint(columnNames = "CODDEPTO_FK")
public class Empleado1 implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CODEMPLEADO", unique = true, nullable = false)
	private String codEmpleado;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDOS")
    private String apellidos;
	
	//3.1  Asociación unidireccional ONE to ONE sobre Empleado y  Direccion
	
		//para añadir restriccion hay que especificar , unique=true, nullable=false, updatable=false) 
	   //sino con anotar la restricción en table es suficiente 
		@OneToOne
		@JoinColumn(name="DIRECCION_FK", unique=true, nullable=false, updatable=false)
		private Direccion dir;
		
		
		
	
	
	
	
	/* Cuando JPA realice el mapeo de esta relación, cada entidad será almacenada en su propia tabla,
	 * añadiendo a la tabla donde se almacenan los empleados (la dueña de la relación) una columna 
	 * con las claves foráneas necesarias para asociar cada fila con la fila correspondiente 
	 * en la tabla donde se almacenan las direcciones. Recuerda que JPA utiliza configuración por defecto
	 * para realizar el mapeo, pero podemos customizar este proceso definiendo el nombre de la columna
	 * que contendrá la clave foránea mediante la anotación @JoinColumn
	 *    @OneToOne 
		  @JoinColumn(name = "DIRECCION_FK") 
          private Direccion direccion;   */
	
	
   
	
	
    public Empleado1() {
	}
    
    public Empleado1(String codEmpleado, String nombre, String apellidos, Direccion dir ) {
		this.codEmpleado=codEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dir = dir;
		
	}
	

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
	public String toString() {
		return "Empleado [codEmpleado=" + codEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos +
			", dir=" + dir + "]"+ "\n";
	}

	
    
    
}

package test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import JPAControladorDao.DepartamentoFacadeImpl;
import JPAControladorDao.DireccionFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PlazaParkingFacadeImpl;
import JPAControladorDao.ProyectoFacadeImpl;
import entidades.Departamento;
import entidades.Direccion;
import entidades.Empleado;
import entidades.Proyecto;

public class Test2_Consultas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlazaParkingFacadeImpl pf= new PlazaParkingFacadeImpl();
		DireccionFacadeImpl df= new DireccionFacadeImpl();
		EmpleadoFacadeImpl ef= new EmpleadoFacadeImpl();
		
		DepartamentoFacadeImpl dpf=new DepartamentoFacadeImpl();
		ProyectoFacadeImpl pyf=new ProyectoFacadeImpl();
		
		System.out.println("Ejercicio 1 CONSULTAS: MOSTRAR TODOS LOS EMPLEADOS");
		System.out.println("****                                       ****");
		List<Empleado> listaEmpleado=ef.mostrarTodos();
		System.out.println(listaEmpleado);
		
		System.out.println("Ejercicio 2 CONSULTAS: MOSTRAR TODOS LOS PROYECTOS DEL DEPTO1");
		System.out.println("****                                       ****");
		List<Proyecto> listaDeUnDept=pyf.buscarProyectosDepto(1);
		System.out.println(listaDeUnDept);
		
		System.out.println("Ejercicio 3 CONSULTAS: MOSTRAR TODOS LOS PROYECTOS DEL DEPTO1 CON NOMBRE CONTABILIDAD");
		System.out.println("****                                       ****");
		System.out.println(pyf.buscarProyectosDepto2("contabilidad"));
		System.out.println(pyf.buscarProyectosDeptoJOIN("contabilidad"));
		System.out.println(pyf.buscarProyectosDeptoNotacionPunto("contabilidad"));
		
		System.out.println("Ejercicio 3.2 CONSULTAS: MOSTRAR TODOS LOS EMPLEADOS DEL DEPTO1 SIN JSQL");
		System.out.println("****                                       ****");
		System.out.println(dpf.buscarEmpleadosDeDpto(1));
		
		System.out.println("Ejercicio 4 CONSULTAS: MOSTRAR TODOS LOS EMPLEADOS CON CONSULTA ESTATICA(findAll)");
		System.out.println("****                                       ****");
		TypedQuery<Empleado> query= ef.getEm().createNamedQuery(Empleado.BUSCAR_TODOS_EMPLEADOS,Empleado.class);
		System.out.println(query.getResultList());
//		TypedQuery<Empleado> queryOp= ef.getEm().createNamedQuery("Empleado.findAll",Empleado.class);
//		System.out.println(query.getResultList());
		
		System.out.println("Ejercicio 5 CONSULTAS: VARIAS CONSULTAS ESTATICAS(findAll)");
		System.out.println("****                                       ****");
		TypedQuery<Departamento> query2=dpf.getEm().createNamedQuery(Departamento.BUSCAR_CODDEPT, Departamento.class);
		query2.setParameter("cod", 1);
		TypedQuery<Departamento> query2P2=dpf.getEm().createNamedQuery(Departamento.ORDENAR_DESC_NOMBRE, Departamento.class);
		System.out.println(query2.getResultList());
		System.out.println(query2P2.getResultList());
		
		System.out.println("Ejercicio 6 CONSULTAS: CONSULTAS NATIVAS");
		System.out.println("****                                       ****");
		Query query3=df.getEm().createNativeQuery("SELECT * FROM Direccion",Direccion.class);
		System.out.println(query3.getResultList());
		
		System.out.println("Ejercicio 7 CONSULTAS: CONSULTAS NATIVAS DIFICIL");
		System.out.println("****                                       ****");
		Query query4=df.getEm().createNativeQuery("SELECT Nombre, Apellidos FROM Empleado Where CODDEPTO_FK=:dep");
		query4.setParameter("dep", 1);
		//List array Object
		List<Object[]> emples2=query4.getResultList();
		for(Object[] a:emples2) {
			System.out.println("Empleado "+a[0]+" "+a[1]);
		}
		
	}

}

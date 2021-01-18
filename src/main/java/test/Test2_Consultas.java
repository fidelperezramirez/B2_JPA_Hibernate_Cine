package test;

import java.util.List;

import JPAControladorDao.DepartamentoFacadeImpl;
import JPAControladorDao.DireccionFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PlazaParkingFacadeImpl;
import JPAControladorDao.ProyectoFacadeImpl;
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
		
		
	}

}

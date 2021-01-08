package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Direccion;
import entidades.Empleado;

public class Test1_oneToOne_en_consola {

	 public static void main(String[] arg) {
		 try {
			EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("Persistencia");
			EntityManager emanager=emfactory.createEntityManager();
			
			Direccion d1= new Direccion(1l,"calle1","ciudad1","pais1",41001l);
			
			Empleado e1=new Empleado("e1","Luisa","Jimenez",d1);
			
			Direccion d2= new Direccion(2l,"calle2","ciudad2","pais2",41201l);
			
			Empleado e2=new Empleado("e2","Luis","RUS",d2);
			
			emanager.getTransaction().begin();
			emanager.persist(d1);
			emanager.persist(e1);
			emanager.persist(d2);
			emanager.persist(e2);
			emanager.getTransaction().commit();
			//Consulta
			System.out.println("**Empleados:**");
			TypedQuery<Empleado> query=emanager.createQuery("Select e from Empleado e", Empleado.class);
			List <Empleado> lista=query.getResultList();
			System.out.println(lista);
			
			emanager.close();
			emfactory.close();
		 }catch (Exception e) {
			System.out.println("**Ha ocurrido un error**");
		}
	 }
	
}
package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Direccion;
import entidades.Empleado;
import entidades.PlazaParking;

public class Test2_oneToOneBidireccional_en_consola {

	 public static void main(String[] arg) {
		 try {
			EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("Persistencia");
			EntityManager emanager=emfactory.createEntityManager();
			
			Direccion d1= new Direccion(1l,"calle1","ciudad1","pais1",41001l);
			Direccion d2= new Direccion(2l,"calle2","ciudad2","pais2",41201l);
			PlazaParking p1=new PlazaParking("p100",1,00);
			PlazaParking p2=new PlazaParking("p101",1,01);
			Empleado e1=new Empleado("e1","Luisa","Jimenez",d1,p1);
			Empleado e2=new Empleado("e2","Luis","RUS",d2,p2);
			
			emanager.getTransaction().begin();
			emanager.persist(d1);
			emanager.persist(d2);
			emanager.persist(p1);
			emanager.persist(p2);
			emanager.persist(e1);
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
			e.printStackTrace();
		}
	 }
	
}
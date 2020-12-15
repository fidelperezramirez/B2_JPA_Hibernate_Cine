package JPAControladorDao;

import java.util.List;


import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Empleado;


public class EmpleadoFacadeImpl extends AbstractFacadeJPAImpl<Empleado> implements EmpleadoFacade {


public EmpleadoFacadeImpl() {

	super(Empleado.class);

}

public List<Empleado> mostrarTodos() {
    
    TypedQuery<Empleado> q = em.createQuery("SELECT p FROM Libro AS p",Empleado.class);
    return q.getResultList();
}


public List<Empleado> buscarPorCodigo(String codigo) {
    
    TypedQuery<Empleado> q = em.createQuery("SELECT p FROM Empleado AS p "+
            "  WHERE (p.autor LIKE :patron)",Empleado.class);
	q.setParameter("patron", "%"+codigo+"%");
	
    return q.getResultList();
}


public List<Empleado> buscarPorApellidos(String apellidos) {
	TypedQuery<Empleado> q = em.createQuery("SELECT p FROM Empleado AS p "+
                             "  WHERE (p.titulo LIKE :patron)",Empleado.class);
    q.setParameter("patron", "%"+apellidos+"%");
    return q.getResultList();
}


public List<Empleado> buscarTodos() {
	TypedQuery<Empleado> q = em.createQuery("SELECT p FROM Empleado AS p",Empleado.class);
    return q.getResultList();
}


public Object contador() {
   try{
	  
	   Query q = em.createQuery("SELECT COUNT(p) FROM Empleado AS p");
	   Object result =  q.getSingleResult();
	   return result;
   }
    catch (Exception e){
    	System.out.println("jpql incorrecto");
    }
   return -1;    	
       
}


}



package JPAControladorDao;

import java.util.List;



import javax.persistence.TypedQuery;

import entidades.Proyecto;






//@Stateless
public class ProyectoFacadeImpl extends AbstractFacadeJPAImpl<Proyecto> implements ProyectoFacade {


public ProyectoFacadeImpl() {

	super(Proyecto.class);

}

public List<Proyecto> mostrarTodos() {
    
    TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto AS p",Proyecto.class);
	return q.getResultList();
}

public List<Proyecto> buscarProyectosDepto(int dept){
	TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p WHERE p.codDept.codDept=:seleccionado",Proyecto.class);
	q.setParameter("seleccionado", dept);
	return q.getResultList();
}

public List<Proyecto> buscarProyectosDepto2(String nombre){
	TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p WHERE p.codDept IN"
			+ " (SELECT d.codDept FROM Departamento d WHERE d.dnombre=:seleccionado1)",Proyecto.class);
	q.setParameter("seleccionado1", nombre);
	return q.getResultList();
	}

public List<Proyecto> buscarProyectosDeptoJOIN(String nombre){
	TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p JOIN Departamento d ON p.codDept=d.codDept "+
			"WHERE d.dnombre=:seleccionado1",Proyecto.class);
	q.setParameter("seleccionado1", nombre);
	return q.getResultList();
	}
public List<Proyecto> buscarProyectosDeptoNotacionPunto(String nombre){
	TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p WHERE p.codDept.dnombre=:seleccionado1",Proyecto.class);
	q.setParameter("seleccionado1", nombre);
	return q.getResultList();
	}
}


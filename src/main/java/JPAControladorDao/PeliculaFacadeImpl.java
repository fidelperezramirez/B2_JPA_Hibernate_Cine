package JPAControladorDao;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Pelicula;

public class PeliculaFacadeImpl extends AbstractFacadeJPAImpl<Pelicula> implements PeliculaFacade<Pelicula>{

	public PeliculaFacadeImpl() {
		super(Pelicula.class);
	}

	@Override
	public List<Pelicula> mostrarPeliculas() {
		TypedQuery<Pelicula> pelis=this.getEm().createQuery("SELECT p FROM Pelicula AS p", Pelicula.class);
		return pelis.getResultList();
	}

}

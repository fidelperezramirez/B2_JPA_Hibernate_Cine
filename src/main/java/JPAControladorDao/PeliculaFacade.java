package JPAControladorDao;

import java.util.List;

public interface PeliculaFacade<Pelicula> extends AbstractFacadeJPA<Pelicula> {
	public List<Pelicula> mostrarPeliculas();
}

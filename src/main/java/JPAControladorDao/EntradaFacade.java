package JPAControladorDao;

import java.util.List;

public interface EntradaFacade<Entrada> extends AbstractFacadeJPA<Entrada> {
	
	public List<Entrada> mostrarEntradas() ;
}

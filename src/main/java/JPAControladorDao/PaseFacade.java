package JPAControladorDao;

import java.util.List;

public interface PaseFacade<Pase> extends AbstractFacadeJPA<Pase>{
	
	public List<Pase> mostrarPases();
}

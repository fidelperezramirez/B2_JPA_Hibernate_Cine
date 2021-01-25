package JPAControladorDao;

import java.util.List;

public interface SalaFacade<Sala> extends AbstractFacadeJPA<Sala>{
	public List<Sala> mostrarSalas();
}

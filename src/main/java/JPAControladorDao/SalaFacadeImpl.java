package JPAControladorDao;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Sala;

public class SalaFacadeImpl extends AbstractFacadeJPAImpl<Sala> implements SalaFacade<Sala> {

	public SalaFacadeImpl() {
		super(Sala.class);
	}

	@Override
	public List<Sala> mostrarSalas() {
		TypedQuery<Sala> salas=this.getEm().createQuery("SELECT s FROM Sala AS s", Sala.class);
		return salas.getResultList();
	}

}

package JPAControladorDao;

import java.util.List;

import javax.persistence.TypedQuery;

import entidades.Entrada;

public class EntradaFacadeImp extends AbstractFacadeJPAImpl<Entrada> implements EntradaFacade<Entrada> {


	public EntradaFacadeImp() {
		super(Entrada.class);
	}

	@Override
	public List<Entrada> mostrarEntradas() {
		TypedQuery<Entrada> entradas=this.getEm().createQuery("SELECT e FROM Entrada AS e", Entrada.class);
		return entradas.getResultList();
	}

}

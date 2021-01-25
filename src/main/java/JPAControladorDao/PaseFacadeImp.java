package JPAControladorDao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Pase;
import entidades.Pelicula;
import entidades.Sala;

public class PaseFacadeImp extends AbstractFacadeJPAImpl<Pase> implements PaseFacade<Pase>{

	

	public PaseFacadeImp() {
		super(Pase.class);
	}

	@Override
	public List<Pase> mostrarPases() {
		TypedQuery<Pase> pases=this.getEm().createQuery("SELECT p FROM Pase AS p", Pase.class);
		return pases.getResultList();
	}
	//1
	public List<String> mostrarGenerosNoProyectados(){
		Query generos=this.getEm().createQuery("Select distinct p.genero from Pelicula p WHERE p.genero NOT IN(SELECT pa.pelicula.genero FROM Pase pa)");
		List<String> lista=generos.getResultList();
		return lista;
	}
	//2
	public void mostrarPeliculaMasRecaudado() {
		Query pelis=this.getEm().createQuery("Select pe.titulo, pe.codpelicula, COUNT(e.codentrada),SUM(e.pvp) from Pase p join Pelicula pe ON p.pelicula=pe.codpelicula join Entrada e ON p.codpase=e.pase GROUP BY pe.titulo, pe.codpelicula");
		List<Object[]> lista = pelis.getResultList();
        for(Object[] a : lista) {
            System.out.println("Pelicula "+ a[0]+"\ncodpelicula  "+a[1]+"\nnumEntradas "+a[2]+"\nRecaudado "+a[3]);
        }
	}
	//3
	public long salasDistintas(String genero) {
		Query q=this.getEm().createQuery("Select COUNT(p.sala) from Pase p WHERE p.pelicula.genero=:seleccionado1");
		q.setParameter("seleccionado1", genero);
		long salas=(long) q.getSingleResult();
		return salas;
	}
	//4
	public List<Sala> proyeccionDesde2008() {
		TypedQuery<Sala> q=this.getEm().createQuery("SELECT distinct p.sala FROM Pase AS p WHERE p.pelicula.genero='TERROR' OR p.pelicula.genero='COMEDIA' AND "+
				"p.pelicula.fechaProd>:a ORDER BY p.sala.numasiporfilas desc", Sala.class);
		LocalDate fecha=LocalDate.of(2007, 12, 31);
		q.setParameter("a", java.sql.Date.valueOf(fecha));
		List<Sala> lista=q.getResultList();
		return lista;
	}
	//5
	public List<Pelicula> peliculasDOLBY() {
		TypedQuery<Pelicula> q=this.getEm().createQuery("SELECT distinct p.pelicula FROM Pase AS p WHERE p.sala.tipoSonido='DOLBY'", Pelicula.class);
		List<Pelicula> lista=q.getResultList();
		return lista;
	}
	//6
	public List<Pelicula> peliculasMas5() {
		TypedQuery<Pelicula> q=this.getEm().createQuery("SELECT distinct p.pelicula FROM Pase AS p WHERE (SELECT count(pa.pelicula) FROM Pase As pa where pa.pelicula=p.pelicula)>=5", Pelicula.class);
		List<Pelicula> lista=q.getResultList();
		return lista;
	}
	//7
	public List<Integer> recaudadoJunio2006() {
		Query q=this.getEm().createQuery("Select SUM(e.pvp) from Entrada e JOIN Pase p ON p.codpase=e.pase WHERE p.fechaPase>:a AND p.fechaPase<:b GROUP BY p.tipoPase");
		LocalDate fecha=LocalDate.of(2006, 6, 1);
		q.setParameter("a", java.sql.Date.valueOf(fecha));
		LocalDate fecha2=LocalDate.of(2006, 6, 30);
		q.setParameter("b", java.sql.Date.valueOf(fecha2));
		List<Integer> pvp=q.getResultList();
		return pvp;
	}
	//8
	public List<Pelicula> peliculasConMas100Asientos() {
		TypedQuery<Pelicula> q=this.getEm().createQuery("SELECT p.pelicula FROM Pase AS p WHERE (SELECT SUM(pa.sala.numasiporfilas*pa.sala.numfilas) FROM Pase As pa where pa.codpase=p.codpase)>100"+
				" AND (SELECT COUNT(e.codentrada) FROM Entrada AS e WHERE e.pase=p.codpase AND e.vendido='S')>(SELECT SUM((pa.sala.numasiporfilas*pa.sala.numfilas)/2) FROM Pase As pa where pa.codpase=p.codpase)", Pelicula.class);
		List<Pelicula> lista=q.getResultList();
		return lista;
	}
}

package test;

import java.util.List;

import JPAControladorDao.EntradaFacadeImp;
import JPAControladorDao.PaseFacadeImp;
import JPAControladorDao.PeliculaFacadeImpl;
import JPAControladorDao.SalaFacadeImpl;
import entidades.Entrada;
import entidades.Pase;
import entidades.Pelicula;
import entidades.Sala;

public class Prueba {

	public static void main(String[] args) {
		EntradaFacadeImp enf=new EntradaFacadeImp();
		PaseFacadeImp paf=new PaseFacadeImp();
		PeliculaFacadeImpl pef=new PeliculaFacadeImpl();
		SalaFacadeImpl saf=new SalaFacadeImpl();
		
		//1
		//System.out.println(paf.mostrarGenerosNoProyectados());
		//2
		//paf.mostrarPeliculaMasRecaudado();
		//3
		//System.out.println(paf.salasDistintas("COMEDIA"));
		//4
		//System.out.println(paf.proyeccionDesde2008());
		//5
		//System.out.println(paf.peliculasDOLBY());
		//6
		//System.out.println(paf.peliculasMas5());
		//7
		//System.out.println(paf.recaudadoJunio2006());
		//8
		System.out.println(paf.peliculasConMas100Asientos());
	}

}

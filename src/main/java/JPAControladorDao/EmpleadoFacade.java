package JPAControladorDao;

import java.util.List;

import entidades.Empleado;

public interface EmpleadoFacade extends AbstractFacadeJPA<Empleado>{
	 public List<Empleado> mostrarTodos();
	 public List<Empleado> buscarPorCodigo(String codigo);
	 public List<Empleado> buscarPorApellidos(String apellidos);
	 public List<Empleado> buscarTodos();
	 public Object contador();
}
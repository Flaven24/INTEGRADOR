package pe.integrador.dao;

import java.util.List;
import pe.integrador.domain.EstadoCliente;
import pe.integrador.domain.Cliente;

/**
 *
 * @author Acer
 */
public interface ClienteDAO {

    List<Cliente> listaGeneral();

    Cliente buscarPorIdcliente(Integer idcliente);

    List<Cliente> buscarPorCnomcliente(String cnombre);

    List<EstadoCliente> listadoEstado();

}

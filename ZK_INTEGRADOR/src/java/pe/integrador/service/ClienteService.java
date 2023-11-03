package pe.integrador.service;

import java.util.List;
import pe.integrador.domain.EstadoCliente;
import pe.integrador.domain.Cliente;

/**
 *
 * @author Acer
 */
public interface ClienteService {

    void registrar(Cliente cliente);

    void actualizar(Cliente cliente);

    void eliminar(Cliente cliente);

    List<Cliente> listaGeneral();

    Cliente buscarPorIdcliente(Integer idcliente);

    List<Cliente> buscarPorCnombre(String cnombre);

    List<EstadoCliente> listadoEstado();

}

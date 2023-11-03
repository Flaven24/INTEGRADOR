package pe.integrador.service;

import java.util.List;
import pe.integrador.dao.CrudDAO;
import pe.integrador.dao.CrudDAOImpl;
import pe.integrador.dao.ClienteDAO;
import pe.integrador.dao.ClienteDAOImpl;
import pe.integrador.domain.EstadoCliente;
import pe.integrador.domain.Cliente;

/**
 *
 * @author Acer
 */
public class ClienteServiceImpl implements ClienteService {

    private ClienteDAO clientedao = new ClienteDAOImpl();
    private CrudDAO cruddao = new CrudDAOImpl();

    @Override
    public void registrar(Cliente cliente) {
        cruddao.insertar(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        cruddao.actualizar(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        cruddao.eliminar(cliente);
    }

    @Override
    public List<Cliente> listaGeneral() {
        return clientedao.listaGeneral();
    }

    @Override
    public Cliente buscarPorIdcliente(Integer idcliente) {
        return clientedao.buscarPorIdcliente(idcliente);
    }

    @Override
    public List<Cliente> buscarPorCnombre(String cnombre) {
        return clientedao.buscarPorCnomcliente(cnombre);
    }

    @Override
    public List<EstadoCliente> listadoEstado() {
        return clientedao.listadoEstado();
    }

}

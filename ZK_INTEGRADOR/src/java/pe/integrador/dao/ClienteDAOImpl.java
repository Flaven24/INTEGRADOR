package pe.integrador.dao;

import java.util.List;
import javax.persistence.EntityManager;
import pe.integrador.domain.EstadoCliente;
import pe.integrador.domain.Cliente;

/**
 *
 * @author Acer
 */
public class ClienteDAOImpl implements ClienteDAO {

    private Conexion conn = Conexion.crearConexion();
    private EntityManager em;

    @Override
    public List<Cliente> listaGeneral() {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<Cliente> retorno = em.createNamedQuery("Cliente.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public Cliente buscarPorIdcliente(Integer idcliente) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        Cliente retorno = (Cliente) em.createNamedQuery("Cliente.findByIdcliente").setParameter("idcliente", idcliente).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public List<Cliente> buscarPorCnomcliente(String cnombre) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<Cliente> retorno = em.createNamedQuery("Cliente.findByCnombre").setParameter("cnombre", "%" + cnombre + "%").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public List<EstadoCliente> listadoEstado() {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<EstadoCliente> retorno = em.createNamedQuery("EstadoCliente.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

}

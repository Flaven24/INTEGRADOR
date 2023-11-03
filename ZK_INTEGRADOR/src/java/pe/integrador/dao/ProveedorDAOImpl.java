package pe.integrador.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pe.integrador.domain.EstadoProveedor;
import pe.integrador.domain.Proveedor;

/**
 *
 * @author Acer
 */
public class ProveedorDAOImpl implements ProveedorDAO {

    private Conexion conn = Conexion.crearConexion();
    private EntityManager em;

    @Override
    public List<Proveedor> listaGeneral() {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<Proveedor> retorno = em.createNamedQuery("Proveedor.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public Proveedor buscarPorIdproveedor(Integer idproveedor) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        Proveedor retorno = (Proveedor) em.createNamedQuery("Proveedor.findByIdproveedor").setParameter("idproveedor", idproveedor).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public List<Proveedor> buscarPorCnomproveedor(String cnombre) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<Proveedor> retorno = em.createNamedQuery("Proveedor.findByCnombre").setParameter("cnombre", "%" + cnombre + "%").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public List<EstadoProveedor> listadoEstado() {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<EstadoProveedor> retorno = em.createNamedQuery("EstadoProveedor.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

}

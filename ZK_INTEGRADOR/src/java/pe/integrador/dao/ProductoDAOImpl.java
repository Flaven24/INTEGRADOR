package pe.integrador.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pe.integrador.domain.Producto;

/**
 *
 * @author Acer
 */
public class ProductoDAOImpl implements ProductoDAO {

    private Conexion conn = Conexion.crearConexion();
    private EntityManager em;

    @Override
    public List<Producto> listaGeneral() {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<Producto> retorno = em.createNamedQuery("Producto.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public Producto buscarPorIdproducto(Integer idproducto) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        Producto retorno = (Producto) em.createNamedQuery("Producto.findByIdproducto").setParameter("idproducto", idproducto).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public List<Producto> buscarPorCnomproducto(String cnombre) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<Producto> retorno = em.createNamedQuery("Producto.findByCnombre").setParameter("cnombre", "%" + cnombre + "%").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

}

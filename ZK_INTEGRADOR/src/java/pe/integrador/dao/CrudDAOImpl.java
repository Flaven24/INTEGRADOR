package pe.integrador.dao;

import javax.persistence.EntityManager;

/**
 *
 * @author Acer
 */
public class CrudDAOImpl implements CrudDAO {

    private Conexion conn = Conexion.crearConexion();
    private EntityManager em;

    public void insertar(Object obj) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(Object obj) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        Object obj2 = em.merge(obj);
        em.remove(obj2);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizar(Object obj) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        Object obj2 = em.merge(obj);
        em.persist(obj2);
        em.getTransaction().commit();
        em.close();
    }
}

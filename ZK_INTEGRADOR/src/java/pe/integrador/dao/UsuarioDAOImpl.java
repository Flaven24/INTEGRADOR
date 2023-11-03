package pe.integrador.dao;

import java.util.List;
import javax.persistence.EntityManager;
import pe.integrador.domain.Usuario;

/**
 *
 * @author Acer
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private Conexion conn = Conexion.crearConexion();
    EntityManager em;

    @Override
    public Usuario buscarPorClogin(String clogin) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        Usuario usuario = (Usuario) em.createNamedQuery("Usuario.findByClogin").setParameter("clogin", clogin).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return usuario;
    }

    @Override
    public List<Usuario> buscarPorCriterio(String ccriterio) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<Usuario> retorno = em.createNamedQuery("Usuario.findByCnombre").setParameter("ccriterio", "%" + ccriterio + "%").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public Usuario buscarPorCloginPorCcontrasena(String clogin, String ccontrasena) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        Usuario retorno = (Usuario) em.createNamedQuery("Usuario.findByCloginByCcontrasena").setParameter("clogin", clogin).setParameter("ccontrasena", ccontrasena).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public List<Usuario> listaUsuarios() {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        List<Usuario> retorno = em.createNamedQuery("Usuario.findAll").getResultList();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }

    @Override
    public Usuario buscarPorId(Integer idusuario) {
        em = conn.getEntityManager();
        em.getTransaction().begin();
        Usuario retorno = (Usuario) em.createNamedQuery("Usuario.findByIdusuario").setParameter("idusuario", idusuario).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return retorno;
    }
}

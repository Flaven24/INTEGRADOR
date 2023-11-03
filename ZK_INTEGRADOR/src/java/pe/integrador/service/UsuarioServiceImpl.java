package pe.integrador.service;

import java.util.List;
import pe.integrador.dao.CrudDAO;
import pe.integrador.dao.CrudDAOImpl;
import pe.integrador.dao.UsuarioDAO;
import pe.integrador.dao.UsuarioDAOImpl;
import pe.integrador.domain.Usuario;

/**
 *
 * @author Acer
 */
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDAO usuariodao = new UsuarioDAOImpl();
    private CrudDAO cruddao = new CrudDAOImpl();

    @Override
    public Usuario buscarPorClogin(String clogin) {
        return usuariodao.buscarPorClogin(clogin);
    }
    
    @Override
    public List<Usuario> buscarPorCriterio(String ccriterio) {
        return usuariodao.buscarPorCriterio(ccriterio);
    }

    @Override
    public Usuario buscarPorCloginPorCcontrasena(String clogin, String ccontrasena) {
        return usuariodao.buscarPorCloginPorCcontrasena(clogin, ccontrasena);
    }

    @Override
    public Usuario buscarPorId(Integer idusuario){
        return usuariodao.buscarPorId(idusuario);
    }
    
    @Override
    public void registrar(Usuario usuario) {
        cruddao.insertar(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        cruddao.actualizar(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        cruddao.eliminar(usuario);
    }
    
    @Override
    public List<Usuario> listaUsuarios(){
        return usuariodao.listaUsuarios();
    }

}

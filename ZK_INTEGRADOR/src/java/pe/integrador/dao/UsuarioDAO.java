package pe.integrador.dao;

import java.util.List;
import pe.integrador.domain.Usuario;

/**
 *
 * @author Acer
 */
public interface UsuarioDAO {

    Usuario buscarPorClogin(String clogin);

    Usuario buscarPorCloginPorCcontrasena(String clogin, String ccontrasena);

    List<Usuario> buscarPorCriterio(String ccriterio);

    List<Usuario> listaUsuarios();

    Usuario buscarPorId(Integer idusuario);

}

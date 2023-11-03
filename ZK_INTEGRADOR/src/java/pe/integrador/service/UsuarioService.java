package pe.integrador.service;

import java.util.List;
import pe.integrador.domain.Usuario;

/**
 *
 * @author Acer
 */
public interface UsuarioService {

    void registrar(Usuario usuario);

    void actualizar(Usuario usuario);

    void eliminar(Usuario usuario);
    
    Usuario buscarPorId(Integer idusuario);
    
    List<Usuario> buscarPorCriterio(String ccriterio);

    Usuario buscarPorClogin(String clogin);

    Usuario buscarPorCloginPorCcontrasena(String clogin, String ccontrasena);

    List<Usuario> listaUsuarios();
}

package pe.integrador;

import java.util.Date;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import pe.integrador.domain.Usuario;
import pe.integrador.service.UsuarioService;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import pe.integrador.service.UsuarioServiceImpl;

/**
 *
 * @author Acer
 */
public class Login extends SelectorComposer<Component> {

    @Wire
    private Textbox txtUsuario;
    @Wire
    private Textbox txtContrasena;

    private UsuarioService usuarioService = new UsuarioServiceImpl();

    @Listen("onClick=#btnInicio")
    public void onInicio() {
        login();
    }

    @Listen("onOK=#txtContrasena")
    public void onContrasena() {
        login();
    }

    private void login() {
        // VALIDAR Y VERIFICAR EL USUARIO INGRESADO
        Usuario usuario = usuarioService.buscarPorCloginPorCcontrasena(txtUsuario.getValue(), txtContrasena.getValue());
        if (usuario != null) {
            if (usuario.getBactivo()) {
                System.out.println(usuario);
                Sessions.getCurrent().setAttribute("usuario", usuario); // save user-object in session
                Executions.sendRedirect("index.zul"); // redirect to index
//              registra LA SESION COMO LOG?
            }
        }
    }

}

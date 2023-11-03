package pe.integrador.modulos.mantenimiento;

import java.util.Date;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import pe.integrador.domain.Usuario;
import pe.integrador.service.UsuarioService;
import pe.integrador.service.UsuarioServiceImpl;

/**
 *
 * @author Acer
 */
public class ManttoUsuario extends SelectorComposer<Component> {

    @Wire
    Textbox txtNombre;
    @Wire
    Textbox txtUsuario;
    @Wire
    Textbox txtContrasena;

    @Wire
    Checkbox bActivo;
    @Wire
    Window winUsuario;

    @Wire
    Button btnRegistrar;
    @Wire
    Button btnActualizar;
    @Wire
    Button btnEliminar;

    private UsuarioService usuarioService= new UsuarioServiceImpl();

    private Usuario usuario;

    @Listen("onCreate=#winUsuario")
    public void onCreate() {
        if (winUsuario.getAttribute("USUARIO") != null) {
            usuario = (Usuario) winUsuario.getAttribute("USUARIO");
            btnRegistrar.setVisible(false);
            btnActualizar.setVisible(true);
            btnEliminar.setVisible(true);
            cargar();
        }
    }

    @Listen("onClick=#btnRegistrar")
    public void onRegistrar() {
        registrar();
    }

    @Listen("onClick=#btnActualizar")
    public void onActualizar() {
        actualizar();
    }

    @Listen("onClick=#btnEliminar")
    public void onEliminar() {
        eliminar();
    }

    public void registrar() {
        verificarCampos();
        usuario = new Usuario();
        usuario.setCnombre(txtNombre.getValue());
        usuario.setClogin(txtUsuario.getValue());
        usuario.setCcontrasena(txtContrasena.getValue());
        usuario.setBactivo(bActivo.isChecked());
        usuario.setDfecreg(new Date());
        usuarioService.registrar(usuario);
        Messagebox.show("USUARIO REGISTRADO.");
        limpiar();
    }

    public void actualizar() {
        usuario = usuarioService.buscarPorId(usuario.getIdusuario());
        usuario.setCnombre(txtNombre.getValue());
        usuario.setClogin(txtUsuario.getValue());
        usuario.setCcontrasena(txtContrasena.getValue());
        usuario.setBactivo(bActivo.isChecked());
        usuario.setDfecreg(new Date());
        usuarioService.actualizar(usuario);
        Messagebox.show("USUARIO ACTUALIZADO.");
        winUsuario.onClose();
    }

    public void eliminar() {
        usuario = usuarioService.buscarPorId(usuario.getIdusuario());
        usuarioService.eliminar(usuario);
        Messagebox.show("USUARIO ELIMINADO.");
        winUsuario.onClose();
    }

    public void limpiar() {
        txtNombre.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
        bActivo.setChecked(false);

        btnRegistrar.setVisible(true);
        btnActualizar.setVisible(false);
        btnEliminar.setVisible(false);
    }

    public void verificarCampos() {
        if (txtNombre.getValue().isEmpty()) {
            throw new RuntimeException("Nombre requerido");
        }
        if (txtUsuario.getValue().isEmpty()) {
            throw new RuntimeException("Usuario requerido");
        }
        if (txtContrasena.getValue().isEmpty()) {
            throw new RuntimeException("Contraseña requerida");
        }
    }

    private void cargar() {
        txtNombre.setValue(usuario.getCnombre());
        txtUsuario.setValue(usuario.getClogin());
        txtContrasena.setValue(usuario.getCcontrasena());
        bActivo.setChecked(usuario.getBactivo());
    }
}

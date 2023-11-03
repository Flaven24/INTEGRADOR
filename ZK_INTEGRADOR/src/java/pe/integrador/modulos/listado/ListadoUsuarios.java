package pe.integrador.modulos.listado;

import java.util.HashMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import pe.integrador.ExportarPDF;
import pe.integrador.domain.Usuario;
import pe.integrador.service.UsuarioService;
import pe.integrador.service.UsuarioServiceImpl;

/**
 *
 * @author Acer
 */
public class ListadoUsuarios extends SelectorComposer<Component> {

    private ListModelList modeloUsuario = new ListModelList();

    @Wire
    Listbox lstUsuarios;
    @Wire
    Textbox txtUsuario;

    private UsuarioService usuarioService = new UsuarioServiceImpl();

    @Listen("onCreate=#winListado")
    public void onCreate() {
        procesar();
    }

    @Listen("onClick=#btnProcesar")
    public void onProcesar() {
        procesar();
    }

    @Listen("onOK=#lstUsuarios")
    public void onUsuarios(Event event) {
        mostrarDetalle();
    }

    @Listen("onOK=#txtUsuario")
    public void onUsuario(Event event) {
        buscarUsuario();
    }

    @Listen("onOK=#btnBuscar")
    public void onBuscar(Event event) {
        buscarUsuario();
    }

    @Listen("onClick=#btnImprimir")
    public void onImprimir() {
        imprimir();
    }

    public void procesar() {
        modeloUsuario = new ListModelList(usuarioService.listaUsuarios());
        lstUsuarios.setModel(modeloUsuario);
        lstUsuarios.onInitRender();
    }

    public void mostrarDetalle() {
        if (lstUsuarios.getSelectedIndex() >= 0) {
            Usuario usuario = (Usuario) modeloUsuario.get(lstUsuarios.getSelectedIndex());
            System.out.println(usuario.getCnombre() + "-" + usuario.getCcontrasena());
            Window win = (Window) Executions.createComponents("/modulos/mantenimiento/manttousuario.zul", null, null);
            win.setAttribute("USUARIO", usuario);
            win.onModal();
            win.setClosable(true);
        }
    }

    public void buscarUsuario() {
        modeloUsuario = new ListModelList(usuarioService.buscarPorCriterio(txtUsuario.getValue()));
        lstUsuarios.setModel(modeloUsuario);
        lstUsuarios.onInitRender();
    }

    private void imprimir() {
        HashMap parametro = new HashMap();
        JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(modeloUsuario);
//        ExportarPDF.reporte("USUARIOS", data, parametro, "/reportes/listadousuarios.jrxml");
        ExportarPDF.reporte("USUARIOS", data, parametro, "D:\\UTP\\SEMESTRE V\\CURSO INTEGRADOR I\\ZK_INTEGRADOR\\src\\java\\pe\\integrador\\reportes\\listadousuarios.jrxml");
    }

}

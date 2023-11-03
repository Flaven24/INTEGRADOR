package pe.integrador;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;
import org.zkoss.zul.Borderlayout;

/**
 *
 * @author Acer
 */
public class Index extends SelectorComposer<Component> {

    @Wire
    Borderlayout winIndex;

    @Listen("onCreate=#winIndex")
    public void onCreate() {
        winIndex.setHeight("0px");
        Object obj = Sessions.getCurrent().getAttribute("usuario");
        if (obj == null) {
            Executions.sendRedirect("login.zul");
        } else {
            winIndex.setHeight("800px");
        }
    }

    // PROCESOS
    @Listen("onClick=#btnVenta")
    public void onVenta() {
        System.out.println("VENTA");
        abrirVentana("/modulos/registroventas.zul");
    }

    @Listen("onClick=#btnInventario")
    public void onInventario() {
        abrirVentana("/modulos/inventario.zul");
    }

    @Listen("onClick=#btnCompra")
    public void onCompra() {
        abrirVentana("/modulos/registrocompras.zul");
    }

    // MANTENIMIENTO
    @Listen("onClick=#btnCliente")
    public void onCliente() {
        abrirVentana("/modulos/mantenimiento/manttocliente.zul");
    }

    @Listen("onClick=#btnProducto")
    public void onProducto() {
        abrirVentana("/modulos/mantenimiento/manttoproducto.zul");
    }

    @Listen("onClick=#btnProveedor")
    public void onProveedor() {
        abrirVentana("/modulos/mantenimiento/manttoproveedor.zul");
    }

    @Listen("onClick=#btnUsuario")
    public void onUsuario() {
        abrirVentana("/modulos/mantenimiento/manttousuario.zul");
    }

    //LISTADO
    @Listen("onClick=#btnUsuarios")
    public void onListadoUsuarios() {
        abrirVentana("/modulos/listado/listadousuarios.zul");
    }

    @Listen("onClick=#btnProductos")
    public void onListadoProducto() {
        abrirVentana("/modulos/listado/listadoproductos.zul");
    }

    @Listen("onClick=#btnProveedores")
    public void onListadoProveedores() {
        abrirVentana("/modulos/listado/listadoproveedores.zul");
    }

    @Listen("onClick=#btnClientes")
    public void onListadoClientes() {
        abrirVentana("/modulos/listado/listadoclientes.zul");
    }

    public void abrirVentana(String ruta) {
        Window win = (Window) Executions.createComponents(ruta, null, null);
        win.onModal();
        win.setClosable(true);
    }
}

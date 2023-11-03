package pe.integrador.modulos.listado;

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
import pe.integrador.domain.Producto;
import pe.integrador.service.ProductoService;
import pe.integrador.service.ProductoServiceImpl;

/**
 *
 * @author Acer
 */
public class ListadoProductos extends SelectorComposer<Component> {

    private ListModelList modeloProducto = new ListModelList();

    @Wire
    Listbox lstProductos;
    @Wire
    Textbox txtNombre;

    private ProductoService productoService = new ProductoServiceImpl();

    @Listen("onCreate=#winListado")
    public void onCreate() {
        procesar();
    }

    @Listen("onClick=#btnProcesar")
    public void onProcesar() {
        procesar();
    }

    @Listen("onOK=#lstProductos")
    public void onProductos(Event event) {
        mostrarDetalle();
    }

    @Listen("onOK=#txtNombre")
    public void onNombre(Event event) {
        buscar();
    }

    @Listen("onClick=#btnBuscar")
    public void onBuscar(Event event) {
        buscar();
    }
    
    @Listen("onClick=#btnImprimir")
    public void onImprimir() {
//        imprimir();
    }

    public void procesar() {
        modeloProducto = new ListModelList(productoService.listaGeneral());
        lstProductos.setModel(modeloProducto);
        lstProductos.onInitRender();
    }

    public void mostrarDetalle() {
        if (lstProductos.getSelectedIndex() >= 0) {
            Producto producto = (Producto) modeloProducto.get(lstProductos.getSelectedIndex());
            Window win = (Window) Executions.createComponents("/modulos/mantenimiento/manttoproducto.zul", null, null);
            win.setAttribute("PRODUCTO", producto);
            win.onModal();
            win.setClosable(true);
        }
    }

    public void buscar() {
        modeloProducto = new ListModelList(productoService.buscarPorCnombre(txtNombre.getValue()));
        lstProductos.setModel(modeloProducto);
        lstProductos.onInitRender();
    }

}

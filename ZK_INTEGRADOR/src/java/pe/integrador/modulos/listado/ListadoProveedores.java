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
import pe.integrador.domain.Proveedor;
import pe.integrador.service.ProveedorService;
import pe.integrador.service.ProveedorServiceImpl;

/**
 *
 * @author Acer
 */
public class ListadoProveedores extends SelectorComposer<Component> {

    private ListModelList modeloProveedor = new ListModelList();

    @Wire
    Listbox lstProveedor;
    @Wire
    Textbox txtNombre;

    private ProveedorService proveedorService = new ProveedorServiceImpl();

    @Listen("onCreate=#winListado")
    public void onCreate() {
        procesar();
    }

    @Listen("onClick=#btnProcesar")
    public void onProcesar() {
        procesar();
    }
    
    @Listen("onClick=#btnImprimir")
    public void onImprimir() {
//        imprimir();
    }

    @Listen("onOK=#lstProveedor")
    public void onProveedores(Event event) {
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

    public void procesar() {
        modeloProveedor = new ListModelList(proveedorService.listaGeneral());
        lstProveedor.setModel(modeloProveedor);
        lstProveedor.onInitRender();
    }

    public void mostrarDetalle() {
        if (lstProveedor.getSelectedIndex() >= 0) {
            Proveedor proveedor = (Proveedor) modeloProveedor.get(lstProveedor.getSelectedIndex());
            Window win = (Window) Executions.createComponents("/modulos/mantenimiento/manttoproveedor.zul", null, null);
            win.setAttribute("PROVEEDOR", proveedor);
            win.onModal();
            win.setClosable(true);
        }
    }

    public void buscar() {
        modeloProveedor = new ListModelList(proveedorService.buscarPorCnombre(txtNombre.getValue()));
        lstProveedor.setModel(modeloProveedor);
        lstProveedor.onInitRender();
    }

}

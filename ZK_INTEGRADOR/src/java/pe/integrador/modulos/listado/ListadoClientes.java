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
import pe.integrador.domain.Cliente;
import pe.integrador.service.ClienteService;
import pe.integrador.service.ClienteServiceImpl;

/**
 *
 * @author Acer
 */
public class ListadoClientes extends SelectorComposer<Component> {

    private ListModelList modeloCliente = new ListModelList();

    @Wire
    Listbox lstCliente;
    @Wire
    Textbox txtNombre;

    private ClienteService clienteService = new ClienteServiceImpl();

    @Listen("onCreate=#winListado")
    public void onCreate() {
        procesar();
    }

    @Listen("onClick=#btnProcesar")
    public void onProcesar() {
        procesar();
    }

    @Listen("onOK=#lstCliente")
    public void onClientes(Event event) {
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
        modeloCliente = new ListModelList(clienteService.listaGeneral());
        lstCliente.setModel(modeloCliente);
        lstCliente.onInitRender();
    }

    public void mostrarDetalle() {
        if (lstCliente.getSelectedIndex() >= 0) {
            Cliente cliente = (Cliente) modeloCliente.get(lstCliente.getSelectedIndex());
            Window win = (Window) Executions.createComponents("/modulos/mantenimiento/manttocliente.zul", null, null);
            win.setAttribute("CLIENTE", cliente);
            win.onModal();
            win.setClosable(true);
        }
    }

    public void buscar() {
        modeloCliente = new ListModelList(clienteService.buscarPorCnombre(txtNombre.getValue()));
        lstCliente.setModel(modeloCliente);
        lstCliente.onInitRender();
    }

}

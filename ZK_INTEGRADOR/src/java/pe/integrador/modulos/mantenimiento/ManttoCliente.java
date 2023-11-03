package pe.integrador.modulos.mantenimiento;

import java.util.Date;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import pe.integrador.domain.EstadoCliente;
import pe.integrador.domain.Cliente;
import pe.integrador.service.ClienteService;
import pe.integrador.service.ClienteServiceImpl;

/**
 *
 * @author Acer
 */
public class ManttoCliente extends SelectorComposer<Component> {

    private ClienteService clienteService = new ClienteServiceImpl();
    ListModelList modeloEstado = new ListModelList();

    @Wire
    Window winCliente;
    @Wire
    Textbox txtCodigo;
    @Wire
    Textbox txtNombre;
    @Wire
    Textbox txtApellido;
    @Wire
    Textbox txtDni;

    @Wire
    Combobox cboEstado;
    @Wire
    Checkbox bActivo;

    @Wire
    Button btnRegistrar;
    @Wire
    Button btnActualizar;
    @Wire
    Button btnEliminar;

    Cliente cliente;

    @Listen("onCreate=#winCliente")
    public void onCreate() {
        modeloEstado = new ListModelList(clienteService.listadoEstado());
        cboEstado.setModel(modeloEstado);
        if (modeloEstado.size() > 0) {
            cboEstado.onInitRender(new Event("", cboEstado));
            cboEstado.setSelectedIndex(0);
            cboEstado.close();
        }

        if (winCliente.getAttribute("CLIENTE") != null) {
            cliente = (Cliente) winCliente.getAttribute("CLIENTE");
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
        EstadoCliente estado = (EstadoCliente) modeloEstado.get(cboEstado.getSelectedIndex());
        cliente = new Cliente();
        cliente.setCnombre(txtNombre.getValue());
        cliente.setCapellido(txtApellido.getValue());
        cliente.setCdni(txtDni.getValue());
        cliente.setDfecreg(new Date());
        cliente.setBactivo(bActivo.isChecked());
        cliente.setIdestado(estado);
        clienteService.registrar(cliente);
        Messagebox.show("CLIENTE REGISTRADO.");
        limpiar();
    }

    public void actualizar() {
        EstadoCliente estado = (EstadoCliente) modeloEstado.get(cboEstado.getSelectedIndex());
        cliente = clienteService.buscarPorIdcliente(cliente.getIdcliente());
        cliente.setCnombre(txtNombre.getValue());
        cliente.setCapellido(txtApellido.getValue());
        cliente.setCdni(txtDni.getValue());
        cliente.setBactivo(bActivo.isChecked());
        cliente.setIdestado(estado);
        clienteService.actualizar(cliente);
        Messagebox.show("CLIENTE ACTUALIZADO.");
        winCliente.onClose();
    }

    public void eliminar() {
        cliente = clienteService.buscarPorIdcliente(cliente.getIdcliente());
        clienteService.eliminar(cliente);
        Messagebox.show("CLIENTE ELIMINADO.");
        winCliente.onClose();
    }

    public void limpiar() {
        txtNombre.setText("");
        txtCodigo.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        bActivo.setChecked(false);
        cboEstado.setText("");
        cboEstado.setSelectedIndex(-1);

        btnRegistrar.setVisible(true);
        btnActualizar.setVisible(false);
        btnEliminar.setVisible(false);
    }

    public void verificarCampos() {
        if (txtNombre.getValue().isEmpty()) {
            throw new RuntimeException("Nombre de cliente requerido");
        }
        if (txtApellido.getValue().isEmpty()) {
            throw new RuntimeException("Apellido de cliente requerido");
        }
        if (txtDni.getValue().isEmpty()) {
            throw new RuntimeException("DNI de cliente requerido");
        } else {
            if (txtDni.getValue().length() != 8) {
                throw new RuntimeException("El DNI de cliente debe ser de 8 dígitos");
            }
        }
    }

    private void cargar() {
        txtCodigo.setValue(cliente.getIdcliente() + "");
        txtNombre.setValue(cliente.getCnombre());
        txtApellido.setValue(cliente.getCapellido());
        txtDni.setText(cliente.getCdni());
        bActivo.setChecked(cliente.getBactivo());
        cboEstado.setSelectedIndex(modeloEstado.indexOf(cliente.getIdestado()));
    }

}

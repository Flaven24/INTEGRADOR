package pe.integrador.modulos.mantenimiento;

import java.util.Date;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import pe.integrador.domain.EstadoProveedor;
import pe.integrador.domain.Proveedor;
import pe.integrador.service.ProveedorService;
import pe.integrador.service.ProveedorServiceImpl;

/**
 *
 * @author Acer
 */
public class ManttoProveedor extends SelectorComposer<Component> {

    private ProveedorService proveedorService = new ProveedorServiceImpl();
    ListModelList modeloEstado = new ListModelList();

    @Wire
    Window winProveedor;
    @Wire
    Textbox txtCodigo;
    @Wire
    Textbox txtNombre;
    @Wire
    Textbox txtRazon;
    @Wire
    Textbox txtRuc;

    @Wire
    Combobox cboEstado;

    @Wire
    Button btnRegistrar;
    @Wire
    Button btnActualizar;
    @Wire
    Button btnEliminar;

    Proveedor proveedor;

    @Listen("onCreate=#winProveedor")
    public void onCreate() {
        modeloEstado = new ListModelList(proveedorService.listadoEstado());
        cboEstado.setModel(modeloEstado);
        if (modeloEstado.size() > 0) {
            cboEstado.onInitRender(new Event("", cboEstado));
            cboEstado.setSelectedIndex(0);
            cboEstado.close();
        }
        
        if (winProveedor.getAttribute("PROVEEDOR") != null) {
            proveedor = (Proveedor) winProveedor.getAttribute("PROVEEDOR");
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
        EstadoProveedor estado = (EstadoProveedor) modeloEstado.get(cboEstado.getSelectedIndex());
        proveedor = new Proveedor();
        proveedor.setCnombre(txtNombre.getValue());
        proveedor.setCrazon(txtRazon.getValue());
        proveedor.setCruc(txtRuc.getValue().toString());
        proveedor.setDfecreg(new Date());
        proveedor.setIdestado(estado);
        proveedorService.registrar(proveedor);
        Messagebox.show("PROVEEDOR REGISTRADO.");
        limpiar();
    }

    public void actualizar() {
        EstadoProveedor estado = (EstadoProveedor) modeloEstado.get(cboEstado.getSelectedIndex());
        proveedor = proveedorService.buscarPorIdproveedor(proveedor.getIdproveedor());
        proveedor.setCnombre(txtNombre.getValue());
        proveedor.setCrazon(txtRazon.getValue());
        proveedor.setCruc(txtRuc.getValue().toString());
        proveedor.setDfecreg(new Date());
        proveedor.setIdestado(estado);
        proveedorService.actualizar(proveedor);
        Messagebox.show("PROVEEDOR ACTUALIZADO.");
        winProveedor.onClose();
    }

    public void eliminar() {
        proveedor = proveedorService.buscarPorIdproveedor(proveedor.getIdproveedor());
        proveedorService.eliminar(proveedor);
        Messagebox.show("PROVEEDOR ELIMINADO.");
        winProveedor.onClose();
    }

    public void limpiar() {
        txtNombre.setText("");
        txtCodigo.setText("");
        txtRazon.setText("");
        txtRuc.setText("");
        cboEstado.setText("");
        cboEstado.setSelectedIndex(-1);

        btnRegistrar.setVisible(true);
        btnActualizar.setVisible(false);
        btnEliminar.setVisible(false);
    }

    public void verificarCampos() {
        if (txtNombre.getValue().isEmpty()) {
            throw new RuntimeException("Nombre de proveedor requerido");
        }
        if (txtRazon.getValue().isEmpty()) {
            throw new RuntimeException("Razon Social de proveedor requerida");
        }
        if (txtRuc.getValue().toString().isEmpty()) {
            throw new RuntimeException("Razon Social de proveedor requerida");
        } else {
            if (txtRuc.getValue().toString().length() != 11) {
                throw new RuntimeException("El RUC de proveedor debe ser de 11 dígitos");
            }
        }
    }

    private void cargar() {
        txtCodigo.setValue(proveedor.getIdproveedor() + "");
        txtNombre.setValue(proveedor.getCnombre());
        txtRazon.setText(proveedor.getCrazon());
        txtRuc.setText(proveedor.getCruc());
        cboEstado.setSelectedIndex(modeloEstado.indexOf(proveedor.getIdestado()));
    }

}

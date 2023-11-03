package pe.integrador.modulos.mantenimiento;

import java.math.BigDecimal;
import java.util.Date;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import pe.integrador.domain.Producto;
import pe.integrador.service.ProductoService;
import pe.integrador.service.ProductoServiceImpl;

/**
 *
 * @author Acer
 */
public class ManttoProducto extends SelectorComposer<Component> {

    private ProductoService productoService = new ProductoServiceImpl();

    @Wire
    Window winProducto;
    @Wire
    Textbox txtCodigo;
    @Wire
    Textbox txtNombre;
    @Wire
    Checkbox bActivo;
    @Wire
    Intbox nStock;
    @Wire
    Decimalbox nCosuni;
    @Wire
    Decimalbox nUltcos;

    @Wire
    Button btnRegistrar;
    @Wire
    Button btnActualizar;
    @Wire
    Button btnEliminar;

    Producto producto;

    @Listen("onCreate=#winProducto")
    public void onCreate() {
        if (winProducto.getAttribute("PRODUCTO") != null) {
            producto = (Producto) winProducto.getAttribute("PRODUCTO");
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
        producto = new Producto();
        producto.setCnombre(txtNombre.getValue());
        producto.setBactivo(bActivo.isChecked());
        producto.setDfecreg(new Date());
        producto.setNstock(0);
        producto.setNcosuni(new BigDecimal("0.00"));
        producto.setNultcos(new BigDecimal("0.00"));
        productoService.registrar(producto);
        Messagebox.show("PRODUCTO REGISTRADO.");
        limpiar();
    }

    public void actualizar() {
        producto = productoService.buscarPorIdproducto(producto.getIdproducto());
        producto.setCnombre(txtNombre.getValue());
        producto.setBactivo(bActivo.isChecked());
        producto.setDfecreg(new Date());
        producto.setNstock(nStock.getValue());
        producto.setNcosuni(nCosuni.getValue());
        producto.setNultcos(nUltcos.getValue());
        productoService.actualizar(producto);
        Messagebox.show("PRODUCTO ACTUALIZADO.");
        winProducto.onClose();
    }

    public void eliminar() {
        producto = productoService.buscarPorIdproducto(producto.getIdproducto());
        productoService.eliminar(producto);
        Messagebox.show("PRODUCTO ELIMINADO.");
        winProducto.onClose();
    }

    public void limpiar() {
        txtNombre.setText("");
        txtCodigo.setText("");
        nStock.setText("");
        nCosuni.setText("");
        nUltcos.setText("");
        bActivo.setChecked(false);

        btnRegistrar.setVisible(true);
        btnActualizar.setVisible(false);
        btnEliminar.setVisible(false);
    }

    public void verificarCampos() {
        if (txtNombre.getValue().isEmpty()) {
            throw new RuntimeException("Nombre de producto requerido");
        }
    }

    private void cargar() {
        txtCodigo.setValue(producto.getIdproducto() + "");
        txtNombre.setValue(producto.getCnombre());
        nStock.setValue(producto.getNstock());
        nCosuni.setValue(producto.getNcosuni());
        nUltcos.setValue(producto.getNultcos());
        bActivo.setChecked(producto.getBactivo());

    }

}

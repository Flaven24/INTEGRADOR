package pe.integrador.dao;

import java.util.List;
import pe.integrador.domain.EstadoProveedor;
import pe.integrador.domain.Proveedor;

/**
 *
 * @author Acer
 */
public interface ProveedorDAO {

    List<Proveedor> listaGeneral();

    Proveedor buscarPorIdproveedor(Integer idproveedor);

    List<Proveedor> buscarPorCnomproveedor(String cnombre);
    
    List<EstadoProveedor> listadoEstado();

}

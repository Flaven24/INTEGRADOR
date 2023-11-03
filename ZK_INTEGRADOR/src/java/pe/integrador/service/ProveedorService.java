package pe.integrador.service;

import java.util.List;
import pe.integrador.domain.EstadoProveedor;
import pe.integrador.domain.Proveedor;

/**
 *
 * @author Acer
 */
public interface ProveedorService {

    void registrar(Proveedor proveedor);

    void actualizar(Proveedor proveedor);

    void eliminar(Proveedor proveedor);

    List<Proveedor> listaGeneral();

    Proveedor buscarPorIdproveedor(Integer idproveedor);

    List<Proveedor> buscarPorCnombre(String cnombre);

    List<EstadoProveedor> listadoEstado();

}

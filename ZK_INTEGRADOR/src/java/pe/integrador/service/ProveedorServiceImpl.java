package pe.integrador.service;

import java.util.List;
import pe.integrador.dao.CrudDAO;
import pe.integrador.dao.CrudDAOImpl;
import pe.integrador.dao.ProveedorDAO;
import pe.integrador.dao.ProveedorDAOImpl;
import pe.integrador.domain.EstadoProveedor;
import pe.integrador.domain.Proveedor;
import pe.integrador.domain.Proveedor;

/**
 *
 * @author Acer
 */
public class ProveedorServiceImpl implements ProveedorService {

    private ProveedorDAO proveedordao = new ProveedorDAOImpl();
    private CrudDAO cruddao = new CrudDAOImpl();

    @Override
    public void registrar(Proveedor proveedor) {
        cruddao.insertar(proveedor);
    }

    @Override
    public void actualizar(Proveedor proveedor) {
        cruddao.actualizar(proveedor);
    }

    @Override
    public void eliminar(Proveedor proveedor) {
        cruddao.eliminar(proveedor);
    }

    @Override
    public List<Proveedor> listaGeneral() {
        return proveedordao.listaGeneral();
    }

    @Override
    public Proveedor buscarPorIdproveedor(Integer idproveedor) {
        return proveedordao.buscarPorIdproveedor(idproveedor);
    }

    @Override
    public List<Proveedor> buscarPorCnombre(String cnombre) {
        return proveedordao.buscarPorCnomproveedor(cnombre);
    }

    @Override
    public List<EstadoProveedor> listadoEstado() {
        return proveedordao.listadoEstado();
    }

}

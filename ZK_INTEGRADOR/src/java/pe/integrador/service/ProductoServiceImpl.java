package pe.integrador.service;

import java.util.List;
import pe.integrador.dao.CrudDAO;
import pe.integrador.dao.CrudDAOImpl;
import pe.integrador.dao.ProductoDAO;
import pe.integrador.dao.ProductoDAOImpl;
import pe.integrador.domain.Producto;

/**
 *
 * @author Acer
 */
public class ProductoServiceImpl implements ProductoService {

    private ProductoDAO productodao = new ProductoDAOImpl();
    private CrudDAO cruddao = new CrudDAOImpl();

    @Override
    public void registrar(Producto producto) {
        cruddao.insertar(producto);
    }

    @Override
    public void actualizar(Producto producto) {
        cruddao.actualizar(producto);
    }

    @Override
    public void eliminar(Producto producto) {
        cruddao.eliminar(producto);
    }

    @Override
    public List<Producto> listaGeneral(){
        return productodao.listaGeneral();
    }
    
    @Override
    public Producto buscarPorIdproducto(Integer idproducto) {
        return productodao.buscarPorIdproducto(idproducto);
    }

    @Override
    public List<Producto> buscarPorCnombre(String cnombre) {
        return productodao.buscarPorCnomproducto(cnombre);
    }

}

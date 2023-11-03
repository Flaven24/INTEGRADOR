package pe.integrador.service;

import java.util.List;
import pe.integrador.domain.Producto;

/**
 *
 * @author Acer
 */
public interface ProductoService {

    void registrar(Producto producto);

    void actualizar(Producto producto);

    void eliminar(Producto producto);

    List<Producto> listaGeneral();
    
    Producto buscarPorIdproducto(Integer idproducto);

    List<Producto> buscarPorCnombre(String cnombre);

}

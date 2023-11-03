package pe.integrador.dao;

import java.util.List;
import pe.integrador.domain.Producto;

/**
 *
 * @author Acer
 */
public interface ProductoDAO {

    List<Producto> listaGeneral();

    Producto buscarPorIdproducto(Integer idproducto);

    List<Producto> buscarPorCnomproducto(String cnombre);

}

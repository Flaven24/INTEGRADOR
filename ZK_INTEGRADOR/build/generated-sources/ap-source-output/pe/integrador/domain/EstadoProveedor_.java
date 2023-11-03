package pe.integrador.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.integrador.domain.Proveedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-23T18:20:05")
@StaticMetamodel(EstadoProveedor.class)
public class EstadoProveedor_ { 

    public static volatile SingularAttribute<EstadoProveedor, Boolean> bactivo;
    public static volatile SingularAttribute<EstadoProveedor, String> cnomestado;
    public static volatile CollectionAttribute<EstadoProveedor, Proveedor> proveedorCollection;
    public static volatile SingularAttribute<EstadoProveedor, Integer> norden;
    public static volatile SingularAttribute<EstadoProveedor, Integer> idestado;
    public static volatile SingularAttribute<EstadoProveedor, Date> dfecreg;

}
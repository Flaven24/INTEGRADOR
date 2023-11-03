package pe.integrador.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.integrador.domain.EstadoProveedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-23T18:20:05")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, Integer> idproveedor;
    public static volatile SingularAttribute<Proveedor, String> cnombre;
    public static volatile SingularAttribute<Proveedor, String> crazon;
    public static volatile SingularAttribute<Proveedor, String> cruc;
    public static volatile SingularAttribute<Proveedor, Date> dfecreg;
    public static volatile SingularAttribute<Proveedor, EstadoProveedor> idestado;

}
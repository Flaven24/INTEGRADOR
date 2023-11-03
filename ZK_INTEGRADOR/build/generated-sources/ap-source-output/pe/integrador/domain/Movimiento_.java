package pe.integrador.domain;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.integrador.domain.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-23T18:20:05")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, Integer> ncantidad;
    public static volatile SingularAttribute<Movimiento, Integer> idmovimiento;
    public static volatile SingularAttribute<Movimiento, Integer> idregsalida;
    public static volatile SingularAttribute<Movimiento, BigDecimal> ncosuni;
    public static volatile SingularAttribute<Movimiento, BigDecimal> nsubtotal;
    public static volatile SingularAttribute<Movimiento, Integer> idregentrada;
    public static volatile SingularAttribute<Movimiento, Producto> idproducto;
    public static volatile SingularAttribute<Movimiento, BigDecimal> nvaluni;

}
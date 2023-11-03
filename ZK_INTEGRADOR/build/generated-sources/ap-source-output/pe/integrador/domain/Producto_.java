package pe.integrador.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-23T18:20:05")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Boolean> bactivo;
    public static volatile SingularAttribute<Producto, String> cnombre;
    public static volatile SingularAttribute<Producto, BigDecimal> nultcos;
    public static volatile SingularAttribute<Producto, Integer> nstock;
    public static volatile SingularAttribute<Producto, BigDecimal> ncosuni;
    public static volatile SingularAttribute<Producto, Integer> idproducto;
    public static volatile SingularAttribute<Producto, Date> dfecreg;

}
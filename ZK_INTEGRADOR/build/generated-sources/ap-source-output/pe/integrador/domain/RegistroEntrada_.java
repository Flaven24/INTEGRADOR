package pe.integrador.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.integrador.domain.Proveedor;
import pe.integrador.domain.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-23T18:20:05")
@StaticMetamodel(RegistroEntrada.class)
public class RegistroEntrada_ { 

    public static volatile SingularAttribute<RegistroEntrada, Proveedor> idproveedor;
    public static volatile SingularAttribute<RegistroEntrada, Date> dfecven;
    public static volatile SingularAttribute<RegistroEntrada, BigDecimal> nigv;
    public static volatile SingularAttribute<RegistroEntrada, Date> dfecemi;
    public static volatile SingularAttribute<RegistroEntrada, BigDecimal> nsubtotal;
    public static volatile SingularAttribute<RegistroEntrada, Integer> idregentrada;
    public static volatile SingularAttribute<RegistroEntrada, BigDecimal> nimporte;
    public static volatile SingularAttribute<RegistroEntrada, Integer> nplazo;
    public static volatile SingularAttribute<RegistroEntrada, Date> dfecreg;
    public static volatile SingularAttribute<RegistroEntrada, Usuario> idusuario;

}
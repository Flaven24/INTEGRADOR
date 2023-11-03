package pe.integrador.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.integrador.domain.Cliente;
import pe.integrador.domain.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-23T18:20:05")
@StaticMetamodel(RegistroSalida.class)
public class RegistroSalida_ { 

    public static volatile SingularAttribute<RegistroSalida, Integer> idregsalida;
    public static volatile SingularAttribute<RegistroSalida, Date> dfecha;
    public static volatile SingularAttribute<RegistroSalida, BigDecimal> nigv;
    public static volatile SingularAttribute<RegistroSalida, BigDecimal> nsubtotal;
    public static volatile SingularAttribute<RegistroSalida, BigDecimal> nimporte;
    public static volatile SingularAttribute<RegistroSalida, Cliente> idcliente;
    public static volatile SingularAttribute<RegistroSalida, Date> dfecreg;
    public static volatile SingularAttribute<RegistroSalida, Usuario> idusuario;

}
package pe.integrador.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.integrador.domain.RegistroEntrada;
import pe.integrador.domain.RegistroSalida;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-23T18:20:05")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Boolean> bactivo;
    public static volatile SingularAttribute<Usuario, String> cnombre;
    public static volatile SingularAttribute<Usuario, String> clogin;
    public static volatile SingularAttribute<Usuario, String> ccontrasena;
    public static volatile CollectionAttribute<Usuario, RegistroEntrada> registroEntradaCollection;
    public static volatile CollectionAttribute<Usuario, RegistroSalida> registroSalidaCollection;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile SingularAttribute<Usuario, Date> dfecreg;

}
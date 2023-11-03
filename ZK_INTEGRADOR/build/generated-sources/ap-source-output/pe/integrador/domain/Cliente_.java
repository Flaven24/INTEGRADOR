package pe.integrador.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pe.integrador.domain.EstadoCliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-23T18:20:05")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Boolean> bactivo;
    public static volatile SingularAttribute<Cliente, String> cnombre;
    public static volatile SingularAttribute<Cliente, String> capellido;
    public static volatile SingularAttribute<Cliente, String> cdni;
    public static volatile SingularAttribute<Cliente, Integer> idcliente;
    public static volatile SingularAttribute<Cliente, Date> dfecreg;
    public static volatile SingularAttribute<Cliente, EstadoCliente> idestado;

}
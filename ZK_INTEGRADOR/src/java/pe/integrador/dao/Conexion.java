package pe.integrador.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Acer
 */
public class Conexion {

    private static Conexion conn;
    private static EntityManager entityManager ;
    private static EntityManagerFactory factory;

    private Conexion() {
        factory = Persistence.createEntityManagerFactory("PROYECTO_INTEGRADORPU");
        entityManager = factory.createEntityManager();
    }

    public static Conexion crearConexion() {
        if (Conexion.conn == null) {
            conn = new Conexion();
        } else {
            factory = Persistence.createEntityManagerFactory("PROYECTO_INTEGRADORPU");
            
        }
        return conn;
    }

//    public Connection crearConexion() {
//        Connection sqlCon = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            sqlCon = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trabajo_integrador", "utp", "utp");
//            System.out.println(sqlCon.getCatalog());
//            sqlCon.createStatement();
//        } catch (Exception ex) {
//             ex.printStackTrace();
//        }
//        return sqlCon;
//    }

    public static EntityManager getEntityManager() {
        entityManager = factory.createEntityManager();
        return entityManager;
    }

    
}

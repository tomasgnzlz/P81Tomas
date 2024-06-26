/*
 * Esta clase aplica el patrón SINGLETON
 */
package daw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author J. Carlos F. Vico <jcarlosvico@maralboran.es>
 */
public class Conexion {

    public static void main(String[] args) {
         Connection con = Conexion.getInstance();
    }
    private static final String SERVIDOR = "jdbc:mysql://127.0.0.1/";
    //private static final String SERVIDOR = "jdbc:mysql://localhost/";
    private static final String NOMBRE_BASE_DATOS = "p81Tomas";
    private static final String USER = "tomas";
    //private static final String USER = "root";
    private static final String PASS = "1234";

    private static Connection instancia = null;

    // Constructor privado no accesible desde otras clases
    private Conexion() {

    }

    // Método de clase para acceder a la instancia del objeto Connection
    public static Connection getInstance() {
        // Si el objeto Connection no está creado, se crea
        if (instancia == null) {
            try {

                // Se crea el objeto Connection	
                instancia = DriverManager.getConnection(SERVIDOR + NOMBRE_BASE_DATOS, USER, PASS);

                System.out.println("Conexión a: " + NOMBRE_BASE_DATOS + " realizada con éxito.");

            } catch (SQLException e) {

                // Error en la conexión
                System.out.println("Conexión fallida: " + e.getMessage());
            }
        }
        return instancia;
    }

}

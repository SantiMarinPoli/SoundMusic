package co.com.soundMusic.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class DBUtil {

    private static Connection conexion = null;

    public static Connection getConexion() {
        try {
            //Cargar driver de la base de datos oracle
            Class.forName("oracle.jdbc.OracleDriver");

            //Guardar en un string el nombre de usuario
            //y contraseña de la conexion de la base de datos
            String nombreUsuario = "SOUNDMUSIC";
            String password = "SOUNDMUSIC2018";
            //Guardamos en un String la url de nuestra base de datos
            String url = "jdbc:oracle:thin:@localhost:1521:XE";

            //Nos conectamos a la base de datos con los datos anteriores
            conexion = DriverManager.getConnection(url, nombreUsuario, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
}

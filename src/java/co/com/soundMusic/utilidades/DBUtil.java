package co.com.soundMusic.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class DBUtil {

    private static Connection conexion = null;
    private static BasicDataSource conexionPool;

    ;

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

    public static Connection getTestConexion() {
        try {
            //Cargar driver de la base de datos oracle
            Class.forName("oracle.jdbc.OracleDriver");

            //Guardar en un string el nombre de usuario
            //y contraseña de la conexion de la base de datos
            String nombreUsuario = "DBTest";
            String password = "DBTest";
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

    public static Connection getConexionPool() {
        conexionPool = new BasicDataSource();
        String nombreUsuario = "SOUNDMUSIC";
        String password = "SOUNDMUSIC2018";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";

        conexionPool.setUsername(nombreUsuario);
        conexionPool.setPassword(password);
        conexionPool.setDriverClassName("oracle.jdbc.OracleDriver");
        conexionPool.setUrl(url);
        conexionPool.setInitialSize(5);
        try {
            conexion = conexionPool.getConnection();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conexion;
    }

}

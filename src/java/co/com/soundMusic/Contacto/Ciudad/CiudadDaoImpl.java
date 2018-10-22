package co.com.soundMusic.Contacto.Ciudad;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CiudadDaoImpl implements ICiudadDao {

    //Conexion a la base de datos
    private final Connection conexion;

    private Statement stmt;
    private ResultSet rs;
    //Constantes con las querys a la base de datos
    private static final String SELECT_CIUDADES;
    private static final String SELECT_CIUDAD_POR_ID;
    private static final String INSERT_CIUDAD;
    private static final String UPDATE_CIUDAD;

    public CiudadDaoImpl(Boolean production) {
        if (production) {
            conexion = DBUtil.getConexion();
        } else {
            conexion = DBUtil.getTestConexion();
        }
        stmt = null;
        rs = null;
    }

    @Override
    public List<Ciudad> obtenerCiudades() {
        List<Ciudad> listaCiudades = new ArrayList<>();
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SELECT_CIUDADES);

            while (rs.next()) {
                Ciudad ciudad = new Ciudad(rs.getInt("ID_CIUDAD"), rs.getString("NOMBRE_CIUDAD"), rs.getInt("ID_PAIS"));
                ciudad.obtenerPais();
                listaCiudades.add(ciudad);
            }

        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CiudadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
        return listaCiudades;
    }

    @Override
    public Ciudad obtenerCiudad(int idCiudad) {
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_CIUDAD_POR_ID);
            ps.setInt(1, idCiudad);
            rs = ps.executeQuery();

            while (rs.next()) {
                Ciudad ciudad = new Ciudad(idCiudad, rs.getString("NOMBRE_CIUDAD"),
                        rs.getInt("ID_PAIS"));

                ciudad.obtenerPais();

                return ciudad;
            }
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CiudadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
        return null;
    }

    @Override
    public void crearCiudad(Ciudad ciudad) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_CIUDAD);
            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, ciudad.getIdPais());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CiudadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
    }

    @Override
    public void actualizarCiudad(Ciudad ciudad) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_CIUDAD);
            ps.setString(1, ciudad.getNombre());
            ps.setInt(2, ciudad.getIdCiudad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CiudadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
    }

    static {
        SELECT_CIUDADES = "SELECT ID_CIUDAD, NOMBRE AS NOMBRE_CIUDAD, ID_PAIS\n"
                + "FROM CIUDAD CIU \n"
                + "ORDER BY CIU.ID_CIUDAD";

        SELECT_CIUDAD_POR_ID = "SELECT ID_CIUDAD, NOMBRE AS NOMBRE_CIUDAD, ID_PAIS \n"
                + "FROM CIUDAD\n"
                + "WHERE ID_CIUDAD=?";

        INSERT_CIUDAD = "INSERT INTO CIUDAD (NOMBRE, ID_PAIS)\n"
                + "VALUES (?,?)\n";

        UPDATE_CIUDAD = "UPDATE CIUDAD \n"
                + "SET NOMBRE=?\n"
                + "WHERE ID_CIUDAD=?";
    }
}

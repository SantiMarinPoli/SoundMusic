package co.com.soundMusic.Contacto.Ciudad;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CiudadDaoImpl implements ICiudadDao {

    //Conexion a la base de datos
    private final Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_CIUDADES;
    private static final String SELECT_CIUDAD_POR_ID;
    private static final String INSERT_CIUDAD;
    private static final String UPDATE_CIUDAD;

    public CiudadDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Ciudad> obtenerCiudades() throws SQLException {
        List<Ciudad> listaCiudades = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_CIUDADES);

        while (rs.next()) {
            Ciudad ciudad = new Ciudad(rs.getInt("ID_CIUDAD"), rs.getString("NOMBRE_CIUDAD"), rs.getInt("ID_PAIS"));
            ciudad.obtenerPais();
            listaCiudades.add(ciudad);
        }

        stmt.close();
        return listaCiudades;
    }

    @Override
    public Ciudad obtenerCiudad(int idCiudad) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_CIUDAD_POR_ID);
        ps.setInt(1, idCiudad);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Ciudad ciudad = new Ciudad(idCiudad, rs.getString("NOMBRE_CIUDAD"),
                    rs.getInt("ID_PAIS"));

            return ciudad;
        }

        return null;
    }

    @Override
    public void crearCiudad(Ciudad ciudad) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_CIUDAD);
        ps.setString(1, ciudad.getNombre());
        ps.setInt(2, ciudad.getIdPais());
        ps.executeUpdate();
    }

    @Override
    public void actualizarCiudad(Ciudad ciudad) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_CIUDAD);
        ps.setString(1, ciudad.getNombre());
        ps.setInt(2, ciudad.getIdCiudad());
        ps.executeUpdate();
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

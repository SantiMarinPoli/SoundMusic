package co.com.soundMusic.Contacto.Ciudad;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Pais.PaisDaoImpl;
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
    private Connection conexion;
    private PaisDaoImpl pais;

    public CiudadDaoImpl() {
        conexion = DBUtil.getConexion();
        pais = new PaisDaoImpl();
    }

    @Override
    public List<Ciudad> obtenerCiudades() throws SQLException {
        List<Ciudad> listaCiudades = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT ID_CIUDAD, NOMBRE, ID_PAIS \n" + "FROM CIUDAD;\n";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int idCiudad = rs.getInt("ID_CIUDAD");
            String nombre = rs.getString("NOMBRE");
            int idPais = rs.getInt("ID_PAIS");

            Ciudad ciudad = new Ciudad(idCiudad, nombre, idPais);

            listaCiudades.add(ciudad);
        }

        stmt.close();
        return listaCiudades;
    }

    @Override
    public Ciudad obtenerCiudad(int idCiudad) {
        String sql = "SELECT ID_CIUDAD, NOMBRE, ID_PAIS\n" + "FROM CIUDAD\n" + "WHERE ID_CIUDAD=?\n";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idCiudad);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("NOMBRE");
            int idPais = rs.getInt("ID_PAIS");

            Ciudad ciudad = new Ciudad(idCiudad, nombre, idPais);

            return ciudad;
        }

        return null;
    }

    @Override
    public void crearCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO CIUDAD (NOMBRE, ID_PAIS)\n" + "VALUES (?,?)\n";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, ciudad.getNombre());
        ps.setInt(2, ciudad.getIdPais());
        ps.executeUpdate();
    }

    @Override
    public void actualizarCiudad(Ciudad ciudad) {
        String sql = "UPDATE CIUDAD \n" + "SET NOMBRE=?, ID_PAIS=? \n" + "WHERE ID_CIUDAD=?\n";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, ciudad.getNombre());
        ps.setInt(2, ciudad.getIdPais());
        ps.setInt(3, ciudad.getIdCiudad());
        ps.executeUpdate();
    }

}
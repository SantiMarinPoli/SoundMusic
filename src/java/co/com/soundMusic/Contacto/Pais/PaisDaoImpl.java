package co.com.soundMusic.Contacto.Pais;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaisDaoImpl implements IPaisDao {

    private Connection conexion;

    public PaisDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @override
    public List<Pais> obtenerPaises() throws SQLException {
        List<Pais> listaPaises = new ArrayList<>();
        Statement stmt = conexion.createStatement();
        String sql = "SELECT ID_PAIS, NOMBRE\n" + "FROM PAIS\n";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int idPais = rs.getInt("ID_PAIS");
            String nombre = rs.getString("NOMBRE");

            Pais pais = new Pais(idPais, nombre);

            listaPaises.add(pais);
        }

        stmt.close();
        return listaPaises;
    }

    @override
    public Pais obtenerPais(int idPais) throws SQLException {
        String sql = "SELECT ID_PAIS, NOMBRE\n" + "FROM PAIS\n" + "WHERE ID_PAIS=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idPais);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("NOMBRE");
            Pais pais = new Pais(idPais, nombre);
            return pais;
        }

        return null;
    }

    @override
    public void crearPais(Pais pais) throws SQLException {
        String sql = "INSERT INTO PAIS (NOMBRE)\n" + "VALUES (?)\n";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, pais.getNombre());
        ps.executeUpdate();
    }

    @override
    public void actualizarPais(Pais pais) throws SQLException {
        String sql = "UPDATE PAIS" + "SET NOMBRE=?\n" + "WHERE ID_PAIS=?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, pais.getNombre());
        ps.setInt(2, pais.getIdPais());
        ps.executeUpdate();
    }
}
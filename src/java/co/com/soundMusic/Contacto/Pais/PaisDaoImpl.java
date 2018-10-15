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

    //Conexion a la base de datos
    private final Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_PAISES;
    private static final String SELECT_PAIS_POR_ID;
    private static final String INSERT_PAIS;
    private static final String UPDATE_PAIS;

    public PaisDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Pais> obtenerPaises() throws SQLException {
        List<Pais> listaPaises = new ArrayList<>();
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_PAISES);

        while (rs.next()) {
            int idPais = rs.getInt("ID_PAIS");
            String nombre = rs.getString("NOMBRE");

            Pais pais = new Pais(idPais, nombre);

            listaPaises.add(pais);
        }

        stmt.close();
        return listaPaises;
    }

    @Override
    public Pais obtenerPais(int idPais) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_PAIS_POR_ID);
        ps.setInt(1, idPais);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("NOMBRE");
            Pais pais = new Pais(idPais, nombre);
            return pais;
        }

        return null;
    }

    @Override
    public void crearPais(Pais pais) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_PAIS);
        ps.setString(1, pais.getNombre());
        ps.executeUpdate();
    }

    @Override
    public void actualizarPais(Pais pais) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_PAIS);
        ps.setString(1, pais.getNombre());
        ps.setInt(2, pais.getIdPais());
        ps.executeUpdate();
    }

    static {
        SELECT_PAISES = "SELECT ID_PAIS, NOMBRE\n"
                + "FROM PAIS\n"
                + "ORDER BY ID_PAIS";

        SELECT_PAIS_POR_ID = "SELECT ID_PAIS, NOMBRE\n"
                + "FROM PAIS\n"
                + "WHERE ID_PAIS=?";

        INSERT_PAIS = "INSERT INTO PAIS (NOMBRE)\n"
                + "VALUES (?)";

        UPDATE_PAIS = "UPDATE PAIS \n"
                + "SET NOMBRE=?\n"
                + "WHERE ID_PAIS=?";
    }
}

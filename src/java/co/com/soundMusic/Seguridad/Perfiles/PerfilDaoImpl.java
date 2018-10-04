package co.com.soundMusic.Seguridad.Perfiles;

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
public class PerfilDaoImpl implements IPerfilDao {

    private Connection conexion;

    public PerfilDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Perfil> obtenerPerfiles() throws SQLException {
        List<Perfil> listaPerfiles = new ArrayList<>();
        Statement stmt = conexion.createStatement();

        String sql = "SELECT ID_PERFIL, INOMBRE_PERFIL\n"
                + "FROM PERFIL ORDER BY ID_PERFIL \n";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            int idPerfil = Integer.parseInt(rs.getString("ID_PERFIL"));
            String nombrePerfil = rs.getString("NOMBRE_PERFIL");

            Perfil perfil = new Perfil(idPerfil, nombrePerfil);
            listaPerfiles.add(perfil);
        }

        stmt.close();
        return listaPerfiles;
    }

    @Override
    public Perfil obtenerPerfil(int idPerfil) throws SQLException {
        String sql = "SELECT NOMBRE_PERFIL\n"
                + "FROM PERFIL\n"
                + "WHERE= ID_PERFIL=?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idPerfil);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombrePerfil = rs.getString("NOMBRE_PERFIL");

            Perfil perfil = new Perfil(idPerfil, nombrePerfil);
            return perfil;
        }
        return null;
    }

    @Override
    public void crearPerfil(Perfil perfil) throws SQLException {
        String sql = "INSERT INTO PERFIL (NOMBRE_PERFIL)\n"
                + "VALUES (?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, perfil.getNombrePerfil());
        ps.executeUpdate();
    }

    @Override
    public void actualizarArtista(Perfil perfil) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

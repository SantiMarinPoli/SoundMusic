package co.com.soundMusic.Seguridad.PermisosYPerfiles;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}

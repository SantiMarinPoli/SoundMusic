package co.com.soundMusic.Seguridad.PermisosYPerfiles;

import co.com.soundMusic.Seguridad.PermisosYPerfiles.IPerfilPermisoDao;
import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class PerfilPermisoDaoImpl implements IPerfilPermisoDao {

    private Connection conexion;

    public PerfilPermisoDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<PerfilPermiso> obtenePerfilPermisos() throws SQLException {
        List<PerfilPermiso> listaPerfilPermiso = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT ID_PERFIL_PERMISO,ID_PERFIL,ID_PERMISO\n" + "FROM PERFIL_PERMISO";

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int idPerfilPermiso = rs.getInt("ID_PERFIL_PERMISO");
            int idPerfil = rs.getInt("ID_PERFIL");
            int idPermiso = rs.getInt("ID_PERMISO");

            PerfilPermiso prfilPermiso = new PerfilPermiso(idPerfilPermiso, idPerfil, idPermiso);
            listaPerfilPermiso.add(prfilPermiso);
        }
        stmt.close();
        return listaPerfilPermiso;
    }

    @Override
    public List<PerfilPermiso> obtenerPermisosDePerfil(int idPerfil) throws SQLException {
        List<PerfilPermiso> listaPermisosPorPerfil = new ArrayList<>();

        String sql = "SELECT ID_PERFIL_PERMISO,ID_PERFIL,ID_PERMISO\n" + "FROM PERFIL_PERMISO\n" + "WHERE ID_PERFIL=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idPerfil);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int idPerfilPermiso = rs.getInt("ID_PERFIL_PERMISO");
            int idPermiso = rs.getInt("ID_PERMISO");

            PerfilPermiso prfilPermiso = new PerfilPermiso(idPerfilPermiso, idPerfil, idPermiso);
            listaPermisosPorPerfil.add(prfilPermiso);
        }
        stmt.close();
        return listaPermisosPorPerfil;
    }
}
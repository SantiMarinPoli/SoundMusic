package co.com.soundMusic.Seguridad.Permisos;

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
public class PermisosDaoImpl implements IPermisosDao {

    private Connection conexion;

    public PermisosDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Permisos> obtenerPermisos() throws SQLException {
        List<Permisos> listaPermisos = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT NOMBRE_PERMISO\n" + "FROM PERMISO";

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int idPermisos = rs.getInt("ID_PERMISO");
            String nombrePermiso = rs.getString("NOMBRE_PERMISO");

            Permisos permisos = new Permisos(idPermisos, nombrePermiso);
            listaPermisos.add(permisos);
        }
        stmt.close();
        return listaPermisos;
    }

    @Override
    public Permisos obtenerPermiso(int idPermisos) throws SQLException {
        String sql = "SELECT NOMBRE_PERMISO\n"
                + "FROM PERMISO \n"
                + "WHERE ID_PERMISO=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idPermisos);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombrePermiso = rs.getString("NOMBRE_PERMISO");

            Permisos permisos = new Permisos(idPermisos, nombrePermiso);
            return permisos;
        }
        return null;
    }

    @Override
    public void crearPermiso(Permisos permisos) throws SQLException {
        String sql = "INSERT INTO PERMISO (NOMBRE_PERMISO)\n" + "VALUES (?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, permisos.getNombrePermiso());
        ps.executeUpdate();
    }

    @Override
    public void actualizarPermiso(Permisos permisos) throws SQLException {
        String sql = "UPDATE PERMISO \n" + "SET NOMBRE_PERMISO=? \n" + "WHERE ID_PERMISO=?";
        PreparedStatement ps= conexion.prepareStatement(sql);
        
        ps.setString(1, permisos.getNombrePermiso());
        ps.setInt(2, permisos.getIdPermiso());
        ps.executeUpdate();
    }

    @Override
    public void eliminarPermiso(int idPermiso) throws SQLException {
        String sql = "DELETE \n" + "FROM PERMISO \n" + "WHERE ID_PERMISO=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idPermiso);
        ps.executeUpdate();
    }

}

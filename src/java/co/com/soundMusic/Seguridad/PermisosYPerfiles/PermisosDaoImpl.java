package co.com.soundMusic.Seguridad.PermisosYPerfiles;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

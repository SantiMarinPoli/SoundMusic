package co.com.soundMusic.Seguridad.PermisosYPerfiles;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearPerfil(Perfil perfil) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarPerfil(int idPerfil) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarPerfil(Perfil perfil) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

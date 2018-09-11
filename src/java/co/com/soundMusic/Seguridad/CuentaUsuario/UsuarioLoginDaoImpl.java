package co.com.soundMusic.Seguridad.CuentaUsuario;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuarioLoginDaoImpl implements IUsuarioLoginDao{

    private Connection conexion;

    public UsuarioLoginDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public UsuarioLogin obtenerUsuarioLogin(int idUsuarioLogin) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearUsuarioLogin(UsuarioLogin usuarioLogin) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarUsuarioLogin(UsuarioLogin usuarioLogin) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package co.com.soundMusic.Seguridad.CuentaUsuario;

import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IUsuarioLoginDao {
    UsuarioLogin obtenerUsuarioLogin(int idUsuarioLogin) throws SQLException;
    void crearUsuarioLogin (UsuarioLogin usuarioLogin) throws SQLException;
    void actualizarUsuarioLogin (UsuarioLogin usuarioLogin) throws SQLException;
}

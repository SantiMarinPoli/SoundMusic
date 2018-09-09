package co.com.soundMusic.Seguridad.Usuario;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IUsuarioDao {
    List<Usuario> obtenerUsuarios() throws SQLException;
    Usuario obtenerUsuario (int idUsuario) throws SQLException;
    void crearUsuario(Usuario usuario) throws SQLException;
    void eliminarUsuario (int idUsuario) throws SQLException;
    void actualizarUsuario (Usuario usuario) throws SQLException;
}

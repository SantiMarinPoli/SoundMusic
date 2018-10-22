package co.com.soundMusic.Login.CuentaUsuario;


/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IUsuarioLoginDao {

    UsuarioLogin obtenerUsuarioLogin(int idUsuarioLogin);

    void crearUsuarioLogin(UsuarioLogin usuarioLogin);

    void actualizarUsuarioLogin(UsuarioLogin usuarioLogin);
}

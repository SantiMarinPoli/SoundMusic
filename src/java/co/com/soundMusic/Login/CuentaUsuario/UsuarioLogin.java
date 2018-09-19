package co.com.soundMusic.Login.CuentaUsuario;


/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuarioLogin {

    private int idUsuarioLogin;
    private String nombreUsuario;
    private String contrasena;

    public UsuarioLogin() {
    }

    public UsuarioLogin(int idUsuarioLogin, String nombreUsuario, String contrasena) {
        this.idUsuarioLogin = idUsuarioLogin;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;        
    }

    public int getIdUsuarioLogin() {
        return idUsuarioLogin;
    }

    public void setIdUsuarioLogin(int idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

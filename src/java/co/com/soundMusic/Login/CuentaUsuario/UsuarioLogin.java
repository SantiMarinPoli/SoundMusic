package co.com.soundMusic.Login.CuentaUsuario;

import java.sql.Date;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuarioLogin {

    private int idUsuarioLogin;
    private String nombreUsuario;
    private String contrasena;
    private Date fechaRegistro;

    public UsuarioLogin() {
    }

    public UsuarioLogin(int idUsuarioLogin, String nombreUsuario, String contrasena, Date fechaRegistro) {
        this.idUsuarioLogin = idUsuarioLogin;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}

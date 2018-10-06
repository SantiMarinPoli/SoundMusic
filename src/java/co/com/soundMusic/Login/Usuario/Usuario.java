package co.com.soundMusic.Login.Usuario;

import co.com.soundMusic.Login.CuentaUsuario.UsuarioLoginDaoImpl;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Usuario {

    private int idUsuario;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaCreacion;
    private String status;
    private String genero;
    private int idPerfil;
    private int idUsuarioLogin;
    private int idContacto;

    public Usuario() {
    }

    public Usuario(int idUsuario, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Date fechaCreacion, String status, String genero, int idPerfil, int idUsuarioLogin, int idContacto) {
        this.idUsuario = idUsuario;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.genero = genero;
        this.idPerfil = idPerfil;
        this.idUsuarioLogin = idUsuarioLogin;
        this.idContacto = idContacto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getIdUsuarioLogin() {
        return idUsuarioLogin;
    }

    public void setIdUsuarioLogin(int idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setidPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idUsuario;
        hash = 61 * hash + Objects.hashCode(this.primerNombre);
        hash = 61 * hash + Objects.hashCode(this.primerApellido);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.primerNombre, other.primerNombre)) {
            return false;
        }
        if (!Objects.equals(this.primerApellido, other.primerApellido)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario
                + ", primerNombre=" + primerNombre
                + ", segundoNombre=" + segundoNombre
                + ", primerApellido=" + primerApellido
                + ", segundoApellido=" + segundoApellido
                + ", fechaCreacion=" + fechaCreacion
                + ", status=" + status + '}';
    }

    public boolean ingresarUsuario(String nom_usuario, String password_us) throws SQLException {
        UsuarioLoginDaoImpl usuarioLogin = new UsuarioLoginDaoImpl();
        return usuarioLogin.sesionPermitida(nom_usuario, password_us);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

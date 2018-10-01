package co.com.soundMusic.Login.Usuario;

import java.sql.Date;
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
    private int idPerfil;
    private int idUsuarioLogin;
    private int idContacto;

    public Usuario() {
    }

    public Usuario(int idUsuario, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido, Date fechaCreacion,
            String status, int idPerfil, int idUsuarioLogin, int idContacto) {
        this.idUsuario = idUsuario;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.idPerfil = idPerfil;
        this.idUsuarioLogin = idUsuarioLogin;
        this.idContacto = idContacto;
    }

    public Usuario(int idUsuario, String[] datosUsuario, Date fechaCreacion) {
        this.idUsuario = idUsuario;
        this.primerNombre = datosUsuario[0];
        this.segundoNombre = datosUsuario[1];
        this.primerApellido = datosUsuario[2];
        this.segundoApellido = datosUsuario[3];
        this.fechaCreacion = fechaCreacion;
        this.status = datosUsuario[4];
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

    boolean ingresarUsuario(String nom_usuario, String password_us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package co.com.soundMusic.Seguridad.Usuario;

import co.com.soundMusic.Contacto.Contacto;
import java.sql.Date;

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
    private Contacto contacto;

    public Usuario() {
    }

    public Usuario(int idUsuario, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Date fechaCreacion, String status, Contacto contacto) {
        this.idUsuario = idUsuario;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.contacto = contacto;
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

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.idUsuario;
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

}

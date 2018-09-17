package co.com.soundMusic.LogAuditoria;

import co.com.soundMusic.Seguridad.Permisos.Permisos;
import co.com.soundMusic.Login.Usuario.Usuario;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class LogAuditoria {

    private int idLogAuditoria;
    private Date fecha;
    private Time hora;
    private Usuario usuario;
    private Permisos operaciones;

    public LogAuditoria() {
    }

    public LogAuditoria(int idLogAuditoria, Date fecha, Time hora, Usuario usuario, Permisos operaciones) {
        this.idLogAuditoria = idLogAuditoria;
        this.fecha = fecha;
        this.hora = hora;
        this.usuario = usuario;
        this.operaciones = operaciones;
    }

    public int getIdLogAuditoria() {
        return idLogAuditoria;
    }

    public void setIdLogAuditoria(int idLogAuditoria) {
        this.idLogAuditoria = idLogAuditoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Permisos getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(Permisos operaciones) {
        this.operaciones = operaciones;
    }

}

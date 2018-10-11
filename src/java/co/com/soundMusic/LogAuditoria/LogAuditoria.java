package co.com.soundMusic.LogAuditoria;

import co.com.soundMusic.Seguridad.Permisos.Permisos;
import co.com.soundMusic.Login.Usuario.Usuario;
import co.com.soundMusic.Seguridad.Permisos.PermisosDaoImpl;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private int idPermiso;

    public LogAuditoria() {
    }

    public LogAuditoria(int idLogAuditoria, Date fecha, Time hora, Usuario usuario,
            int idPermiso) {
        this.idLogAuditoria = idLogAuditoria;
        this.fecha = fecha;
        this.hora = hora;
        this.usuario = usuario;
        this.idPermiso = idPermiso;
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

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void obtenerPermiso() {
        PermisosDaoImpl daoPermisos = new PermisosDaoImpl();
        try {
            this.setOperaciones(daoPermisos.obtenerPermiso(this.idPermiso));
        } catch (SQLException ex) {
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String fechaYHora() {
        String fechaYHora = this.fecha + " " + this.hora;
        return fechaYHora;
    }
}

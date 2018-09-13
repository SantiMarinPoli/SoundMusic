package co.com.soundMusic.EmpresaDifusora;

import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividad;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.TipoEmpresaDifusora;
import java.sql.Date;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class EmpresaDifusora {
    private int idEmpresaDifusora;
    private String nombre;
    private Date fechaCreacion;
    private Date fechaTerminacion;
    private String status;
    private TipoEmpresaDifusora tipoActividad;
    private CostoActividad costoOperacion;
    private Contacto contacto; 

    public EmpresaDifusora() {
    }

    public EmpresaDifusora(int idEmpresaDifusora, String nombre, Date fechaCreacion, 
            Date fechaTerminacion, String status, TipoEmpresaDifusora tipoActividad, 
            CostoActividad costoOperacion, Contacto contacto) {
        this.idEmpresaDifusora = idEmpresaDifusora;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaTerminacion = fechaTerminacion;
        this.status = status;
        this.tipoActividad = tipoActividad;
        this.costoOperacion = costoOperacion;
        this.contacto = contacto;
    }

    public int getIdEmpresaDifusora() {
        return idEmpresaDifusora;
    }

    public void setIdEmpresaDifusora(int idEmpresaDifusora) {
        this.idEmpresaDifusora = idEmpresaDifusora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipoEmpresaDifusora getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoEmpresaDifusora tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public CostoActividad getCostoOperacion() {
        return costoOperacion;
    }

    public void setCostoOperacion(CostoActividad costoOperacion) {
        this.costoOperacion = costoOperacion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
   
    
}

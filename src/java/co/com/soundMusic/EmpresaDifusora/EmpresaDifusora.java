package co.com.soundMusic.EmpresaDifusora;

import java.sql.Date;
import java.util.Objects;

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
    private int idTipoActividad;
    private int idContacto;
    private int idCostoOperacion;

    public EmpresaDifusora() {
    }

    public EmpresaDifusora(int idEmpresaDifusora, String nombre, Date fechaCreacion, Date fechaTerminacion,
            String status, int idTipoActividad, int idContacto, int idCostoOperacion) {
        this.idEmpresaDifusora = idEmpresaDifusora;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaTerminacion = fechaTerminacion;
        this.status = status;
        this.idTipoActividad = idTipoActividad;
        this.idContacto = idContacto;
        this.idCostoOperacion = idCostoOperacion;
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

    public int getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setTipoActividad(int idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public int getIdCostoOperacion() {
        return idCostoOperacion;
    }

    public void setIdCostoOperacion(int idCostoOperacion) {
        this.idCostoOperacion = idCostoOperacion;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.idEmpresaDifusora;
        hash = 13 * hash + Objects.hashCode(this.nombre);
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
        final EmpresaDifusora other = (EmpresaDifusora) obj;
        if (this.idEmpresaDifusora != other.idEmpresaDifusora) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}

package co.com.soundMusic.EmpresaDifusora;

import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresa;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresaDaoImpl;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String rutaImagen;
    private int idTipoActividad;
    private int idContacto;
    private int idCostoOperacion;

    public EmpresaDifusora() {
    }

    public EmpresaDifusora(int idEmpresaDifusora, String nombre, Date fechaCreacion, Date fechaTerminacion,
            String status, String rutaImagen, int idTipoActividad, int idContacto, int idCostoOperacion) {
        this.idEmpresaDifusora = idEmpresaDifusora;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaTerminacion = fechaTerminacion;
        this.status = status;
        this.rutaImagen = rutaImagen;
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

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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

    public int getNumeroArtistas() {
        int numeroArtistas = 0;
        ArtistaEmpresaDaoImpl daoArtistaEmpresa = new ArtistaEmpresaDaoImpl();
        try {
            List<ArtistaEmpresa> lstArtistaEmpresa = daoArtistaEmpresa.obtenerNumeroDeArtistas(this.idEmpresaDifusora);

            if (!lstArtistaEmpresa.isEmpty()) {

                return lstArtistaEmpresa.size();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDifusora.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numeroArtistas;
    }
}

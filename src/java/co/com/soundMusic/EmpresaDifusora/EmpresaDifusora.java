package co.com.soundMusic.EmpresaDifusora;

import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividad;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.TipoEmpresaDifusora;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresa;
import co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa.ArtistaEmpresaDaoImpl;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class EmpresaDifusora {

    private Integer idEmpresaDifusora;
    private String nombre;
    private Date fechaCreacion;
    private Date fechaTerminacion;
    private String status;
    private String rutaImagen;
    private Integer idTipoActividad;
    private Integer idContacto;
    private Integer idCostoOperacion;
    private Contacto contacto;
    private TipoEmpresaDifusora tipoActividad;
    private CostoActividad costoOperacion;

    public EmpresaDifusora() {
    }

    public EmpresaDifusora(Integer idEmpresaDifusora, String nombre, Date fechaCreacion, Date fechaTerminacion,
            String status, String rutaImagen, Integer idTipoActividad, Integer idContacto, Integer idCostoOperacion) {
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

    public Integer getIdEmpresaDifusora() {
        return idEmpresaDifusora;
    }

    public void setIdEmpresaDifusora(Integer idEmpresaDifusora) {
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

    public Integer getIdTipoActividad() {
        return idTipoActividad;
    }

    public void setTipoActividad(Integer idTipoActividad) {
        this.idTipoActividad = idTipoActividad;
    }

    public Integer getIdCostoOperacion() {
        return idCostoOperacion;
    }

    public void setIdCostoOperacion(Integer idCostoOperacion) {
        this.idCostoOperacion = idCostoOperacion;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
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

    public Integer getNumeroArtistas() {
        ArtistaEmpresaDaoImpl daoArtistaEmpresa = new ArtistaEmpresaDaoImpl(true);
        List<ArtistaEmpresa> lstArtistaEmpresa = daoArtistaEmpresa.obtenerNumeroDeArtistas(this.idEmpresaDifusora);
        if (!lstArtistaEmpresa.isEmpty()) {
            return lstArtistaEmpresa.size();
        }
        return 0;
    }

}

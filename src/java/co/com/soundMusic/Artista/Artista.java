package co.com.soundMusic.Artista;

import co.com.soundMusic.Contacto.Contacto;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Artista {

    private int idArtista;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreArtistico;
    private String genero;
    private int totalCanciones;
    private Date fechaCreacion;
    private String status;
    private Contacto contacto;

    public Artista() {
    }

    public Artista(int idArtista, String primerNombre, String segundoNombre,
            String primerApellido, String segundoApellido,
            String nombreArtistico, String genero, int totalCanciones,
            Date fechaCreacion, String status, Contacto contacto) {
        this.idArtista = idArtista;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombreArtistico = nombreArtistico;
        this.genero = genero;
        this.totalCanciones = totalCanciones;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.contacto = contacto;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
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

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTotalCanciones() {
        return totalCanciones;
    }

    public void setTotalCanciones(int totalCanciones) {
        this.totalCanciones = totalCanciones;
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

    public void setContacto(String direccion) {
        this.contacto = new Contacto(direccion);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.nombreArtistico);
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
        final Artista other = (Artista) obj;
        if (!Objects.equals(this.nombreArtistico, other.nombreArtistico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Artista{" + "idArtista=" + idArtista
                + ", primerNombre=" + primerNombre
                + ", segundoNombre=" + segundoNombre
                + ", primerApellido=" + primerApellido
                + ", segundoApellido=" + segundoApellido
                + ", nombreArtistico=" + nombreArtistico
                + ", genero=" + genero
                + ", totalCanciones=" + totalCanciones
                + ", fechaCreacion=" + fechaCreacion
                + ", status=" + status + '}';
    }
}

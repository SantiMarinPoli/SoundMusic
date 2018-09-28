package co.com.soundMusic.Artista;

import co.com.soundMusic.Contacto.Contacto;
import java.sql.Date;

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
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private String status;
    private Contacto contacto;

    public Artista(int idArtista, String[] datosArtista, Date[] fechasArtista, Contacto contacto) {
        this.idArtista = idArtista;
        this.primerNombre = datosArtista[0];
        this.segundoNombre = datosArtista[1];
        this.primerApellido = datosArtista[2];
        this.segundoApellido = datosArtista[3];
        this.nombreArtistico = datosArtista[4];
        this.genero = datosArtista[5];
        this.fechaNacimiento = fechasArtista[0];
        this.fechaCreacion = fechasArtista[1];
        this.status = datosArtista[6];
        this.contacto = contacto;
    }
    
    public Artista(int idArtista, String[] datosArtista) {
        this.idArtista = idArtista;
        this.primerNombre = datosArtista[0];
        this.segundoNombre = datosArtista[1];
        this.primerApellido = datosArtista[2];
        this.segundoApellido = datosArtista[3];
        this.nombreArtistico = datosArtista[4];
        this.genero = datosArtista[5];        
        this.status = datosArtista[6];        
    }

    public Artista() {
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
}

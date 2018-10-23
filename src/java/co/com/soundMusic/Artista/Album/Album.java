package co.com.soundMusic.Artista.Album;

import co.com.soundMusic.Artista.Artista;
import co.com.soundMusic.Artista.ArtistaDaoImpl;
import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
import java.sql.Date;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Album {

    private int idAlbum;
    private String nombre;
    private int numeroCanciones;
    private Date fechaFinalizacion;
    private String rutaImagen;
    private int idCiudad;
    private int idArtista;
    private Artista artista;
    private Ciudad ciudad;

    public Album() {
    }

    public Album(int idAlbum, String nombre, int numeroCanciones, Date fechaFinalizacion,
            String rutaImagen, int idCiudad, int idArtista) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.numeroCanciones = numeroCanciones;
        this.fechaFinalizacion = fechaFinalizacion;
        this.rutaImagen = rutaImagen;
        this.idCiudad = idCiudad;
        this.idArtista = idArtista;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getRutaImagen() {
        return this.rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void obtenerArtista() {
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl(true);
        this.setArtista(daoArtista.obtenerArtista(this.idArtista));
    }

    public void obtenerCiudad() {
        CiudadDaoImpl daoCiudad = new CiudadDaoImpl(true);
        this.setCiudad(daoCiudad.obtenerCiudad(this.idCiudad));
    }
}

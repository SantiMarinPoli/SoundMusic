package co.com.soundMusic.Artista.Album;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
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
    private String estado;
    private Ciudad ciudad;
    private Artista artista;    

    public Album() {
    }

    public Album(int idAlbum, String nombre, int numeroCanciones, Date fechaFinalizacion, String estado, Ciudad ciudad, artista artista) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.numeroCanciones = numeroCanciones;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estado=estado;
        this.ciudad = ciudad;
        this.artista=artista;
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

    public String geetEstado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    public Artista getArtista(){
        return artista;
    }
 
    public void setArtista(Artista artista){
        this.artista=artista;
    }
    
}

package co.com.soundMusic.Artista;

import co.com.soundMusic.Negocio.Logros.Logro;
import java.sql.Date;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class LogroArtista {

    private int idLogroArtista;
    private Logro logro;
    private Artista artista;
    private Date fechaPremiacion;

    public LogroArtista() {
    }

    public LogroArtista(int idLogroArtista, Logro logro, Artista artista, Date fechaPremiacion) {
        this.idLogroArtista = idLogroArtista;
        this.logro = logro;
        this.artista = artista;
        this.fechaPremiacion = fechaPremiacion;
    }

    public int getIdLogroArtista() {
        return idLogroArtista;
    }

    public void setIdLogroArtista(int idLogroArtista) {
        this.idLogroArtista = idLogroArtista;
    }

    public Logro getLogro() {
        return logro;
    }

    public void setLogro(Logro logro) {
        this.logro = logro;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Date getFechaPremiacion() {
        return fechaPremiacion;
    }

    public void setFechaPremiacion(Date fechaPremiacion) {
        this.fechaPremiacion = fechaPremiacion;
    }

}

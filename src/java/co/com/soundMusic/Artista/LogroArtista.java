package co.com.soundMusic.Artista;

import java.sql.Date;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class LogroArtista {

    private int idLogroArtista;
    private int idLogro;
    private int idArtista;
    private Date fechaPremiacion;

    public LogroArtista() {
    }

    public LogroArtista(int idLogroArtista, int idLogro, int idArtista, Date fechaPremiacion) {
        this.idLogroArtista = idLogroArtista;
        this.idLogro = idLogro;
        this.idArtista = idArtista;
        this.fechaPremiacion = fechaPremiacion;
    }

    public int getIdLogroArtista() {
        return idLogroArtista;
    }

    public void setIdLogroArtista(int idLogroArtista) {
        this.idLogroArtista = idLogroArtista;
    }

    public int getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(int idLogro) {
        this.idLogro = idLogro;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public Date getFechaPremiacion() {
        return fechaPremiacion;
    }

    public void setFechaPremiacion(Date fechaPremiacion) {
        this.fechaPremiacion = fechaPremiacion;
    }

}

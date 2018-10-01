package co.com.soundMusic.Negocio.Logros.LogroArtista;

import co.com.soundMusic.Artista.Artista;
import co.com.soundMusic.Negocio.Logros.Logro;
import java.sql.Date;

/**
 *
 * @author Santiago Meidna Peláez
 */
public class LogroArtista {

    private int logroArtista;
    private Logro logro;
    private Artista artista;
    private Date fechaTerminacion;

    public LogroArtista() {
    }

    public LogroArtista(int logroArtista, Logro logro, Artista artista, Date fechaTerminacion) {
        this.logroArtista = logroArtista;
        this.logro = logro;
        this.artista = artista;
        this.fechaTerminacion = fechaTerminacion;
    }

    public int getLogroArtista() {
        return logroArtista;
    }

    public void setLogroArtista(int logroArtista) {
        this.logroArtista = logroArtista;
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

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

}

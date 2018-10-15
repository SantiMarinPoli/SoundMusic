package co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa;

import co.com.soundMusic.Artista.Artista;
import co.com.soundMusic.Artista.ArtistaDaoImpl;
import co.com.soundMusic.EmpresaDifusora.EmpresaDifusora;
import co.com.soundMusic.EmpresaDifusora.EmpresaDifusoraDaoImpl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ArtistaEmpresa {

    private int idArtistaEmpresa;
    private int idArtista;
    private int idEmpresaDifusora;
    private Artista artista;
    private EmpresaDifusora empresaDifusora;

    public ArtistaEmpresa() {
    }

    public ArtistaEmpresa(int idArtistaEmpresa) {
        this.idArtistaEmpresa = idArtistaEmpresa;
    }

    public ArtistaEmpresa(int idArtistaEmpresa, int idArtista, int idEmpresaDifusora) {
        this.idArtistaEmpresa = idArtistaEmpresa;
        this.idArtista = idArtista;
        this.idEmpresaDifusora = idEmpresaDifusora;
    }

    public int getIdArtistaEmpresa() {
        return idArtistaEmpresa;
    }

    public void setIdArtistaEmpresa(int idArtistaEmpresa) {
        this.idArtistaEmpresa = idArtistaEmpresa;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public EmpresaDifusora getEmpresaDifusora() {
        return empresaDifusora;
    }

    public void setEmpresaDifusora(EmpresaDifusora empresaDifusora) {
        this.empresaDifusora = empresaDifusora;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public int getIdEmpresaDifusora() {
        return idEmpresaDifusora;
    }

    public void setIdEmpresaDifusora(int idEmpresaDifusora) {
        this.idEmpresaDifusora = idEmpresaDifusora;
    }

    public void obtenerArtista() {
        ArtistaDaoImpl daoArtista = new ArtistaDaoImpl();
        try {
            this.setArtista(daoArtista.obtenerArtista(this.idArtista));
        } catch (SQLException ex) {
            Logger.getLogger(ArtistaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void obtenerEmpresa() {
        EmpresaDifusoraDaoImpl daoEmpresa = new EmpresaDifusoraDaoImpl();
        try {
            this.setEmpresaDifusora(daoEmpresa.obtenerEmpresaDifusora(this.idEmpresaDifusora));
        } catch (SQLException ex) {
            Logger.getLogger(ArtistaEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

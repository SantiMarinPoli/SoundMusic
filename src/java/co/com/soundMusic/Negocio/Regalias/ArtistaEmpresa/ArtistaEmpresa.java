package co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa;

import co.com.soundMusic.Artista.Artista;
import co.com.soundMusic.EmpresaDifusora.EmpresaDifusora;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ArtistaEmpresa {

    private int idArtistaEmpresa;
    private Artista artista;
    private EmpresaDifusora empresaDifusora;

    public ArtistaEmpresa() {
    }

    public ArtistaEmpresa(int idArtistaEmpresa, Artista artista, EmpresaDifusora empresaDifusora) {
        this.idArtistaEmpresa = idArtistaEmpresa;
        this.artista = artista;
        this.empresaDifusora = empresaDifusora;
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

}

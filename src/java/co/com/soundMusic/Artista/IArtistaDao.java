package co.com.soundMusic.Artista;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IArtistaDao {
    
    List<Artista> obtenerArtistas() throws SQLException;
    Artista obtenerArtista (int idArtista) throws SQLException;
    void crearArtista(Artista artista) throws SQLException;
    void eliminarArtista (int idArtista) throws SQLException;
    void actualizarArtista (Artista artista) throws SQLException;
}

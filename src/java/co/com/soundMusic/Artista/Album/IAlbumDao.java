package co.com.soundMusic.Artista.Album;

import java.sql.SQLException;
import java.util.List;

public interface IAlbumDao {

    List<Album> obtenerAlbumes();

    Album obtenerAlbum(int idAlbum);

    void crearAlbum(Album album);

    void actualizarAlbum(Album album);

}

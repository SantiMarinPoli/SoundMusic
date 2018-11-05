package co.com.soundMusic.Artista.Album;

import java.util.List;

public interface IAlbumDao {

    List<Album> obtenerAlbumes();

    Album obtenerAlbum(int idAlbum);

    int crearAlbum(Album album);

    void actualizarAlbum(Album album);

}

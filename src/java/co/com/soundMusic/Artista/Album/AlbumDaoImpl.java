package java.co.com.soundMusic.Artista.Album;

import co.com.soundMusic.utilidades.DBUtil;
import java.co.com.soundMusic.Contacto.Ciudad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class AlbumDaoImpl implements IAlbumDao {
    private Connection conexion;
    private CiudadDaoImpl ciudad;
    private ArtistaDaoImpl artista;

    public AlbumDaoImpl() {
        conexion = DBUtil.getConexion();
        ciudad = new CiudadDaoImpl();
        artista = new ArtistaDaoImpl();
    }

    @Override
    public List<Album> obtenerAlbumes(int idUsuario) throws SQLException {
    }

    @Override
    public Album obtenerAlbum(int idAlbum) throws SQLException {
    }

    @Override
    void crearAlbum(Album album) throws SQLException {
    }

    @Override
    public void actualizarAlbum(Album album) throws SQLException {
    }
}
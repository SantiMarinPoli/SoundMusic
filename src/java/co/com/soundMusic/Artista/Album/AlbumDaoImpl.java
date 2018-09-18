package co.com.soundMusic.Artista.Album;

import co.com.soundMusic.Artista.ArtistaDaoImpl;
import co.com.soundMusic.utilidades.DBUtil;
import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Album obtenerAlbum(int idAlbum) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearAlbum(Album album) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarAlbum(Album album) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
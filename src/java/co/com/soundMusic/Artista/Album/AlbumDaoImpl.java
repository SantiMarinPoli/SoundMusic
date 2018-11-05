package co.com.soundMusic.Artista.Album;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class AlbumDaoImpl implements IAlbumDao {

    //Conexion a la base de datos
    private Connection conexion;
    private Boolean isProduction = true;
    private Statement stmt;
    private ResultSet rs;
    //Constantes con las querys a la base de datos
    private static final String SELECT_ALBUMES;
    private static final String SELECT_ALBUM_POR_ID;
    private static final String INSERT_ALBUM;
    private static final String UPDATE_ALBUM;

    public AlbumDaoImpl(Boolean production) {
        isProduction = production;
    }

    @Override
    public List<Album> obtenerAlbumes() {
        getConexion();
        List<Album> listaAlbumes = new ArrayList<>();
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SELECT_ALBUMES);

            while (rs.next()) {
                Album album = new Album();
                album.setIdAlbum(rs.getInt("ID_ALBUM"));
                album.setNombre(rs.getString("NOMBRE"));
                album.setNumeroCanciones(rs.getInt("NUMERO_CANCIONES"));
                album.setFechaFinalizacion(rs.getDate("FECHA_FINALIZACION"));
                album.setRutaImagen(validacion(rs.getString("RUTA_IMAGEN")));
                album.getCiudad().setIdCiudad(rs.getInt("ID_CIUDAD"));
                album.getArtista().setIdArtista(rs.getInt("ID_ARTISTA"));
                album.getArtista().setNombreArtistico(rs.getString("NOMBRE_ARTISTICO"));

                listaAlbumes.add(album);
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(AlbumDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
        return listaAlbumes;
    }

    @Override
    public Album obtenerAlbum(int idAlbum) {
        getConexion();
        Album album = new Album();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_ALBUM_POR_ID);
            ps.setInt(1, idAlbum);
            rs = ps.executeQuery();

            while (rs.next()) {
                album.setIdAlbum(idAlbum);
                album.setNombre(rs.getString("NOMBRE"));
                album.setNumeroCanciones(rs.getInt("NUMERO_CANCIONES"));
                album.setFechaFinalizacion(rs.getDate("FECHA_FINALIZACION"));
                album.setRutaImagen(validacion(rs.getString("RUTA_IMAGEN")));
                album.getCiudad().setIdCiudad(rs.getInt("ID_CIUDAD"));
                album.getArtista().setIdArtista(rs.getInt("ID_ARTISTA"));
                album.getArtista().setNombreArtistico(rs.getString("NOMBRE_ARTISTICO"));

                return album;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(AlbumDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
        return album;
    }

    @Override
    public void crearAlbum(Album album) {
        getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_ALBUM);
            ps.setString(1, album.getNombre());
            ps.setInt(2, album.getNumeroCanciones());
            ps.setDate(3, album.getFechaFinalizacion());
            ps.setString(4, album.getRutaImagen());
            ps.setInt(5, album.getCiudad().getIdCiudad());
            ps.setInt(6, album.getArtista().getIdArtista());
            ps.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(AlbumDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
    }

    @Override
    public void actualizarAlbum(Album album) {
        getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_ALBUM);
            ps.setString(1, album.getNombre());
            ps.setInt(2, album.getNumeroCanciones());
            ps.setDate(3, album.getFechaFinalizacion());
            ps.setString(4, album.getRutaImagen());
            ps.setInt(5, album.getCiudad().getIdCiudad());
            ps.setInt(6, album.getArtista().getIdArtista());
            ps.executeUpdate();
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(AlbumDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
    }

    static {
        SELECT_ALBUMES = "SELECT AL.ID_ALBUM,AL.NOMBRE,AL.NUMERO_CANCIONES,AL.FECHA_FINALIZACION,\n"
                + "AL.RUTA_IMAGEN, AL.ID_CIUDAD, AL.ID_ARTISTA, AR.NOMBRE_ARTISTICO \n"
                + "FROM ALBUM AL INNER JOIN ARTISTA AR \n"
                + "ON AL.ID_ARTISTA = AR.ID_ARTISTA \n"
                + "ORDER BY ID_ALBUM";

        SELECT_ALBUM_POR_ID = "SELECT AL.ID_ALBUM,AL.NOMBRE,AL.NUMERO_CANCIONES,AL.FECHA_FINALIZACION,\n"
                + "AL.RUTA_IMAGEN, AL.ID_CIUDAD, AL.ID_ARTISTA, AR.NOMBRE_ARTISTICO \n"
                + "FROM ALBUM AL INNER JOIN ARTISTA AR \n"
                + "ON AL.ID_ARTISTA = AR.ID_ARTISTA \n"
                + "WHERE ID_ALBUM=?";

        INSERT_ALBUM = "INSERT INTO ALBUM (NOMBRE, NUMERO_CANCIONES, FECHA_FINALIZACION,\n"
                + "RUTA_IMAGEN, ID_CIUDAD, ID_ARTISTA) \n"
                + "VALUES (?,?,?,?,?,?)";

        UPDATE_ALBUM = "UPDATE ALBUM \n"
                + "SET NOMBRE=?, NUMERO_CANCIONES=?, FECHA_FINALIZACION=?,\n"
                + "RUTA_IMAGEN=?, ID_CIUDAD=?, ID_ARTISTA=? \n"
                + "WHERE ID_ALBUM=?";
    }

    private String validacion(String aValidar) {
        if (aValidar != null) {
            return aValidar.trim();
        } else {
            return "";
        }
    }

    private void getConexion() {
        if (isProduction) {
            conexion = DBUtil.getConexion();
        } else {
            conexion = DBUtil.getTestConexion();
        }
        stmt = null;
        rs = null;
    }
}

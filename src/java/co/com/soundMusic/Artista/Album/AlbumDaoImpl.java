package co.com.soundMusic.Artista.Album;

import co.com.soundMusic.utilidades.DBUtil;
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

    //Conexion a la base de datos
    private final Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_ALBUMES;
    private static final String SELECT_ALBUM_POR_ID;
    private static final String INSERT_ALBUM;
    private static final String UPDATE_ALBUM;

    public AlbumDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Album> obtenerAlbumes(int idUsuario) throws SQLException {
        List<Album> listaAlbumes = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_ALBUMES);

        while (rs.next()) {
            int idAlbum = rs.getInt("ID_ALBUM");
            String nombre = rs.getString("NOMBRE");
            int numeroCanciones = rs.getInt("NUMERO_CANCIONES");
            Date fechaFinalizacion = rs.getDate("FECHA_FINALIZACION");
            String rutaImagen = rs.getString("RUTA_IMAGEN");
            int idCiudad = rs.getInt("ID_CIUDAD");
            int idArtista = rs.getInt("ID_ARTISTA");

            Album album = new Album(idAlbum, nombre, numeroCanciones,
                    fechaFinalizacion, rutaImagen, idCiudad, idArtista);

            listaAlbumes.add(album);
        }
        stmt.close();
        return listaAlbumes;
    }

    @Override
    public Album obtenerAlbum(int idAlbum) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_ALBUM_POR_ID);
        ps.setInt(1, idAlbum);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("NOMBRE");
            int numeroCanciones = rs.getInt("NUMERO_CANCIONES");
            Date fechaFinalizacion = rs.getDate("FECHA_FINALIZACION");
            String rutaImagen = rs.getString("RUTA_IMAGEN");
            int idCiudad = rs.getInt("ID_CIUDAD");
            int idArtista = rs.getInt("ID_ARTISTA");

            Album album = new Album(idAlbum, nombre, numeroCanciones,
                    fechaFinalizacion, rutaImagen, idCiudad, idArtista);

            return album;
        }

        return null;
    }

    @Override
    public void crearAlbum(Album album) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_ALBUM);
        ps.setString(1, album.getNombre());
        ps.setInt(2, album.getNumeroCanciones());
        ps.setDate(3, album.getFechaFinalizacion());
        ps.setString(4, album.getRutaImagen());
        ps.setInt(5, album.getIdCiudad());
        ps.setInt(6, album.getIdArtista());
        ps.executeUpdate();
    }

    @Override
    public void actualizarAlbum(Album album) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_ALBUM);
        ps.setString(1, album.getNombre());
        ps.setInt(2, album.getNumeroCanciones());
        ps.setDate(3, album.getFechaFinalizacion());
        ps.setString(4, album.getRutaImagen());
        ps.setInt(5, album.getIdCiudad());
        ps.setInt(6, album.getIdArtista());
        ps.executeUpdate();
    }

    static {
        SELECT_ALBUMES = "SELECT ID_ALBUM,NOMBRE,NUMERO_CANCIONES,FECHA_FINALIZACION,\n"
                + "RUTA_IMAGEN, ID_CIUDAD, ID_ARTISTA \n"
                + "FROM ALBUM \n"
                + "ORDER BY ID_ALBUM";

        SELECT_ALBUM_POR_ID = "SELECT NOMBRE,NUMERO_CANCIONES,FECHA_FINALIZACION,\n"
                + "RUTA_IMAGEN, ID_CIUDAD, ID_ARTISTA \n"
                + "FROM ALBUM\n"
                + "WHERE ID_ALBUM=?";

        INSERT_ALBUM = "INSERT INTO ALBUM (NOMBRE, NUMERO_CANCIONES, FECHA_FINALIZACION,\n"
                + "RUTA_IMAGEN, ID_CIUDAD, ID_ARTISTA) \n"
                + "VALUES (?,?,?,?,?,?)";

        UPDATE_ALBUM = "UPDATE ALBUM \n"
                + "SET NOMBRE=?, NUMERO_CANCIONES=?, FECHA_FINALIZACION=?,\n"
                + "RUTA_IMAGEN=?, ID_CIUDAD=?, ID_ARTISTA=? \n"
                + "WHERE ID_ALBUM=?";
    }
}

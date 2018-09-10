package co.com.soundMusic.Artista;

import co.com.soundMusic.Contacto.ContactoDaoImpl;
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
 * @author sanme
 */
public class ArtistaDaoImpl implements IArtistaDao {

    private Connection conexion;
    private ContactoDaoImpl contacto = new ContactoDaoImpl();

    public ArtistaDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Artista> obtenerArtistas() throws SQLException {
        List<Artista> listaArtistas = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "";

        ResultSet rs = stmt.executeQuery(sql);

        // Se avanza el cursor de a una fila 
        // Cuando se alcalza el fin del cursor, la funcion retorna false
        while (rs.next()) {
            int idArtista = rs.getInt("ID_ARTISTA");
            String primerNombre = rs.getString("PRIMER_NOMBRE");
            String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            String nombreArtistico = rs.getString("NOMBRE_ARTISTICO");
            String genero = rs.getString("GENERO");
            int totalCanciones = rs.getInt("TOTAL_CANCIONES");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            String status = rs.getString("STATUS");
            int idContacto = rs.getInt("ID_CONTACTO_ARTISTA");

            Artista artista = new Artista(idArtista, primerNombre, segundoNombre,
                    primerApellido, segundoApellido, nombreArtistico, genero,
                    totalCanciones, fechaCreacion, status, contacto.obtenerContacto(idContacto));
            listaArtistas.add(artista);
        }

        stmt.close();
        return listaArtistas;
    }

    @Override
    public Artista obtenerArtista(int idArtista) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idArtista);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idArt = rs.getInt("ID_ARTISTA");
            String primerNombre = rs.getString("PRIMER_NOMBRE");
            String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            String nombreArtistico = rs.getString("NOMBRE_ARTISTICO");
            String genero = rs.getString("GENERO");
            int totalCanciones = rs.getInt("TOTAL_CANCIONES");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            String status = rs.getString("STATUS");
            int idContacto = rs.getInt("ID_CONTACTO_ARTISTA");

            Artista artista = new Artista(idArt, primerNombre, segundoNombre,
                    primerApellido, segundoApellido, nombreArtistico, genero,
                    totalCanciones, fechaCreacion, status,
                    contacto.obtenerContacto(idContacto));

            return artista;
        }

        return null;
    }

    @Override
    public void crearArtista(Artista artista) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, artista.getPrimerNombre());
        ps.setString(2, artista.getSegundoNombre());
        ps.setString(3, artista.getPrimerApellido());
        ps.setString(4, artista.getSegundoApellido());
        ps.setString(5, artista.getNombreArtistico());
        ps.setString(6, artista.getGenero());
        ps.setInt(7, artista.getTotalCanciones());
        ps.setDate(8, artista.getFechaCreacion());
        ps.setString(9, artista.getStatus());
        ps.setInt(10, artista.getContacto().getIdContacto());
        ps.executeUpdate();
    }

    @Override
    public void eliminarArtista(String status) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, status);
        ps.executeUpdate();
    }

    @Override
    public void actualizarArtista(Artista artista) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, artista.getPrimerNombre());
        ps.setString(2, artista.getSegundoNombre());
        ps.setString(3, artista.getPrimerApellido());
        ps.setString(4, artista.getSegundoApellido());
        ps.setString(5, artista.getNombreArtistico());
        ps.setString(6, artista.getGenero());
        ps.setInt(7, artista.getTotalCanciones());
        ps.setDate(8, artista.getFechaCreacion());
        ps.setString(9, artista.getStatus());
        ps.setInt(10, artista.getContacto().getIdContacto());
        ps.executeUpdate();
    }
}

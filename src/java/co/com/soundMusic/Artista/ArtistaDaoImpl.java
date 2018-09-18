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
 * @author Santiago Medina Pelaez
 */
public class ArtistaDaoImpl implements IArtistaDao {

    private Connection conexion;
    private ContactoDaoImpl contacto;

    public ArtistaDaoImpl() {
        conexion = DBUtil.getConexion();
        contacto = new ContactoDaoImpl();
    }

    @Override
    public List<Artista> obtenerArtistas() throws SQLException {
        List<Artista> listaArtistas = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT ID_ARTISTA,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,ID_CONTACTO\n"
                + "FROM ARTISTA";

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
            Date fechaNacimiento = rs.getDate("FECHA_NACIMIENTO");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            String status = rs.getString("STATUS");
            int idContacto = rs.getInt("ID_CONTACTO");

            String[] datos = {primerNombre, segundoNombre,
                primerApellido, segundoApellido, nombreArtistico, genero, status};
            Date[] fechas = {fechaNacimiento, fechaCreacion};

            Artista artista = new Artista(idArtista, datos, fechas, idContacto);

            listaArtistas.add(artista);
        }

        stmt.close();
        return listaArtistas;
    }

    @Override
    public Artista obtenerArtista(int idArtista) throws SQLException {
        String sql = "SELECT ID_ARTISTA,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                 + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,ID_CONTACTO\n"
                + "FROM ARTISTA\n"
                + "WHERE ID_ARTISTA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idArtista);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String primerNombre = rs.getString("PRIMER_NOMBRE");
            String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            String nombreArtistico = rs.getString("NOMBRE_ARTISTICO");
            String genero = rs.getString("GENERO");
            Date fechaNacimiento = rs.getDate("FECHA_NACIMIENTO");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            String status = rs.getString("STATUS");
            int idContacto = rs.getInt("ID_CONTACTO_ARTISTA");

            String[] datos = {primerNombre, segundoNombre,
                primerApellido, segundoApellido, nombreArtistico, genero, status};
            Date[] fechas = {fechaNacimiento, fechaCreacion};

            Artista artista = new Artista(idArtista, datos, fechas, idContacto);

            return artista;
        }

        return null;
    }

    @Override
    public void crearArtista(Artista artista) throws SQLException {
        String sql = "INSERT INTO ARTISTA (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,ID_CONTACTO)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, artista.getPrimerNombre());
        ps.setString(2, artista.getSegundoNombre());
        ps.setString(3, artista.getPrimerApellido());
        ps.setString(4, artista.getSegundoApellido());
        ps.setString(5, artista.getNombreArtistico());
        ps.setString(6, artista.getGenero());
        ps.setDate(7, artista.getFechaNacimiento());
        ps.setDate(8, artista.getFechaCreacion());
        ps.setString(9, artista.getStatus());
        ps.setInt(10, artista.getIdContacto());
        ps.executeUpdate();
    }

    @Override
    public void eliminarArtista(String status, int idArtista) throws SQLException {
        String sql = "UPDATE ARTISTA\n"
                + "SET STATUS=?\n"
                + "WHERE ID_ARTISTA=?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, idArtista);
        ps.executeUpdate();
    }

    @Override
    public void actualizarArtista(Artista artista) throws SQLException {
        String sql = "UPDATE ARTISTA\n"
                + "SET PRIMER_NOMBRE=?,SEGUNDO_NOMBRE=?,PRIMER_APELLIDO=?,SEGUNDO_APELLIDO=?,\n"
                + "NOMBRE_ARTISTICO=?,GENERO=?,FECHA_NACIMIENTO=?,FECHA_CREACION=?,STATUS=?,ID_CONTACTO=?\n"
                + "WHERE ID_ARTISTA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, artista.getPrimerNombre());
        ps.setString(2, artista.getSegundoNombre());
        ps.setString(3, artista.getPrimerApellido());
        ps.setString(4, artista.getSegundoApellido());
        ps.setString(5, artista.getNombreArtistico());
        ps.setString(6, artista.getGenero());
        ps.setDate(7, artista.getFechaNacimiento());
        ps.setDate(8, artista.getFechaCreacion());
        ps.setString(9, artista.getStatus());
        ps.setInt(10, artista.getIdContacto());
        ps.setInt(11, artista.getIdArtista());
        ps.executeUpdate();
    }
}

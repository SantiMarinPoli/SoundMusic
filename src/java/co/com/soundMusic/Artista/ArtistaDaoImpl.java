package co.com.soundMusic.Artista;

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

    public ArtistaDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Artista> obtenerArtistas() throws SQLException {
        List<Artista> listaArtistas = new ArrayList<>();

        Statement stmt = conexion.createStatement();

        String sql = "SELECT AR.ID_ARTISTA, AR.PRIMER_NOMBRE, AR.SEGUNDO_NOMBRE, "
                + "AR.PRIMER_APELLIDO, AR.SEGUNDO_APELLIDO, AR.NOMBRE_ARTISTICO, AR.GENERO, \n"
                + "AR.FECHA_NACIMIENTO, AR.FECHA_CREACION, AR.STATUS, \n"
                + "AR.RUTA_IMAGEN, AR.ID_CONTACTO AS CONTACTO \n" + "FROM ARTISTA \n" + " ORDER BY AR.ID_ARTISTA";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            String[] datosArtista = { rs.getString("PRIMER_NOMBRE"), rs.getString("SEGUNDO_NOMBRE"),
                    rs.getString("PRIMER_APELLIDO"), rs.getString("SEGUNDO_APELLIDO"), rs.getString("NOMBRE_ARTISTICO"),
                    rs.getString("GENERO"), rs.getString("STATUS"), rs.getString("RUTA_IMAGEN") };

            Date[] fechasArtista = { rs.getDate("FECHA_NACIMIENTO"), rs.getDate("FECHA_CREACION") };

            Artista artista = new Artista(rs.getInt("ID_ARTISTA"), datosArtista, fechasArtista, rs.getInt("CONTACTO"));

            listaArtistas.add(artista);
        }

        stmt.close();
        return listaArtistas;
    }

    @Override
    public Artista obtenerArtista(int idArtista) throws SQLException {
        String sql = "SELECT PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,RUTA_IMAGEN, ID_CONTACTO\n"
                + "FROM ARTISTA\n" + "WHERE ID_ARTISTA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idArtista);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String[] datosArtista = { rs.getString("PRIMER_NOMBRE"), rs.getString("SEGUNDO_NOMBRE"),
                    rs.getString("PRIMER_APELLIDO"), rs.getString("SEGUNDO_APELLIDO"), rs.getString("NOMBRE_ARTISTICO"),
                    rs.getString("GENERO"), rs.getString("STATUS"), rs.getString("RUTA_IMAGEN") };
            Date[] fechasArtista = { rs.getDate("FECHA_NACIMIENTO"), rs.getDate("FECHA_CREACION") };

            Artista artista = new Artista(idArtista, datosArtista, fechasArtista, rs.getInt("ID_CONTACTO"));

            return artista;
        }

        return null;
    }

    @Override
    public void crearArtista(Artista artista) throws SQLException {
        String sql = "INSERT INTO ARTISTA (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,RUTA_IMAGEN,ID_CONTACTO)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
        ps.setString(10, artista.getRutaImagen());
        ps.setInt(11, artista.getIdContacto());
        ps.executeUpdate();
    }

    @Override
    public void eliminarArtista(String status, int idArtista) throws SQLException {
        String sql = "UPDATE ARTISTA\n" + "SET STATUS=? \n" + "WHERE ID_ARTISTA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, idArtista);
        ps.executeUpdate();
    }

    @Override
    public void actualizarArtista(Artista artista) throws SQLException {
        String sql = "UPDATE ARTISTA\n" + "SET PRIMER_NOMBRE=?,SEGUNDO_NOMBRE=?,PRIMER_APELLIDO=?,SEGUNDO_APELLIDO=?,\n"
                + "NOMBRE_ARTISTICO=?,GENERO=?,FECHA_NACIMIENTO=?,FECHA_CREACION=?,STATUS=?, RUTA_IMAGEN=?,ID_CONTACTO=?\n"
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
        ps.setString(10, artista.getRutaImagen());
        ps.setInt(11, artista.getIdContacto());
        ps.setInt(12, artista.getIdArtista());
        ps.executeUpdate();
    }

    public int getUltimmoIdArtista() throws SQLException {
        String sql = "SELECT ARTISTA_SEQ.CURRVAL\n" + "FROM DUAL";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        while (rs.next()) {
            int idArtista = rs.getInt("CURRVAL");
            return idArtista;
        }
        return -1;
    }
}

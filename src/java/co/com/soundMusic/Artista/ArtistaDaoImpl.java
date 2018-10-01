package co.com.soundMusic.Artista;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.ContactoDaoImpl;
import co.com.soundMusic.Contacto.Pais.Pais;
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
    private ContactoDaoImpl contactoDao;

    public ArtistaDaoImpl() {
        conexion = DBUtil.getConexion();
        contactoDao = new ContactoDaoImpl();
    }

    @Override
    public List<Artista> obtenerArtistas() throws SQLException {
        List<Artista> listaArtistas = new ArrayList<>();

        Statement stmt = conexion.createStatement();

        String sql = "SELECT AR.ID_ARTISTA, AR.PRIMER_NOMBRE, AR.SEGUNDO_NOMBRE, "
                + "AR.PRIMER_APELLIDO, AR.SEGUNDO_APELLIDO, AR.NOMBRE_ARTISTICO, AR.GENERO, \n"
                + "AR.FECHA_NACIMIENTO, AR.FECHA_CREACION, AR.STATUS, "
                + "CONT.ID_CONTACTO AS CONTACTO, CONT.CELULAR AS CELULAR, "
                + "CONT.TELEFONO AS TELEFONO,\n"
                + "CONT.DIRECCION AS DIRECCION, CONT.BARRIO AS BARRIO, "
                + "CONT.EMAIL AS EMAIL, CIU.ID_CIUDAD AS CIUDAD, CIU.NOMBRE AS NOMBRE_CIUDAD,\n"
                + "PA.ID_PAIS AS PAIS, PA.NOMBRE AS NOMBRE_PAIS\n"
                + "FROM ARTISTA AR INNER JOIN CONTACTO CONT\n"
                + "ON AR.ID_CONTACTO = CONT.ID_CONTACTO\n"
                + "INNER JOIN CIUDAD CIU\n"
                + "ON CONT.ID_CIUDAD = CIU.ID_CIUDAD\n"
                + "INNER JOIN PAIS PA\n"
                + "ON CIU.ID_PAIS = PA.ID_PAIS ORDER BY AR.ID_ARTISTA";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            Pais pais = new Pais(rs.getInt("PAIS"), rs.getString("NOMBRE_PAIS"));

            Ciudad ciudad = new Ciudad(rs.getInt("CIUDAD"), rs.getString("NOMBRE_CIUDAD"), pais);

            String[] datosContacto = {rs.getString("CELULAR"), rs.getString("TELEFONO"),
                rs.getString("DIRECCION"), rs.getString("BARRIO"), rs.getString("EMAIL")};

            Contacto contacto = new Contacto(rs.getInt("CONTACTO"), datosContacto, ciudad);

            String[] datosArtista = {rs.getString("PRIMER_NOMBRE"), rs.getString("SEGUNDO_NOMBRE"),
                rs.getString("PRIMER_APELLIDO"), rs.getString("SEGUNDO_APELLIDO"),
                rs.getString("NOMBRE_ARTISTICO"), rs.getString("GENERO"), rs.getString("STATUS")};

            Date[] fechasArtista = {rs.getDate("FECHA_NACIMIENTO"), rs.getDate("FECHA_CREACION")};

            Artista artista = new Artista(rs.getInt("ID_ARTISTA"), datosArtista, fechasArtista, contacto);

            listaArtistas.add(artista);
        }

        stmt.close();
        return listaArtistas;
    }

    @Override
    public Artista obtenerArtista(int idArtista) throws SQLException {
        String sql = "SELECT PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,ID_CONTACTO\n"
                + "FROM ARTISTA\n"
                + "WHERE ID_ARTISTA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idArtista);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String[] datosArtista = {rs.getString("PRIMER_NOMBRE"), rs.getString("SEGUNDO_NOMBRE"),
                rs.getString("PRIMER_APELLIDO"), rs.getString("SEGUNDO_APELLIDO"),
                rs.getString("NOMBRE_ARTISTICO"), rs.getString("GENERO"),
                rs.getString("STATUS")};
            Date[] fechasArtista = {rs.getDate("FECHA_NACIMIENTO"), rs.getDate("FECHA_CREACION")};

            Artista artista = new Artista(idArtista, datosArtista, fechasArtista,
                    contactoDao.obtenerContacto(rs.getInt("ID_CONTACTO")));

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
        ps.setInt(10, artista.getContacto().getIdContacto());
        ps.executeUpdate();
    }

    @Override
    public void eliminarArtista(String status, int idArtista) throws SQLException {
        String sql = "UPDATE ARTISTA\n"
                + "SET STATUS=?\n"
                + "WHERE ID_ARTISTA=?";
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
        ps.setInt(10, artista.getContacto().getIdContacto());
        ps.setInt(11, artista.getIdArtista());
        ps.executeUpdate();
    }

    public int getUltimmoIdArtista() throws SQLException {
        String sql = "SELECT ARTISTA_SEQ.CURRVAL\n"
                + "FROM DUAL";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        while (rs.next()) {
            int idArtista = rs.getInt("CURRVAL");
            return idArtista;
        }
        return -1;
    }
}

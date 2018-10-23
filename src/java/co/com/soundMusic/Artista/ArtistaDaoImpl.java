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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ArtistaDaoImpl implements IArtistaDao {

    //Conexion a la base de datos
    private final Connection conexion;

    private Statement stmt;
    private ResultSet rs;

    //Constantes con las querys a la base de datos
    private static final String SELECT_ARTISTAS;
    private static final String SELECT_ARTISTA_POR_ID;
    private static final String INSERT_ARTISTA;
    private static final String UPDATE_ARTISTA;
    private static final String UPDATE_STATUS;
    private static final String SELECT_ULTIMO_ID;

    public ArtistaDaoImpl(Boolean production) {
        if (production) {
            conexion = DBUtil.getConexion();
        } else {
            conexion = DBUtil.getTestConexion();
        }
        stmt = null;
        rs = null;
    }

    @Override
    public List<Artista> obtenerArtistas() {
        List<Artista> listaArtistas = new ArrayList<>();
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SELECT_ARTISTAS);

            while (rs.next()) {

                String[] datosArtista = {rs.getString("PRIMER_NOMBRE"), rs.getString("SEGUNDO_NOMBRE"),
                    rs.getString("PRIMER_APELLIDO"), rs.getString("SEGUNDO_APELLIDO"), rs.getString("NOMBRE_ARTISTICO"),
                    rs.getString("GENERO"), rs.getString("STATUS"), rs.getString("RUTA_IMAGEN")};

                Date[] fechasArtista = {rs.getDate("FECHA_NACIMIENTO"), rs.getDate("FECHA_CREACION")};

                Artista artista = new Artista(rs.getInt("ID_ARTISTA"), datosArtista, fechasArtista, rs.getInt("CONTACTO"));

                listaArtistas.add(artista);
            }

        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
        return listaArtistas;
    }

    @Override
    public Artista obtenerArtista(int idArtista) {
        Artista artista = new Artista();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_ARTISTA_POR_ID);
            ps.setInt(1, idArtista);
            rs = ps.executeQuery();

            while (rs.next()) {
                String[] datosArtista = {rs.getString("PRIMER_NOMBRE"), rs.getString("SEGUNDO_NOMBRE"),
                    rs.getString("PRIMER_APELLIDO"), rs.getString("SEGUNDO_APELLIDO"), rs.getString("NOMBRE_ARTISTICO"),
                    rs.getString("GENERO"), rs.getString("STATUS"), rs.getString("RUTA_IMAGEN")};
                Date[] fechasArtista = {rs.getDate("FECHA_NACIMIENTO"), rs.getDate("FECHA_CREACION")};

                artista = new Artista(idArtista, datosArtista, fechasArtista, rs.getInt("ID_CONTACTO"));

                return artista;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
        return artista;
    }

    @Override
    public void crearArtista(Artista artista) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_ARTISTA);

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
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
    }

    @Override
    public void eliminarArtista(String status, int idArtista) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_STATUS);
            ps.setString(1, status);
            ps.setInt(2, idArtista);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
    }

    @Override
    public void actualizarArtista(Artista artista) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_ARTISTA);

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
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
    }

    public int getUltimmoIdArtista() {
        int idArtista = -1;
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SELECT_ULTIMO_ID);
            while (rs.next()) {
                idArtista = rs.getInt("CURRVAL");
                return idArtista;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
        return idArtista;
    }

    static {
        SELECT_ARTISTAS = "SELECT ID_ARTISTA, PRIMER_NOMBRE, SEGUNDO_NOMBRE, "
                + "PRIMER_APELLIDO, SEGUNDO_APELLIDO, NOMBRE_ARTISTICO, GENERO, \n"
                + "FECHA_NACIMIENTO, FECHA_CREACION, STATUS, \n"
                + "RUTA_IMAGEN, ID_CONTACTO AS CONTACTO \n"
                + "FROM ARTISTA \n"
                + "ORDER BY ID_ARTISTA";

        SELECT_ARTISTA_POR_ID = "SELECT PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,RUTA_IMAGEN, ID_CONTACTO\n"
                + "FROM ARTISTA\n"
                + "WHERE ID_ARTISTA=?";

        INSERT_ARTISTA = "INSERT INTO ARTISTA (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,RUTA_IMAGEN,ID_CONTACTO)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        UPDATE_STATUS = "UPDATE ARTISTA\n"
                + "SET STATUS=? \n"
                + "WHERE ID_ARTISTA=?";

        UPDATE_ARTISTA = "UPDATE ARTISTA\n"
                + "SET PRIMER_NOMBRE=?,SEGUNDO_NOMBRE=?,PRIMER_APELLIDO=?,SEGUNDO_APELLIDO=?,\n"
                + "NOMBRE_ARTISTICO=?,GENERO=?,FECHA_NACIMIENTO=?,FECHA_CREACION=?,STATUS=?, RUTA_IMAGEN=?,ID_CONTACTO=?\n"
                + "WHERE ID_ARTISTA=?";

        SELECT_ULTIMO_ID = "SELECT ARTISTA_SEQ.CURRVAL\n"
                + "FROM DUAL";
    }
}

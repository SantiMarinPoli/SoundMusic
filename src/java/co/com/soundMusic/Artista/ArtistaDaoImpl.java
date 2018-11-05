package co.com.soundMusic.Artista;

import co.com.soundMusic.Contacto.Ciudad.Ciudad;
import co.com.soundMusic.Contacto.Contacto;
import co.com.soundMusic.Contacto.Pais.Pais;
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
public class ArtistaDaoImpl implements IArtistaDao {

    //Conexion a la base de datos
    private Connection conexion;
    private Boolean isProduction = true;
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
        isProduction = production;
    }

    @Override
    public List<Artista> obtenerArtistas() {
        getConexion();
        List<Artista> listaArtistas = new ArrayList<>();
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SELECT_ARTISTAS);

            while (rs.next()) {
                Artista artista = new Artista();
                Contacto contacto = new Contacto();
                Pais pais = new Pais();
                Ciudad ciudad = new Ciudad();

                //Crear Pais
                pais.setIdPais(rs.getInt("PAIS"));
                pais.setNombre(rs.getString("NOMBRE_PAIS"));
                //Crear Ciudad
                ciudad.setIdCiudad(rs.getInt("CIUDAD"));
                ciudad.setNombre(rs.getString("NOMBRE_CIUDAD"));
                ciudad.setPais(pais);
                //Crear Contacto
                contacto.setIdContacto(rs.getInt("CONTACTO"));
                contacto.setCelular(rs.getString("CELULAR"));
                contacto.setTelefono(rs.getString("TELEFONO"));
                contacto.setDireccion(rs.getString("DIRECCION"));
                contacto.setBarrio(rs.getString("BARRIO"));
                contacto.setEmail(rs.getString("EMAIL"));
                contacto.setCiudad(ciudad);
                //Crear Artista
                artista.setIdArtista(rs.getInt("ID_ARTISTA"));
                artista.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                artista.setSegundoNombre(validacion(rs.getString("SEGUNDO_NOMBRE")));
                artista.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                artista.setSegundoApellido(validacion(rs.getString("SEGUNDO_APELLIDO")));
                artista.setNombreArtistico(rs.getString("NOMBRE_ARTISTICO"));
                artista.setGenero(validacion(rs.getString("GENERO")));
                artista.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                artista.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                artista.setStatus(rs.getString("STATUS"));
                artista.setRutaImagen(validacion(rs.getString("RUTA_IMAGEN")));
                artista.setContacto(contacto);

                listaArtistas.add(artista);
            }

        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(rs);
                    DbUtils.closeQuietly(stmt);
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaArtistas;
    }

    @Override
    public Artista obtenerArtista(int idArtista) {
        getConexion();
        Artista artista = new Artista();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_ARTISTA_POR_ID);
            ps.setInt(1, idArtista);
            rs = ps.executeQuery();

            while (rs.next()) {
                Contacto contacto = new Contacto();
                Pais pais = new Pais();
                Ciudad ciudad = new Ciudad();

                //Crear Pais
                pais.setIdPais(rs.getInt("PAIS"));
                pais.setNombre(rs.getString("NOMBRE_PAIS"));
                //Crear Ciudad
                ciudad.setIdCiudad(rs.getInt("CIUDAD"));
                ciudad.setNombre(rs.getString("NOMBRE_CIUDAD"));
                ciudad.setPais(pais);
                //Crear Contacto
                contacto.setIdContacto(rs.getInt("CONTACTO"));
                contacto.setCelular(rs.getString("CELULAR"));
                contacto.setTelefono(rs.getString("TELEFONO"));
                contacto.setDireccion(rs.getString("DIRECCION"));
                contacto.setBarrio(rs.getString("BARRIO"));
                contacto.setEmail(rs.getString("EMAIL"));
                contacto.setCiudad(ciudad);
                //Crear Artista
                artista.setIdArtista(idArtista);
                artista.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                artista.setSegundoNombre(validacion(rs.getString("SEGUNDO_NOMBRE")));
                artista.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                artista.setSegundoApellido(validacion(rs.getString("SEGUNDO_APELLIDO")));
                artista.setNombreArtistico(rs.getString("NOMBRE_ARTISTICO"));
                artista.setGenero(validacion(rs.getString("GENERO")));
                artista.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                artista.setFechaCreacion(rs.getDate("FECHA_CREACION"));
                artista.setStatus(rs.getString("STATUS"));
                artista.setRutaImagen(validacion(rs.getString("RUTA_IMAGEN")));
                artista.setContacto(contacto);

                return artista;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(rs);
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return artista;
    }

    @Override
    public void crearArtista(Artista artista) {
        getConexion();
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
            ps.setInt(11, artista.getContacto().getIdContacto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void eliminarArtista(String status, int idArtista) {
        getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_STATUS);
            ps.setString(1, status);
            ps.setInt(2, idArtista);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void actualizarArtista(Artista artista) {
        getConexion();
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_ARTISTA);

            ps.setString(1, artista.getPrimerNombre());
            ps.setString(2, artista.getSegundoNombre());
            ps.setString(3, artista.getPrimerApellido());
            ps.setString(4, artista.getSegundoApellido());
            ps.setString(5, artista.getNombreArtistico());
            ps.setString(6, artista.getGenero());
            ps.setDate(7, artista.getFechaNacimiento());            
            ps.setString(8, artista.getStatus());
            ps.setString(9, artista.getRutaImagen());
            ps.setInt(10, artista.getContacto().getIdContacto());
            ps.setInt(11, artista.getIdArtista());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                if (conexion != null) {
                    DbUtils.closeQuietly(rs);
                    DbUtils.closeQuietly(conexion);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(ArtistaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idArtista;
    }

    static {
        SELECT_ARTISTAS = "SELECT AR.ID_ARTISTA, AR.PRIMER_NOMBRE, AR.SEGUNDO_NOMBRE, \n"
                + "AR.PRIMER_APELLIDO, AR.SEGUNDO_APELLIDO, AR.NOMBRE_ARTISTICO, AR.GENERO, \n"
                + "AR.FECHA_NACIMIENTO, AR.FECHA_CREACION, AR.STATUS, \n"
                + "AR.RUTA_IMAGEN, AR.ID_CONTACTO AS CONTACTO , \n"
                + "CONT.CELULAR AS CELULAR, CONT.TELEFONO AS TELEFONO, CONT.DIRECCION AS DIRECCION, \n"
                + "CONT.BARRIO AS BARRIO, CONT.EMAIL AS EMAIL, CIU.ID_CIUDAD AS CIUDAD, \n"
                + "CIU.NOMBRE AS NOMBRE_CIUDAD,PA.ID_PAIS AS PAIS, PA.NOMBRE AS NOMBRE_PAIS \n"
                + "FROM ARTISTA AR INNER JOIN CONTACTO CONT \n"
                + "ON AR.ID_CONTACTO = CONT.ID_CONTACTO         \n"
                + "INNER JOIN CIUDAD CIU \n"
                + "ON CONT.ID_CIUDAD = CIU.ID_CIUDAD \n"
                + "INNER JOIN PAIS PA \n"
                + "ON CIU.ID_PAIS = PA.ID_PAIS \n"
                + "ORDER BY ID_ARTISTA";

        SELECT_ARTISTA_POR_ID = "SELECT AR.ID_ARTISTA, AR.PRIMER_NOMBRE, AR.SEGUNDO_NOMBRE, \n"
                + "AR.PRIMER_APELLIDO, AR.SEGUNDO_APELLIDO, AR.NOMBRE_ARTISTICO, AR.GENERO, \n"
                + "AR.FECHA_NACIMIENTO, AR.FECHA_CREACION, AR.STATUS, \n"
                + "AR.RUTA_IMAGEN, AR.ID_CONTACTO AS CONTACTO , \n"
                + "CONT.CELULAR AS CELULAR, CONT.TELEFONO AS TELEFONO, CONT.DIRECCION AS DIRECCION, \n"
                + "CONT.BARRIO AS BARRIO, CONT.EMAIL AS EMAIL, CIU.ID_CIUDAD AS CIUDAD, \n"
                + "CIU.NOMBRE AS NOMBRE_CIUDAD,PA.ID_PAIS AS PAIS, PA.NOMBRE AS NOMBRE_PAIS \n"
                + "FROM ARTISTA AR INNER JOIN CONTACTO CONT \n"
                + "ON AR.ID_CONTACTO = CONT.ID_CONTACTO         \n"
                + "INNER JOIN CIUDAD CIU \n"
                + "ON CONT.ID_CIUDAD = CIU.ID_CIUDAD \n"
                + "INNER JOIN PAIS PA \n"
                + "ON CIU.ID_PAIS = PA.ID_PAIS \n"
                + "WHERE ID_ARTISTA=?";

        INSERT_ARTISTA = "INSERT INTO ARTISTA (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "NOMBRE_ARTISTICO,GENERO,FECHA_NACIMIENTO,FECHA_CREACION,STATUS,RUTA_IMAGEN,ID_CONTACTO)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        UPDATE_STATUS = "UPDATE ARTISTA\n"
                + "SET STATUS=? \n"
                + "WHERE ID_ARTISTA=?";

        UPDATE_ARTISTA = "UPDATE ARTISTA\n"
                + "SET PRIMER_NOMBRE=?,SEGUNDO_NOMBRE=?,PRIMER_APELLIDO=?,SEGUNDO_APELLIDO=?,\n"
                + "NOMBRE_ARTISTICO=?,GENERO=?,FECHA_NACIMIENTO=?,STATUS=?, RUTA_IMAGEN=?,ID_CONTACTO=?\n"
                + "WHERE ID_ARTISTA=?";

        SELECT_ULTIMO_ID = "SELECT ARTISTA_SEQ.CURRVAL\n"
                + "FROM DUAL";
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

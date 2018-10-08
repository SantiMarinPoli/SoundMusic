package co.com.soundMusic.Negocio.Regalias.ArtistaEmpresa;

import co.com.soundMusic.Artista.Artista;
import co.com.soundMusic.EmpresaDifusora.EmpresaDifusora;
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
public class ArtistaEmpresaDaoImpl implements IArtistaEmpresaDao {

    private Connection conexion;

    public ArtistaEmpresaDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<ArtistaEmpresa> obtenerTodoArtistaEmpresa() throws SQLException {
        List<ArtistaEmpresa> lstArtistaEmpresa = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT ID_ARTISTA_EMPRESA, ID_ARTISTA, ID_EMPRESA_DIFUSORA \n" + "FROM ARTISTA_EMPRESA";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int idArtistaEmpresa = rs.getInt("ID_ARTISTA_EMPRESA");
            int idArtista = rs.getInt("ID_ARTISTA");
            int idEmpresa = rs.getInt("ID_EMPRESA_DIFUSORA");

            ArtistaEmpresa artistaEmpresa = new ArtistaEmpresa(idArtistaEmpresa, idArtista, idEmpresa);

            artistaEmpresa.obtenerArtista();
            artistaEmpresa.obtenerEmpresa();

            lstArtistaEmpresa.add(artistaEmpresa);
        }
        stmt.close();
        return lstArtistaEmpresa;
    }

    @Override
    public ArtistaEmpresa obtenerArtistaEmpresa(int idArtistaEmpresa) throws SQLException {
        String sql = "SELECT ID_ARTISTA, ID_EMPRESA_DIFUSORA \n" + "FROM ARTISTA_EMPRESA \n"
                + "WHERE ID_ARTISTA_EMPRESA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idArtistaEmpresa);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idArtista = rs.getInt("ID_ARTISTA");
            int idEmpresa = rs.getInt("ID_EMPRESA_DIFUSORA");

            ArtistaEmpresa artistaEmpresa = new ArtistaEmpresa(idArtistaEmpresa, idArtista, idEmpresa);

            artistaEmpresa.obtenerArtista();
            artistaEmpresa.obtenerEmpresa();

            return artistaEmpresa;
        }

        return null;
    }

    @Override
    public List<Artista> obtenerArtistasPorEmpresa(int idArtista) throws SQLException {

        List<Artista> lstArtistasPorEmpresa = new ArrayList<>();
        String sql = "SELECT AR.ID_ARTISTA, AR.PRIMER_NOMBRE, AR.SEGUNDO_NOMBRE, "
                + "AR.PRIMER_APELLIDO, AR.SEGUNDO_APELLIDO, AR.NOMBRE_ARTISTICO, AR.GENERO, \n"
                + "AR.FECHA_NACIMIENTO, AR.FECHA_CREACION, AR.STATUS, \n"
                + "AR.RUTA_IMAGEN, AR.ID_CONTACTO AS CONTACTO \n" + "FROM ARTISTA_EMPRESA AE INNER JOIN ARTISTA AR \n"
                + "ON AE.ID_ARTISTA = AR.ID_ARTISTA \n" + "WHERE AE.ID_ARTISTA=? ORDER BY AR.ID_ARTISTA";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idArtista);
        ResultSet rs = ps.executeQuery(sql);

        while (rs.next()) {
            String[] datosArtista = {rs.getString("PRIMER_NOMBRE"), rs.getString("SEGUNDO_NOMBRE"),
                rs.getString("PRIMER_APELLIDO"), rs.getString("SEGUNDO_APELLIDO"), rs.getString("NOMBRE_ARTISTICO"),
                rs.getString("GENERO"), rs.getString("STATUS"), rs.getString("RUTA_IMAGEN")};

            Date[] fechasArtista = {rs.getDate("FECHA_NACIMIENTO"), rs.getDate("FECHA_CREACION")};

            Artista artista = new Artista(idArtista, datosArtista, fechasArtista, rs.getInt("CONTACTO"));
            lstArtistasPorEmpresa.add(artista);
        }
        return lstArtistasPorEmpresa;
    }

    @Override
    public List<EmpresaDifusora> obtenerEmpresasPorArtista(int idEmpresaDifusora) throws SQLException {
        List<EmpresaDifusora> lstEmpresasPorArtista = new ArrayList<>();
        String sql = "SELECT ED.NOMBRE,ED.FECHA_ED.CREACION,ED.FECHA_TERMINACION,ED.STATUS,\n"
                + "ED.RUTA_IMAGEN, ED.ID_TIPO_ACTIVIDAD, ED.ID_CONTACTO,ED.ID_COSTO_ACTIVIDAD\n"
                + "FROM ARTISTA_EMPRESA AE INNER JOIN EMPRESA_DIFUSORA ED \n"
                + "ON AE.ID_EMPRESA_DIFUSORA = ED.ID_EMPRESA_DIFUSORA \n"
                + "WHERE ED.ID_EMPRESA_DIFUSORA=? ORDER BY ED.ID_EMPRESA_DIFUSORA";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idEmpresaDifusora);
        ResultSet rs = ps.executeQuery(sql);

        while (rs.next()) {
            String nombreEmpresa = rs.getString("NOMBRE");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            Date fechaTerminacion = rs.getDate("FECHA_TERMINACION");
            String status = rs.getString("STATUS");
            String rutaImagen = rs.getString("RUTA_IMAGEN");
            int idTipoActividad = rs.getInt("ID_TIPO_ACTIVIDAD");
            int idContacto = rs.getInt("ID_CONTACTO");
            int idCostoOperacion = rs.getInt("ID_COSTO_ACTIVIDAD");

            EmpresaDifusora empresaDifusora = new EmpresaDifusora(idEmpresaDifusora, nombreEmpresa, fechaCreacion,
                    fechaTerminacion, status, rutaImagen, idTipoActividad, idContacto, idCostoOperacion);
            lstEmpresasPorArtista.add(empresaDifusora);
        }
        return lstEmpresasPorArtista;
    }

    @Override
    public void crearArtistaEmpresa(ArtistaEmpresa artistaEmpresa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    @Override
    public void eliminarArtistaEmpresa(int idArtistaEmpresa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    @Override
    public void actualizarArtistaEmpresa(ArtistaEmpresa artistaEmpresa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

}

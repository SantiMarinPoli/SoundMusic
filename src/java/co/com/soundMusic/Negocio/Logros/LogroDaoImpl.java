package co.com.soundMusic.Negocio.Logros;

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
public class LogroDaoImpl implements ILogroDao {

    //Conexion a la base de datos
    private Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_LOGROS;
    private static final String SELECT_LOGRO_POR_ID;
    private static final String INSERT_LOGRO;
    private static final String UPDATE_FECHA_FINAL;
    private static final String UPDATE_LOGRO;

    public LogroDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Logro> obtenerLogros() throws SQLException {
        List<Logro> lstLogros = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_LOGROS);

        while (rs.next()) {
            int idLogro = rs.getInt("ID_LOGRO");
            String nombre = rs.getString("NOMBRE");
            String criterio = rs.getString("CRITERIO");
            Float cantidadCriterio = rs.getFloat("CANTIDAD_CRITERIO");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            Date fechafinal = rs.getDate("FECHA_FINAL");
            float premio = rs.getFloat("PREMIO");

            Logro logro = new Logro(idLogro, nombre, criterio, cantidadCriterio, fechaCreacion, fechafinal, premio);

            lstLogros.add(logro);
        }

        stmt.close();
        return lstLogros;
    }

    @Override
    public Logro obtenerLogro(int idLogro) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_LOGRO_POR_ID);
        ps.setInt(1, idLogro);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("NOMBRE");
            String criterio = rs.getString("CRITERIO");
            Float cantidadCriterio = rs.getFloat("CANTIDAD_CRITERIO");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            Date fechafinal = rs.getDate("FECHA_FINAL");
            float premio = rs.getFloat("PREMIO");

            Logro logro = new Logro(idLogro, nombre, criterio, cantidadCriterio, fechaCreacion, fechafinal, premio);

            return logro;
        }

        return null;
    }

    @Override
    public void crearLogro(Logro logro) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_LOGRO);
        ps.setString(1, logro.getNombreLogro());
        ps.setString(2, logro.getCriterio());
        ps.setFloat(3, logro.getCantidadCriterio());
        ps.setDate(4, logro.getFechaCreacion());
        ps.setDate(5, logro.getFechaFinal());
        ps.setFloat(6, logro.getPremio());
        ps.executeUpdate();
    }

    @Override
    public void eliminarLogro(Logro logro) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_FECHA_FINAL);
        ps.setDate(1, logro.getFechaFinal());
        ps.setInt(2, logro.getIdLogro());
        ps.executeUpdate();
    }

    @Override
    public void actualizarLogro(Logro logro) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_LOGRO);

        ps.setString(1, logro.getNombreLogro());
        ps.setString(2, logro.getCriterio());
        ps.setFloat(3, logro.getCantidadCriterio());
        ps.setFloat(4, logro.getPremio());
        ps.setInt(5, logro.getIdLogro());
        ps.executeUpdate();
    }

    static {
        SELECT_LOGROS = "SELECT ID_LOGRO, NOMBRE, CRITERIO, CANTIDAD_CRITERIO,\n"
                + "FECHA_CREACION, FECHA_FINAL, PREMIO \n"
                + "FROM LOGRO ORDER BY ID_LOGRO";

        SELECT_LOGRO_POR_ID = "SELECT ID_LOGRO, NOMBRE, CRITERIO, CANTIDAD_CRITERIO,\n"
                + "FECHA_CREACION, FECHA_FINAL, PREMIO \n"
                + "FROM LOGRO \n"
                + "WHERE ID_LOGRO=?";

        INSERT_LOGRO = "INSERT INTO LOGRO (NOMBRE, CRITERIO, CANTIDAD_CRITERIO,"
                + "FECHA_CREACION,FECHA_FINAL, PREMIO) \n"
                + "VALUES (?,?,?,?,?,?)";

        UPDATE_FECHA_FINAL = "UPDATE LOGRO \n"
                + "SET FECHA_FINAL=? \n"
                + "WHERE ID_LOGRO=?";

        UPDATE_LOGRO = "UPDATE LOGRO \n"
                + "SET NOMBRE=?,CRITERIO=?,CANTIDAD_CRITERIO=?,PREMIO=? \n"
                + "WHERE ID_LOGRO=?";
    }
}

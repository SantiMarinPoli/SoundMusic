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
    
    private Connection conexion;
    
    public LogroDaoImpl() {
        conexion = DBUtil.getConexion();
    }
    
    @Override
    public List<Logro> obtenerLogros() throws SQLException {
        List<Logro> lstLogros = new ArrayList<>();
        Statement stmt = conexion.createStatement();
        
        String sql = "SELECT ID_LOGRO, NOMBRE, CRITERIO, CANTIDAD_CRITERIO, FECHA_CREACION, \n"
                + "FECHA_FINAL, PREMIO FROM LOGRO";
        
        ResultSet rs = stmt.executeQuery(sql);
        
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
        String sql = "SELECT ID_LOGRO, NOMBRE, CRITERIO, CANTIDAD_CRITERIO, FECHA_CREACION, \n"
                + "FECHA_FINAL, PREMIO FROM LOGRO" + "WHERE ID_LOGRO=?";
        
        PreparedStatement ps = conexion.prepareStatement(sql);
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
        String sql = "INSERT INTO LOGRO (NOMBRE, CRITERIO, CANTIDAD_CRITERIO, FECHA_CREACION,FECHA_FINAL, PREMIO)"
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, logro.getNombreLogro());
        ps.setString(2, logro.getCriterio());
        ps.setFloat(3, logro.getCantidadCriterio());
        ps.setDate(4, logro.getFechaCreacion());
        ps.setDate(5, logro.getFechaFinal());
        ps.setFloat(6, logro.getPremio());
        ps.executeUpdate();
    }
    
    @Override
    public void eliminarLogro(int idLogro) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }
    
    @Override
    public void actualizarLogro(Logro logro) throws SQLException {
        String sql = "UPDATE LOGRO\n"
                + "SET NOMBRE=?,CRITERIO=?,CANTIDAD_CRITERIO=?,FECHA_CREACION=?,FECHA_FINAL=?,PREMIO=?"
                + "WHERE ID_LOGRO=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setString(1, logro.getNombreLogro());
        ps.setString(2, logro.getCriterio());
        ps.setFloat(3, logro.getCantidadCriterio());
        ps.setDate(4, logro.getFechaCreacion());
        ps.setDate(5, logro.getFechaFinal());
        ps.setFloat(6, logro.getPremio());
        ps.setInt(7, logro.getIdLogro());
        ps.executeUpdate();
    }
    
}

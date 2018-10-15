package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CostoActividadDaoImpl implements ICostoActividadDao {

    //Conexion a la base de datos
    private final Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_COSTO_ACTIVIDAD;
    private static final String INSERT_COSTO_ACTIVIDAD;
    private static final String UPDATE_COSTO_ACTIVIDAD;
    private static final String UPDATE_FECHA_FINAL;
    private static final String SELECT_ULTIMO_ID;
    
    public CostoActividadDaoImpl() {
        conexion = DBUtil.getConexion();
    }
    
    @Override
    public CostoActividad obtenerCostoActividad(int idCostoActividad) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_COSTO_ACTIVIDAD);
        ps.setInt(1, idCostoActividad);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            CostoActividad costoActividad = new CostoActividad(idCostoActividad,
                    rs.getFloat("COSTO_POR_OPERACION"), rs.getDate("FECHA_CREACION"),
                    rs.getDate("FECHA_USO_FINAL"));
            
            return costoActividad;
        }
        
        return null;
    }
    
    @Override
    public void crearCostoActividad(CostoActividad costoActividad) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_COSTO_ACTIVIDAD);
        
        ps.setFloat(1, costoActividad.getCostoPorOperacion());
        ps.setDate(2, costoActividad.getFechaCreacion());
        ps.executeUpdate();
    }
    
    @Override
    public void actualizarCostoActividad(CostoActividad costoActividad) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_COSTO_ACTIVIDAD);
        ps.setFloat(1, costoActividad.getCostoPorOperacion());
        ps.setInt(2, costoActividad.getIdCostoActividad());
        ps.executeUpdate();
    }
    
    @Override
    public void eliminarCostoActividad(CostoActividad costoActividad) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_FECHA_FINAL);
        ps.setDate(1, costoActividad.getFechaUsoFinal());
        ps.setInt(2, costoActividad.getIdCostoActividad());
        ps.executeUpdate();
    }
    
    @Override
    public int getUltimoIdCostoActividad() throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_ULTIMO_ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idCostoActividad = rs.getInt("CURRVAL");
            return idCostoActividad;
        }
        return -1;
    }
    
    static {
        SELECT_COSTO_ACTIVIDAD = "SELECT COSTO_POR_OPERACION, FECHA_CREACION, FECHA_USO_FINAL"
                + "FROM COSTO_ACTIVIDAD"
                + "WHERE ID_COSTO_ACTIVIDAD=?";
        
        INSERT_COSTO_ACTIVIDAD = "INSERT INTO COSTO_ACTIVITIDAD (COSTO_POR_OPERACION,FECHA_CREACION)\n"
                + "VALES (?,?)";
        
        UPDATE_COSTO_ACTIVIDAD = "UPDATE COSTO_ACTIVITIDAD \n"
                + "SET COSTO_POR_OPERACION=? \n"
                + "WHERE ID_COSTO_ACTIVIDAD=?";
        
        UPDATE_FECHA_FINAL = "UPDATE COSTO_ACTIVIDAD \n"
                + "SET FECHA_USO_FINAL=? \n"
                + "WHERE ID_COSTO_ACTIVIDAD=?";
        
        SELECT_ULTIMO_ID = "SELECT COSTO_ACTIVITIDAD_SEQ.CURRVAL\n"
                + "FROM DUAL";
    }
}

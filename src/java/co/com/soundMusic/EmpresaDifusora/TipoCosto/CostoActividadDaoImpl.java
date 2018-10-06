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
    
    private Connection conexion;
    
    public CostoActividadDaoImpl() {
        conexion = DBUtil.getConexion();
    }
    
    @Override
    public CostoActividad obtenerCostoActividad(int idCostoActividad) throws SQLException {
        String sql = "SELECT COSTO_POR_OPERACION, FECHA_CREACION, FECHA_USO_FINAL"
                + "FROM COSTO_ACTIVIDAD"
                + "WHERE ID_COSTO_ACTIVIDAD=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
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
        String sql = "INSERT INTO COSTO_ACTIVITIDAD (COSTO_POR_OPERACION,FECHA_CREACION,FECHA_USO_FINAL)\n"
                + "VALES (?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setFloat(1, costoActividad.getCostoPorOperacion());
        ps.setDate(2, costoActividad.getFechaCreacion());
        ps.setDate(3, costoActividad.getFechaUsoFinal());
        ps.executeUpdate();
    }
    
    @Override
    public void actualizarCostoActividad(CostoActividad costoActividad) throws SQLException {
        //ACTUALIZAR TODO MENOS LAS FECHAS.
        //FECHA CREACION SE IGNORA YA QUE CUANDO SE CREO SE GUARDO Y ESA QUEDA
        //FECHA FINALIZACION ES EN PARAMETRIZACION Y ES APARTE, NECESITA METODO PARA EL SOLO.
        String sql = "UPDATE COSTO_ACTIVITIDAD \n"
                + "SET COSTO_POR_OPERACION=?,FECHA_CREACION=?,FECHA_USO_FINAL=? \n"
                + "WHERE ID_COSTO_ACTIVIDAD=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        
        ps.setFloat(1, costoActividad.getCostoPorOperacion());
        ps.setDate(2, costoActividad.getFechaCreacion());
        ps.setDate(3, costoActividad.getFechaUsoFinal());
        ps.setInt(4, costoActividad.getIdCostoActividad());
        ps.executeUpdate();
    }
    
    @Override
    public int getUltimoIdCostoActividad() throws SQLException {
        String sql = "SELECT COSTO_ACTIVITIDAD_SEQ.CURRVAL\n" + "FROM DUAL";
        
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        while (rs.next()) {
            int idCostoActividad = rs.getInt("CURRVAL");
            return idCostoActividad;
        }
        return -1;
    }
}

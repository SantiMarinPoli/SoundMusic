package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    public List<CostoActividad> obtenerCostoActividad() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CostoActividad obtenerCostoActividad(int idCostoActividad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearCostoActividad(CostoActividad costoActividad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarCostoActividad(String status) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarCostoActividad(CostoActividad costoActividad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //ACTUALIZAR TODO MENOS LAS FECHAS.
        //FECHA CREACION SE IGNORA YA QUE CUANDO SE CREO SE GUARDO Y ESA QUEDA
        //FECHA FINALIZACION ES EN PARAMETRIZACION Y ES APARTE, NECESITA METODO PARA EL SOLO.
    }

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

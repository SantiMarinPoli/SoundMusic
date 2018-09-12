package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CostoActividadDaoImpl implements ICostoActividadDao{
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
    }
}

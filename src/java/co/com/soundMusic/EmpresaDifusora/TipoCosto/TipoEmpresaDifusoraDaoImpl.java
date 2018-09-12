package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class TipoEmpresaDifusoraDaoImpl implements ITipoEmpresaDifusoraDao{
    private Connection conexion;

    public TipoEmpresaDifusoraDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<TipoEmpresaDifusora> obtenerTipoEmpresaDifusora() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoEmpresaDifusora obtenerTipoEmpresaDifusora(int idTipoEmpresaDifusora) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearArtista(TipoEmpresaDifusora tipoEmpresaDifusora) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarTipoEmpresaDifusora(String status) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarTipoEmpresaDifusora(TipoEmpresaDifusora tipoEmpresaDifusora) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

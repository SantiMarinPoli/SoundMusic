package co.com.soundMusic.Informes.LogAuditoria;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class LogAuditoriaDaoImpl implements ILogAuditoriaDao{
    private Connection conexion;

    public LogAuditoriaDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<LogAuditoria> obtenerLogAuditoria() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearLog(LogAuditoria logAuditoria) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

package co.com.soundMusic.LogAuditoria;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface ILogAuditoriaDao {

    List<LogAuditoria> obtenerLogAuditoria() throws SQLException;

    List<LogAuditoria> obtenerLogAuditoriaPorUsuario(int idUsuario) throws SQLException;

    void crearLog(LogAuditoria logAuditoria) throws SQLException;
}

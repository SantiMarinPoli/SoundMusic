package co.com.soundMusic.LogAuditoria;

import co.com.soundMusic.Login.Usuario.UsuarioDaoImpl;
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
public class LogAuditoriaDaoImpl implements ILogAuditoriaDao {

    private final Connection conexion;
    private final UsuarioDaoImpl usuario;

    public LogAuditoriaDaoImpl() {
        conexion = DBUtil.getConexion();
        usuario = new UsuarioDaoImpl();
    }

    @Override
    public List<LogAuditoria> obtenerLogAuditoria() throws SQLException {
        List<LogAuditoria> listaLogAuditoria = new ArrayList<>();

        String sql = "SELECT ID_LOG_AUDITORIA,FECHA,ID_USUARIO,ID_OPERACION\n"
                + "FROM LOG_AUDITORIA \n"
                + "ORDER BY ID_LOG_AUDITORIA";

        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int idLogAuditoria = rs.getInt("ID_LOG_AUDITORIA");
            Date fecha = rs.getDate("FECHA");
            int idUsuario = rs.getInt("ID_USUARIO");
            int idOperaciones = rs.getInt("ID_OPERACION");

            LogAuditoria logAuditoria = new LogAuditoria(idLogAuditoria, fecha,
                    usuario.obtenerUsuario(idUsuario),
                    idOperaciones);

            logAuditoria.obtenerPermiso();
            

            listaLogAuditoria.add(logAuditoria);
        }

        stmt.close();
        return listaLogAuditoria;
    }

    @Override
    public void crearLog(LogAuditoria logAuditoria) throws SQLException {
        String sql = "INSERT INTO LOG_AUDITORIA (FECHA,ID_USUARIO,ID_OPERACION)\n"
                + "VALUES (?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setDate(1, logAuditoria.getFecha());
        ps.setInt(2, logAuditoria.getUsuario().getIdUsuario());
        ps.setInt(3, logAuditoria.getIdPermiso());
        ps.executeUpdate();
    }

    @Override
    public List<LogAuditoria> obtenerLogAuditoriaPorUsuario(int idUsuario) throws SQLException {
        List<LogAuditoria> listaLogAuditoria = new ArrayList<>();

        String sql = "SELECT ID_LOG_AUDITORIA,FECHA,ID_USUARIO,ID_OPERACION\n"
                + "FROM LOG_AUDITORIA \n"
                + "WHERE ID_USUARIO=? \n"
                + "ORDER BY ID_LOG_AUDITORIA";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery(sql);

        while (rs.next()) {
            int idLogAuditoria = rs.getInt("ID_LOG_AUDITORIA");
            Date fecha = rs.getDate("FECHA");
            int idOperaciones = rs.getInt("ID_OPERACION");

            LogAuditoria logAuditoria = new LogAuditoria(idLogAuditoria, fecha,
                    usuario.obtenerUsuario(idUsuario),
                    idOperaciones);

            logAuditoria.obtenerPermiso();

            listaLogAuditoria.add(logAuditoria);
        }

        return listaLogAuditoria;
    }
}

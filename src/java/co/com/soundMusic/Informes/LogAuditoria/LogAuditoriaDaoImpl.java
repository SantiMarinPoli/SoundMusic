package co.com.soundMusic.Informes.LogAuditoria;

import co.com.soundMusic.Seguridad.PermisosYPerfiles.PermisosDaoImpl;
import co.com.soundMusic.Seguridad.Usuario.UsuarioDaoImpl;
import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class LogAuditoriaDaoImpl implements ILogAuditoriaDao {

    private Connection conexion;
    private UsuarioDaoImpl usuario;
    private PermisosDaoImpl operaciones;

    public LogAuditoriaDaoImpl() {
        conexion = DBUtil.getConexion();
        usuario = new UsuarioDaoImpl();
        operaciones = new PermisosDaoImpl();
    }

    @Override
    public List<LogAuditoria> obtenerLogAuditoria() throws SQLException {
        List<LogAuditoria> listaLogAuditoria = new ArrayList<>();
        Statement stmt = conexion.createStatement();
        String sql = "SELECT ID_LOG_AUDITORIA,FECHA,HORA,ID_USUARIO_LOG,ID_OPERACION_LOG\n" + "FROM LOG_AUDITORIA;";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int idLogAuditoria = rs.getInt("ID_LOG_AUDITORIA");
            Date fecha = rs.getDate("FECHA");
            Time hora = rs.getTime("HORA");
            int idUsuario = rs.getInt("ID_USUARIO_LOG");
            int idOperaciones = rs.getInt("ID_OPERACION_LOG");

            LogAuditoria logAuditoria = new LogAuditoria(idLogAuditoria, fecha,
                    hora, usuario.obtenerUsuario(idUsuario),
                    operaciones.obtenerPermiso(idOperaciones));
            listaLogAuditoria.add(logAuditoria);
        }

        stmt.close();
        return listaLogAuditoria;
    }

    @Override
    public void crearLog(LogAuditoria logAuditoria) throws SQLException {
        String sql = "INSERT INTO LOG_AUDITORIA (FECHA,HORA,ID_USUARIO_LOG,ID_OPERACION_LOG)\n"
                + "VALUES (?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setDate(1, logAuditoria.getFecha());
        ps.setTime(2, logAuditoria.getHora());
        ps.setInt(3, logAuditoria.getUsuario().getIdUsuario());
        ps.setInt(4, logAuditoria.getOperaciones().getIdPermiso());
        ps.executeUpdate();
    }

}

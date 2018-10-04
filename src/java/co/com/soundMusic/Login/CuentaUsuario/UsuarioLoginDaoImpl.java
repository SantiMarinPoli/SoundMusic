package co.com.soundMusic.Login.CuentaUsuario;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuarioLoginDaoImpl implements IUsuarioLoginDao {

    private Connection conexion;

    public UsuarioLoginDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public UsuarioLogin obtenerUsuarioLogin(int idUsuarioLogin) throws SQLException {
        String sql = "SELECT NOMBRE_USUARIO,CONTRASENA\n"
                + "FROM USUARIO_LOGIN\n"
                + "WHERE ID_USUARIO_LOGIN=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idUsuarioLogin);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombreUsuario = rs.getString("NOMBRE_USUARIO");
            String contrasenaUsuario = rs.getString("CONTRASENA");

            UsuarioLogin usuarioLogin = new UsuarioLogin(idUsuarioLogin,
                    nombreUsuario, contrasenaUsuario);
            return usuarioLogin;
        }
        return null;
    }

    @Override
    public void crearUsuarioLogin(UsuarioLogin usuarioLogin) throws SQLException {
        String sql = "INSERT INTO USUARIO_LOGIN (NOMBRE_USUARIO,CONTRASENA)\n"
                + "VALUES (?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, usuarioLogin.getNombreUsuario());
        ps.setString(2, usuarioLogin.getContrasena());
        ps.executeUpdate();
    }

    @Override
    public void actualizarUsuarioLogin(UsuarioLogin usuarioLogin) throws SQLException {
        String sql = "UPDATE USUARIO_LOGIN\n"
                + "SET NOMBRE_USUARIO=?,CONTRASENA=?\n"
                + "WHERE ID_USUARIO_LOGIN=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, usuarioLogin.getNombreUsuario());
        ps.setString(2, usuarioLogin.getContrasena());
        ps.setInt(3, usuarioLogin.getIdUsuarioLogin());
        ps.executeUpdate();
    }

    public boolean sesionPermitida(String nombreUsuario, String password) throws SQLException {
        String sql = "SELECT * FROM USUARIO_LOGIN WHERE \n"
                + "NOMBRE_USUARIO=? AND CONTRASENA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, nombreUsuario);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return true;
        }
        return false;
    }

    public int getUltimmoIdUsuarioLogin() throws SQLException {
        String sql = "SELECT USUARIO_LOGIN_SEQ.CURRVAL\n" + "FROM DUAL";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        while (rs.next()) {
            int idUsuarioLogin = rs.getInt("CURRVAL");
            return idUsuarioLogin;
        }
        return -1;
    }
}

package co.com.soundMusic.Login.CuentaUsuario;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuarioLoginDaoImpl implements IUsuarioLoginDao {

    //Conexion a la base de datos
    private Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_USUARIOLOGIN_POR_ID;
    private static final String INSERT_USUARIOLOGIN;
    private static final String UPDATE_USUARIOLOGIN;
    private static final String SELECT_ULTIMO_ID;

    public UsuarioLoginDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public UsuarioLogin obtenerUsuarioLogin(int idUsuarioLogin) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_USUARIOLOGIN_POR_ID);
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
        PreparedStatement ps = conexion.prepareStatement(INSERT_USUARIOLOGIN);

        ps.setString(1, usuarioLogin.getNombreUsuario());
        ps.setString(2, usuarioLogin.getContrasena());
        ps.executeUpdate();
    }

    @Override
    public void actualizarUsuarioLogin(UsuarioLogin usuarioLogin) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_USUARIOLOGIN);
        ps.setString(1, usuarioLogin.getNombreUsuario());
        ps.setString(2, usuarioLogin.getContrasena());
        ps.setInt(3, usuarioLogin.getIdUsuarioLogin());
        ps.executeUpdate();
    }

    public int getUltimmoIdUsuarioLogin() throws SQLException {
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_ULTIMO_ID);
        while (rs.next()) {
            int idUsuarioLogin = rs.getInt("CURRVAL");
            return idUsuarioLogin;
        }
        return -1;
    }

    static {
        SELECT_USUARIOLOGIN_POR_ID = "SELECT NOMBRE_USUARIO,CONTRASENA\n"
                + "FROM USUARIO_LOGIN\n"
                + "WHERE ID_USUARIO_LOGIN=?";

        INSERT_USUARIOLOGIN = "INSERT INTO USUARIO_LOGIN (NOMBRE_USUARIO,CONTRASENA)\n"
                + "VALUES (?,?)";

        UPDATE_USUARIOLOGIN = "UPDATE USUARIO_LOGIN\n"
                + "SET NOMBRE_USUARIO=?,CONTRASENA=?\n"
                + "WHERE ID_USUARIO_LOGIN=?";

        SELECT_ULTIMO_ID = "SELECT USUARIO_LOGIN_SEQ.CURRVAL\n"
                + "FROM DUAL";
    }
}

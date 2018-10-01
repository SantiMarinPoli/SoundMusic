package co.com.soundMusic.Login.Usuario;

import co.com.soundMusic.Contacto.ContactoDaoImpl;
import co.com.soundMusic.Login.CuentaUsuario.UsuarioLoginDaoImpl;
import co.com.soundMusic.Seguridad.Perfiles.PerfilDaoImpl;
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
public class UsuarioDaoImpl implements IUsuarioDao {

    private Connection conexion;
    private ContactoDaoImpl contacto;
    private UsuarioLoginDaoImpl usuarioLogin;
    private PerfilDaoImpl perfil;

    public UsuarioDaoImpl() {
        conexion = DBUtil.getConexion();
        contacto = new ContactoDaoImpl();
        usuarioLogin = new UsuarioLoginDaoImpl();
        perfil = new PerfilDaoImpl();
    }

    @Override
    public List<Usuario> obtenerUsuarios() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT ID_USUARIO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,ID_PERFIL_USUARIO,ID_LOGIN_USUARIO,ID_CONTACTO_USUARIO\n"
                + "FROM USUARIO";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int idUsuario = rs.getInt("ID_USUARIO");
            String primerNombre = rs.getString("PRIMER_NOMBRE");
            String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            String status = rs.getString("STATUS");
            int idPerfilUsuario = rs.getInt("ID_PERFIL_USUARIO");
            int idLoginUsuario = rs.getInt("ID_LOGIN_USUARIO");
            int idContacto = rs.getInt("ID_CONTACTO_USUARIO");

            Usuario usuario = new Usuario(idUsuario, primerNombre, segundoNombre,
                    primerApellido, segundoApellido, fechaCreacion, status,
                    perfil.obtenerPerfil(idPerfilUsuario),
                    usuarioLogin.obtenerUsuarioLogin(idLoginUsuario),
                    contacto.obtenerContacto(idContacto));
            listaUsuarios.add(usuario);
        }

        stmt.close();
        return listaUsuarios;
    }

    @Override
    public Usuario obtenerUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT ID_USUARIO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,ID_PERFIL_USUARIO,ID_LOGIN_USUARIO,ID_CONTACTO_USUARIO\n"
                + "FROM USUARIO\n"
                + "WHERE ID_USUARIO=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String primerNombre = rs.getString("PRIMER_NOMBRE");
            String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            String status = rs.getString("STATUS");
            int idPerfilUsuario = rs.getInt("ID_PERFIL_USUARIO");
            int idLoginUsuario = rs.getInt("ID_LOGIN_USUARIO");
            int idContacto = rs.getInt("ID_CONTACTO_USUARIO");

            Usuario usuario = new Usuario(idUsuario, primerNombre, segundoNombre,
                    primerApellido, segundoApellido, fechaCreacion, status,
                    perfil.obtenerPerfil(idPerfilUsuario),
                    usuarioLogin.obtenerUsuarioLogin(idLoginUsuario),
                    contacto.obtenerContacto(idContacto));

            return usuario;
        }

        return null;
    }

    @Override
    public void crearUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIO (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,ID_PERFIL_USUARIO,ID_LOGIN_USUARIO,ID_CONTACTO_USUARIO)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, usuario.getPrimerNombre());
        ps.setString(2, usuario.getSegundoNombre());
        ps.setString(3, usuario.getPrimerApellido());
        ps.setString(4, usuario.getSegundoApellido());
        ps.setDate(5, usuario.getFechaCreacion());
        ps.setString(6, usuario.getStatus());
        ps.setInt(7, usuario.getPerfil().getIdPerfil());
        ps.setInt(8, usuario.getUsuarioLogin().getIdUsuarioLogin());
        ps.setInt(9, usuario.getContacto().getIdContacto());
        ps.executeUpdate();
    }

    @Override
    public void eliminarUsuario(String status, int idUsuario) throws SQLException {
        String sql = "UPDATE USUARIO\n"
                + "SET STATUS=?\n"
                + "WHERE ID_USUARIO=?;";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, idUsuario);
        ps.executeUpdate();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE USUARIO\n"
                + "SET PRIMER_NOMBRE=?,SEGUNDO_NOMBRE=?,PRIMER_APELLIDO=?,SEGUNDO_APELLIDO=?,\n"
                + "FECHA_CREACION=?,STATUS=?,ID_PERFIL_USUARIO=?,ID_LOGIN_USUARIO=?,ID_CONTACTO_USUARIO=?\n"
                + "WHERE ID_USUARIO=?; ";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, usuario.getPrimerNombre());
        ps.setString(2, usuario.getSegundoNombre());
        ps.setString(3, usuario.getPrimerApellido());
        ps.setString(4, usuario.getSegundoApellido());
        ps.setDate(5, usuario.getFechaCreacion());
        ps.setString(6, usuario.getStatus());
        ps.setInt(7, usuario.getPerfil().getIdPerfil());
        ps.setInt(8, usuario.getUsuarioLogin().getIdUsuarioLogin());
        ps.setInt(9, usuario.getContacto().getIdContacto());
        ps.setInt(10, usuario.getIdUsuario());
        ps.executeUpdate();
    }

    public int getUltimoIdUsuario() throws SQLException {
        String sql = "SELECT USUARIO_SEQ.CURRVAL\n"
                + "FROM DUAL";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        while (rs.next()) {
            int idUsuario = rs.getInt("CURRVAL");
            return idUsuario;
        }
        return -1;
    }

}

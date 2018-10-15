package co.com.soundMusic.Login.Usuario;

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

    //Conexion a la base de datos
    private final Connection conexion;
    
    //Constantes con las querys a la base de datos
    private static final String SELECT_USUARIOS;
    private static final String SELECT_USUARIO_POR_ID;
    private static final String INSERT_USUARIO;
    private static final String UPDATE_STATUS;
    private static final String UPDTAE_USUARIO;
    private static final String SELECT_ULTIMO_ID;

    public UsuarioDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Usuario> obtenerUsuarios() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_USUARIOS);

        while (rs.next()) {
            int idUsuario = rs.getInt("ID_USUARIO");
            String primerNombre = rs.getString("PRIMER_NOMBRE");
            String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            String status = rs.getString("STATUS");
            String genero = rs.getString("GENERO");
            int idPerfilUsuario = rs.getInt("ID_PERFIL");
            int idLoginUsuario = rs.getInt("ID_USUARIO_LOGIN");
            int idContacto = rs.getInt("ID_CONTACTO");

            Usuario usuario = new Usuario(idUsuario, primerNombre, segundoNombre,
                    primerApellido, segundoApellido, fechaCreacion, status,
                    genero, idPerfilUsuario, idLoginUsuario, idContacto);

            usuario.obtenerContactoUsuario();
            usuario.obtenerPerfilUsuario();
            usuario.obtenerUsuarioLogin();

            listaUsuarios.add(usuario);
        }

        stmt.close();
        return listaUsuarios;
    }

    @Override
    public Usuario obtenerUsuario(int idUsuario) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_USUARIO_POR_ID);       
        ps.setInt(1, idUsuario);       
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String primerNombre = rs.getString("PRIMER_NOMBRE");
            String segundoNombre = rs.getString("SEGUNDO_NOMBRE");
            String primerApellido = rs.getString("PRIMER_APELLIDO");
            String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            String status = rs.getString("STATUS");
            String genero = rs.getString("GENERO");
            int idPerfilUsuario = rs.getInt("ID_PERFIL");
            int idLoginUsuario = rs.getInt("ID_USUARIO_LOGIN");
            int idContacto = rs.getInt("ID_CONTACTO");

            Usuario usuario = new Usuario(idUsuario, primerNombre, segundoNombre,
                    primerApellido, segundoApellido, fechaCreacion, status,
                    genero, idPerfilUsuario, idLoginUsuario, idContacto);

            usuario.obtenerContactoUsuario();
            usuario.obtenerPerfilUsuario();
            usuario.obtenerUsuarioLogin();

            return usuario;
        }

        return null;
    }

    @Override
    public void crearUsuario(Usuario usuario) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_USUARIO);

        ps.setString(1, usuario.getPrimerNombre());
        ps.setString(2, usuario.getSegundoNombre());
        ps.setString(3, usuario.getPrimerApellido());
        ps.setString(4, usuario.getSegundoApellido());
        ps.setDate(5, usuario.getFechaCreacion());
        ps.setString(6, usuario.getStatus());
        ps.setString(7, usuario.getGenero());
        ps.setInt(8, usuario.getIdPerfil());
        ps.setInt(9, usuario.getIdUsuarioLogin());
        ps.setInt(10, usuario.getIdContacto());
        ps.executeUpdate();
    }

    @Override
    public void eliminarUsuario(String status, int idUsuario) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_STATUS);
        ps.setString(1, status);
        ps.setInt(2, idUsuario);
        ps.executeUpdate();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDTAE_USUARIO);

        ps.setString(1, usuario.getPrimerNombre());
        ps.setString(2, usuario.getSegundoNombre());
        ps.setString(3, usuario.getPrimerApellido());
        ps.setString(4, usuario.getSegundoApellido());
        ps.setDate(5, usuario.getFechaCreacion());
        ps.setString(6, usuario.getStatus());
        ps.setString(7, usuario.getGenero());
        ps.setInt(8, usuario.getIdPerfil());
        ps.setInt(9, usuario.getIdUsuarioLogin());
        ps.setInt(10, usuario.getIdContacto());
        ps.setInt(11, usuario.getIdUsuario());
        ps.executeUpdate();
    }

    public int getUltimoIdUsuario() throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_ULTIMO_ID);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int idUsuario = rs.getInt("CURRVAL");
            return idUsuario;
        }
        return -1;
    }

    static {
        SELECT_USUARIOS = "SELECT ID_USUARIO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,GENERO,ID_PERFIL,ID_USUARIO_LOGIN,ID_CONTACTO\n"
                + "FROM USUARIO";

        SELECT_USUARIO_POR_ID = "SELECT ID_USUARIO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,GENERO,ID_PERFIL,ID_USUARIO_LOGIN,ID_CONTACTO\n"
                + "FROM USUARIO\n"
                + "WHERE ID_USUARIO=?";

        INSERT_USUARIO = "INSERT INTO USUARIO (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,GENERO,ID_PERFIL,ID_USUARIO_LOGIN,ID_CONTACTO\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";

        UPDATE_STATUS = "UPDATE USUARIO\n"
                + "SET STATUS=?\n"
                + "WHERE ID_USUARIO=?";

        UPDTAE_USUARIO = "UPDATE USUARIO\n"
                + "SET PRIMER_NOMBRE=?,SEGUNDO_NOMBRE=?,PRIMER_APELLIDO=?,SEGUNDO_APELLIDO=?,\n"
                + "FECHA_CREACION=?,STATUS=?, GENERO=?,ID_PERFIL_USUARIO=?,ID_LOGIN_USUARIO=?,ID_CONTACTO_USUARIO=?\n"
                + "WHERE ID_USUARIO=?";

        SELECT_ULTIMO_ID = "SELECT USUARIO_SEQ.CURRVAL\n"
                + "FROM DUAL";
    }
}

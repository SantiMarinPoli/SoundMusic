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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuarioDaoImpl implements IUsuarioDao {

    //Conexion a la base de datos
    private final Connection conexion;

    private Statement stmt;
    private ResultSet rs;
    //Constantes con las querys a la base de datos
    private static final String SELECT_USUARIOS;
    private static final String SELECT_USUARIO_POR_ID;
    private static final String INSERT_USUARIO;
    private static final String UPDATE_STATUS;
    private static final String UPDTAE_USUARIO;
    private static final String SELECT_ULTIMO_ID;

    public UsuarioDaoImpl(Boolean production) {
        if (production) {
            conexion = DBUtil.getConexion();
        } else {
            conexion = DBUtil.getTestConexion();
        }
        stmt = null;
        rs = null;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SELECT_USUARIOS);

            while (rs.next()) {
                Integer idUsuario = rs.getInt("ID_USUARIO");
                String primerNombre = rs.getString("PRIMER_NOMBRE");
                String segundoNombre = validacion(rs.getString("SEGUNDO_NOMBRE"));
                String primerApellido = rs.getString("PRIMER_APELLIDO");
                String segundoApellido = validacion(rs.getString("SEGUNDO_APELLIDO"));
                Date fechaCreacion = rs.getDate("FECHA_CREACION");
                String status = rs.getString("STATUS");
                String genero = validacion(rs.getString("GENERO"));
                Integer idPerfilUsuario = rs.getInt("ID_PERFIL");
                Integer idLoginUsuario = rs.getInt("ID_USUARIO_LOGIN");
                Integer idContacto = rs.getInt("ID_CONTACTO");

                Usuario usuario = new Usuario(idUsuario, primerNombre, segundoNombre,
                        primerApellido, segundoApellido, fechaCreacion, status,
                        genero, idPerfilUsuario, idLoginUsuario, idContacto);

                usuario.obtenerContactoUsuario();
                usuario.obtenerPerfilUsuario();
                usuario.obtenerUsuarioLogin();

                listaUsuarios.add(usuario);
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (conexion != null) {
                    DbUtils.close(rs);
                    DbUtils.close(stmt);
                    DbUtils.close(conexion);                                        
                    Thread.sleep(1000);
                }
            } catch (InterruptedException | SQLException ex) {
                Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaUsuarios;
    }

    @Override
    public Usuario obtenerUsuario(int idUsuario) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_USUARIO_POR_ID);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                String primerNombre = rs.getString("PRIMER_NOMBRE");
                String segundoNombre = validacion(rs.getString("SEGUNDO_NOMBRE"));
                String primerApellido = rs.getString("PRIMER_APELLIDO");
                String segundoApellido = validacion(rs.getString("SEGUNDO_APELLIDO"));
                Date fechaCreacion = rs.getDate("FECHA_CREACION");
                String status = rs.getString("STATUS");
                String genero = validacion(rs.getString("GENERO"));
                int idPerfilUsuario = rs.getInt("ID_PERFIL");
                int idLoginUsuario = rs.getInt("ID_USUARIO_LOGIN");
                int idContacto = rs.getInt("ID_CONTACTO");

                usuario = new Usuario(idUsuario, primerNombre, segundoNombre,
                        primerApellido, segundoApellido, fechaCreacion, status,
                        genero, idPerfilUsuario, idLoginUsuario, idContacto);

                usuario.obtenerContactoUsuario();
                usuario.obtenerPerfilUsuario();
                usuario.obtenerUsuarioLogin();

                return usuario;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
        return usuario;
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        try {
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
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
    }

    @Override
    public void eliminarUsuario(String status, int idUsuario) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_STATUS);
            ps.setString(1, status);
            ps.setInt(2, idUsuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        try {
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
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
    }

    public int getUltimoIdUsuario() {
        int idUsuario = -1;
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_ULTIMO_ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                idUsuario = rs.getInt("CURRVAL");
                return idUsuario;
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conexion != null) {
                DbUtils.closeQuietly(conexion, stmt, rs);
            }
        }
        return idUsuario;
    }

    static {
        SELECT_USUARIOS = "SELECT ID_USUARIO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,GENERO,ID_PERFIL,ID_USUARIO_LOGIN,ID_CONTACTO\n"
                + "FROM USUARIO ORDER BY ID_USUARIO";

        SELECT_USUARIO_POR_ID = "SELECT ID_USUARIO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,GENERO,ID_PERFIL,ID_USUARIO_LOGIN,ID_CONTACTO\n"
                + "FROM USUARIO\n"
                + "WHERE ID_USUARIO=?";

        INSERT_USUARIO = "INSERT INTO USUARIO (PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,\n"
                + "FECHA_CREACION,STATUS,GENERO,ID_PERFIL,ID_USUARIO_LOGIN,ID_CONTACTO)\n"
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

    private String validacion(String aValidar) {
        if (aValidar != null) {
            return aValidar.trim();
        } else {
            return "";
        }
    }
}

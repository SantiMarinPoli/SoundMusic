package co.com.soundMusic.Seguridad.Perfiles;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
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
public class PerfilDaoImpl implements IPerfilDao {

    //Conexion a la base de datos
    private Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_PERFILES;
    private static final String SELECT_PERFIL_POR_ID;
    private static final String INSERT_PERFIL;
    private static final String UPDATE_PERFIL;

    public PerfilDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<Perfil> obtenerPerfiles() throws SQLException {
        List<Perfil> listaPerfiles = new ArrayList<>();
        
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_PERFILES);

        while (rs.next()) {

            int idPerfil = Integer.parseInt(rs.getString("ID_PERFIL"));
            String nombrePerfil = rs.getString("NOMBRE_PERFIL");

            Perfil perfil = new Perfil(idPerfil, nombrePerfil);
            listaPerfiles.add(perfil);
        }

        stmt.close();
        return listaPerfiles;
    }

    @Override
    public Perfil obtenerPerfil(int idPerfil) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_PERFIL_POR_ID);
        ps.setInt(1, idPerfil);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombrePerfil = rs.getString("NOMBRE_PERFIL");

            Perfil perfil = new Perfil(idPerfil, nombrePerfil);
            return perfil;
        }
        return null;
    }

    @Override
    public void crearPerfil(Perfil perfil) throws SQLException {        
        PreparedStatement ps = conexion.prepareStatement(INSERT_PERFIL);

        ps.setString(1, perfil.getNombrePerfil());
        ps.executeUpdate();
    }

    @Override
    public void actualizarPerfil(Perfil perfil) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_PERFIL);
        
        ps.setString(1, perfil.getNombrePerfil());
        ps.setInt(2, perfil.getIdPerfil());
        ps.executeUpdate();
    }

    static {
        SELECT_PERFILES= "SELECT ID_PERFIL, NOMBRE_PERFIL\n"
                + "FROM PERFIL ORDER BY ID_PERFIL";
        
        SELECT_PERFIL_POR_ID= "SELECT NOMBRE_PERFIL\n"
                + "FROM PERFIL\n"
                + "WHERE ID_PERFIL=?";
        
        INSERT_PERFIL= "INSERT INTO PERFIL (NOMBRE_PERFIL)\n"
                + "VALUES (?)";
        
        UPDATE_PERFIL="UPDATE PERFIL \n"
                +"SET NOMBRE_PERFIL=? \n"
                +"WHERE ID_PERFIL=?";
    }
}

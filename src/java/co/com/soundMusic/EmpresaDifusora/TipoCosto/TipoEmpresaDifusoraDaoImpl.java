package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
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
public class TipoEmpresaDifusoraDaoImpl implements ITipoEmpresaDifusoraDao {

//Conexion a la base de datos
    private final Connection conexion;
    private Statement stmt;
    private ResultSet rs;
    //Constantes con las querys a la base de datos
    private static final String SELECT_TIPOS_EMPRESAS;
    private static final String SELECT_TIPO_EMPRESA_POR_ID;
    private static final String INSERT_TIPO_EMPRESA;
    private static final String UPDATE_TIPO_EMPRESA;

    public TipoEmpresaDifusoraDaoImpl(Boolean production) {
        if (production) {
            conexion = DBUtil.getConexion();
        } else {
            conexion = DBUtil.getTestConexion();
        }
        stmt = null;
        rs = null;
    }

    @Override
    public List<TipoEmpresaDifusora> obtenerTipoEmpresaDifusora() {
        List<TipoEmpresaDifusora> lstTipoEmpresa = new ArrayList<>();
        try {
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(SELECT_TIPOS_EMPRESAS);

            while (rs.next()) {
                int idTipoEmpresaDifusora = rs.getInt("ID_TIPO_ACTIVIDAD");
                String tipoActividad = rs.getString("NOMBRE");

                TipoEmpresaDifusora tipoEmpresa = new TipoEmpresaDifusora(idTipoEmpresaDifusora, tipoActividad);

                lstTipoEmpresa.add(tipoEmpresa);
            }

        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(TipoEmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
        return lstTipoEmpresa;
    }

    @Override
    public TipoEmpresaDifusora obtenerTipoEmpresaDifusora(int idTipoEmpresaDifusora) {
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_TIPO_EMPRESA_POR_ID);

            ps.setInt(1, idTipoEmpresaDifusora);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tipoActividad = rs.getString("NOMBRE");

                TipoEmpresaDifusora tipoEmpresa = new TipoEmpresaDifusora(idTipoEmpresaDifusora, tipoActividad);

                return tipoEmpresa;
            }
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(TipoEmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
        return null;
    }

    @Override
    public void crearArtista(TipoEmpresaDifusora tipoEmpresaDifusora) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_TIPO_EMPRESA);
            ps.setString(1, tipoEmpresaDifusora.getTipoActividad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(TipoEmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
    }

    @Override
    public void actualizarTipoEmpresaDifusora(TipoEmpresaDifusora tipoEmpresaDifusora) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_TIPO_EMPRESA);
            ps.setString(1, tipoEmpresaDifusora.getTipoActividad());
            ps.setInt(2, tipoEmpresaDifusora.getIdTipoActividad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(TipoEmpresaDifusoraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
    }

    static {
        SELECT_TIPOS_EMPRESAS = "SELECT ID_TIPO_ACTIVIDAD, NOMRE \n"
                + "FROM TIPO_ACTIVIDAD \n"
                + "ORDER BY ID_TIPO_ACTIVIDAD";

        SELECT_TIPO_EMPRESA_POR_ID = "SELECT NOMRE \n"
                + "FROM TIPO_ACTIVIDAD \n"
                + "WHERE ID_TIPO_ACTIVIDAD=?";

        INSERT_TIPO_EMPRESA = "INSERT INTO TIPO_ACTIVIDAD (NOMBRE)\n"
                + "VALUES(?)";

        UPDATE_TIPO_EMPRESA = "UPDATE TIPO_ACTIVIDAD\n"
                + "SET NOMBRE=? \n"
                + "WHERE ID_TIPO_ACTIVIDAD=?";
    }
}

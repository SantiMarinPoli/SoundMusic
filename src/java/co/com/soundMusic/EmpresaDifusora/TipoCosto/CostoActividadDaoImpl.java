package co.com.soundMusic.EmpresaDifusora.TipoCosto;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CostoActividadDaoImpl implements ICostoActividadDao {

    //Conexion a la base de datos
    private final Connection conexion;

    private Statement stmt;
    private ResultSet rs;
    //Constantes con las querys a la base de datos
    private static final String SELECT_COSTO_ACTIVIDAD;
    private static final String INSERT_COSTO_ACTIVIDAD;
    private static final String UPDATE_COSTO_ACTIVIDAD;
    private static final String UPDATE_FECHA_FINAL;
    private static final String SELECT_ULTIMO_ID;

    public CostoActividadDaoImpl(Boolean production) {
        if (production) {
            conexion = DBUtil.getConexion();
        } else {
            conexion = DBUtil.getTestConexion();
        }
        stmt = null;
        rs = null;
    }

    @Override
    public CostoActividad obtenerCostoActividad(int idCostoActividad) {
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_COSTO_ACTIVIDAD);
            ps.setInt(1, idCostoActividad);
            rs = ps.executeQuery();

            while (rs.next()) {
                CostoActividad costoActividad = new CostoActividad(idCostoActividad,
                        rs.getFloat("COSTO_POR_OPERACION"), rs.getDate("FECHA_CREACION"),
                        rs.getDate("FECHA_USO_FINAL"));

                return costoActividad;
            }
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CostoActividadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
        return null;
    }

    @Override
    public void crearCostoActividad(CostoActividad costoActividad) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_COSTO_ACTIVIDAD);

            ps.setFloat(1, costoActividad.getCostoPorOperacion());
            ps.setDate(2, costoActividad.getFechaCreacion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CostoActividadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
    }

    @Override
    public void actualizarCostoActividad(CostoActividad costoActividad) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_COSTO_ACTIVIDAD);
            ps.setFloat(1, costoActividad.getCostoPorOperacion());
            ps.setInt(2, costoActividad.getIdCostoActividad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CostoActividadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
    }

    @Override
    public void eliminarCostoActividad(CostoActividad costoActividad) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_FECHA_FINAL);
            ps.setDate(1, costoActividad.getFechaUsoFinal());
            ps.setInt(2, costoActividad.getIdCostoActividad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CostoActividadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
    }

    @Override
    public int getUltimoIdCostoActividad() {
        try {
            PreparedStatement ps = conexion.prepareStatement(SELECT_ULTIMO_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idCostoActividad = rs.getInt("CURRVAL");
                return idCostoActividad;
            }
        } catch (SQLException ex) {
            System.out.println("Excepción " + ex.getMessage());
            Logger.getLogger(CostoActividadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbUtils.closeQuietly(conexion, stmt, rs);
        }
        return -1;
    }

    static {
        SELECT_COSTO_ACTIVIDAD = "SELECT COSTO_POR_OPERACION, FECHA_CREACION, FECHA_USO_FINAL"
                + "FROM COSTO_ACTIVIDAD"
                + "WHERE ID_COSTO_ACTIVIDAD=?";

        INSERT_COSTO_ACTIVIDAD = "INSERT INTO COSTO_ACTIVITIDAD (COSTO_POR_OPERACION,FECHA_CREACION)\n"
                + "VALES (?,?)";

        UPDATE_COSTO_ACTIVIDAD = "UPDATE COSTO_ACTIVITIDAD \n"
                + "SET COSTO_POR_OPERACION=? \n"
                + "WHERE ID_COSTO_ACTIVIDAD=?";

        UPDATE_FECHA_FINAL = "UPDATE COSTO_ACTIVIDAD \n"
                + "SET FECHA_USO_FINAL=? \n"
                + "WHERE ID_COSTO_ACTIVIDAD=?";

        SELECT_ULTIMO_ID = "SELECT COSTO_ACTIVITIDAD_SEQ.CURRVAL\n"
                + "FROM DUAL";
    }
}

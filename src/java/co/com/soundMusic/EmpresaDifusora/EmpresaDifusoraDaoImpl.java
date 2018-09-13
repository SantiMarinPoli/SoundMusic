package co.com.soundMusic.EmpresaDifusora;

import co.com.soundMusic.Contacto.ContactoDaoImpl;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.CostoActividadDaoImpl;
import co.com.soundMusic.EmpresaDifusora.TipoCosto.TipoEmpresaDifusoraDaoImpl;
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
public class EmpresaDifusoraDaoImpl implements IEmpresaDifusoraDao {

    private Connection conexion;
    private ContactoDaoImpl contacto;
    private CostoActividadDaoImpl costoOperacion;
    private TipoEmpresaDifusoraDaoImpl tipoActividad;

    private EmpresaDifusoraDaoImpl() {
        conexion = DBUtil.getConexion();
        contacto = new ContactoDaoImpl();
        costoOperacion = new CostoActividadDaoImpl();
        tipoActividad = new TipoEmpresaDifusoraDaoImpl();
    }

    @Override
    public List<EmpresaDifusora> obtenerEmpresasDifusoras() throws SQLException {
        List<EmpresaDifusora> listaEmpresasDifusora = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        String sql = "SELECT ID_EMPRESA_DIFUSORA,NOMBRE_EMPRESA,FECHA_CREACION,FECHA_TERMINACION,STATUS,\n"
                + "ID_TIPO_EMPRESA, ID_CONTACTO_EMPRESA, ID_COSTO_OPERACION\n"
                + "FROM EMPRESA_DIFUSORA";

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int idEmpresaDifusora = rs.getInt("ID_EMPRESA_DIFUSORA");
            String nombreEmpresa = rs.getString("NOMBRE_EMPRESA");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            Date fechaTerminacion = rs.getDate("FECHA_TERMINACION");
            String status = rs.getString("STATUS");
            int idContacto = rs.getInt("ID_CONTACTO_EMPRESA");
            int idCostoActividad = rs.getInt("ID_COSTO_OPERACION");
            int idTipoActividad = rs.getInt("ID_TIPO_EMPRESA");

            EmpresaDifusora empresaDifusora = new EmpresaDifusora(idEmpresaDifusora, nombreEmpresa, fechaCreacion,
                    fechaTerminacion, status, tipoActividad.obtenerTipoEmpresaDifusora(idTipoActividad),
                    costoOperacion.obtenerCostoActividad(idCostoActividad), contacto.obtenerContacto(idContacto));

            listaEmpresasDifusora.add(empresaDifusora);
        }

        stmt.close();
        return listaEmpresasDifusora;
    }

    @Override
    public EmpresaDifusora obtenerEmpresaDifusora(int idEmpresaDifusora) throws SQLException {
        String sql = "SELECT ID_EMPRESA_DIFUSORA,NOMBRE_EMPRESA,FECHA_CREACION,FECHA_TERMINACION,STATUS,\n"
                + "ID_TIPO_EMPRESA, ID_CONTACTO_EMPRESA, ID_COSTO_OPERACION\n"
                + "FROM EMPRESA_DIFUSORA\n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idEmpresaDifusora);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombreEmpresa = rs.getString("NOMBRE_EMPRESA");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            Date fechaTerminacion = rs.getDate("FECHA_TERMINACION");
            String status = rs.getString("STATUS");
            int idContacto = rs.getInt("ID_CONTACTO_EMPRESA");
            int idCostoActividad = rs.getInt("ID_COSTO_OPERACION");
            int idTipoActividad = rs.getInt("ID_TIPO_EMPRESA");

            EmpresaDifusora empresaDifusora = new EmpresaDifusora(idEmpresaDifusora, nombreEmpresa, fechaCreacion,
                    fechaTerminacion, status, tipoActividad.obtenerTipoEmpresaDifusora(idTipoActividad),
                    costoOperacion.obtenerCostoActividad(idCostoActividad), contacto.obtenerContacto(idContacto));
            return empresaDifusora;
        }

        return null;
    }

    @Override
    public void crearEmpresaDifusora(EmpresaDifusora empresaDifusora) throws SQLException {
        String sql = "INSERT INTO EMPRESA_DIFUSORA (NOMBRE_EMPRESA,FECHA_CREACION,FECHA_TERMINACION,STATUS,\n"
                + "ID_TIPO_EMPRESA, ID_CONTACTO_EMPRESA, ID_COSTO_OPERACION)\n"
                + "VALUES (?,?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, empresaDifusora.getNombre());
        ps.setDate(2, empresaDifusora.getFechaCreacion());
        ps.setDate(3, empresaDifusora.getFechaTerminacion());
        ps.setString(4, empresaDifusora.getStatus());
        ps.setInt(5, empresaDifusora.getTipoActividad().getIdTipoActividad());
        ps.setInt(6, empresaDifusora.getCostoOperacion().getIdCostoActividad());
        ps.setInt(7, empresaDifusora.getContacto().getIdContacto());
        ps.executeUpdate();
    }

    @Override
    public void eliminarEmpresaDifusora(String status, int idEmpresaDifusora) throws SQLException {
        String sql = "UPDATE EMPRESA_DIFUSORA\n"
                + "SET STATUS=?\n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, status);
        ps.setInt(2, idEmpresaDifusora);
        ps.executeUpdate();
    }

    @Override
    public void actualizarEmpresaDifusora(EmpresaDifusora empresaDifusora) throws SQLException {
        String sql = "UPDATE EMPRESA_DIFUSORA\n"
                + "SET NOMBRE_EMPRESA=?,FECHA_CREACION=?,FECHA_TERMINACION=?,STATUS=?,\n"
                + "ID_TIPO_EMPRESA=?, ID_CONTACTO_EMPRESA=?, ID_COSTO_OPERACION=?\n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, empresaDifusora.getNombre());
        ps.setDate(2, empresaDifusora.getFechaCreacion());
        ps.setDate(3, empresaDifusora.getFechaTerminacion());
        ps.setString(4, empresaDifusora.getStatus());
        ps.setInt(5, empresaDifusora.getTipoActividad().getIdTipoActividad());
        ps.setInt(6, empresaDifusora.getCostoOperacion().getIdCostoActividad());
        ps.setInt(7, empresaDifusora.getContacto().getIdContacto());
        ps.setInt(8, empresaDifusora.getIdEmpresaDifusora());
        ps.executeUpdate();
    }
}

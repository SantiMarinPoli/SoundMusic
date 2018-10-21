package co.com.soundMusic.EmpresaDifusora;

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

    //Conexion a la base de datos
    private final Connection conexion;

    //Constantes con las querys a la base de datos
    private static final String SELECT_EMPRESAS;
    private static final String SELECT_EMPRESA_POOR_ID;
    private static final String INSERT_EMPRESA;
    private static final String UPDATE_STATUS;
    private static final String UPDATE_EMPRSA;
    private static final String SELECT_ULTIMO_ID;

    public EmpresaDifusoraDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public List<EmpresaDifusora> obtenerEmpresasDifusoras() throws SQLException {
        List<EmpresaDifusora> listaEmpresasDifusora = new ArrayList<>();

        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(SELECT_EMPRESAS);

        while (rs.next()) {
            int idEmpresaDifusora = rs.getInt("ID_EMPRESA_DIFUSORA");
            String nombreEmpresa = rs.getString("NOMBRE");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            Date fechaTerminacion = rs.getDate("FECHA_TERMINACION");
            String status = rs.getString("STATUS");
            String rutaImagen = rs.getString("RUTA_IMAGEN");
            int idTipoActividad = rs.getInt("ID_TIPO_ACTIVIDAD");
            int idContacto = rs.getInt("ID_CONTACTO");
            int idCostoOperacion = rs.getInt("ID_COSTO_ACTIVIDAD");

            EmpresaDifusora empresaDifusora = new EmpresaDifusora(idEmpresaDifusora, nombreEmpresa, fechaCreacion,
                    fechaTerminacion, status, rutaImagen, idTipoActividad, idContacto, idCostoOperacion);

            listaEmpresasDifusora.add(empresaDifusora);
        }

        stmt.close();
        return listaEmpresasDifusora;
    }

    @Override
    public EmpresaDifusora obtenerEmpresaDifusora(int idEmpresaDifusora) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_EMPRESA_POOR_ID);
        ps.setInt(1, idEmpresaDifusora);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombreEmpresa = rs.getString("NOMBRE");
            Date fechaCreacion = rs.getDate("FECHA_CREACION");
            Date fechaTerminacion = rs.getDate("FECHA_TERMINACION");
            String status = rs.getString("STATUS");
            String rutaImagen = rs.getString("RUTA_IMAGEN");
            int idTipoActividad = rs.getInt("ID_TIPO_ACTIVIDAD");
            int idContacto = rs.getInt("ID_CONTACTO");
            int idCostoOperacion = rs.getInt("ID_COSTO_ACTIVIDAD");

            EmpresaDifusora empresaDifusora = new EmpresaDifusora(idEmpresaDifusora, nombreEmpresa, fechaCreacion,
                    fechaTerminacion, status, rutaImagen, idTipoActividad, idContacto, idCostoOperacion);
            return empresaDifusora;
        }

        return null;
    }

    @Override
    public void crearEmpresaDifusora(EmpresaDifusora empresaDifusora) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_EMPRESA);

        ps.setString(1, empresaDifusora.getNombre());
        ps.setDate(2, empresaDifusora.getFechaCreacion());
        ps.setDate(3, empresaDifusora.getFechaTerminacion());
        ps.setString(4, empresaDifusora.getStatus());
        ps.setString(5, empresaDifusora.getRutaImagen());
        ps.setInt(6, empresaDifusora.getIdTipoActividad());
        ps.setInt(7, empresaDifusora.getIdContacto());
        ps.setInt(8, empresaDifusora.getIdCostoOperacion());
        ps.executeUpdate();
    }

    @Override
    public void eliminarEmpresaDifusora(String status, int idEmpresaDifusora) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_STATUS);
        ps.setString(1, status);
        ps.setInt(2, idEmpresaDifusora);
        ps.executeUpdate();
    }

    @Override
    public void actualizarEmpresaDifusora(EmpresaDifusora empresaDifusora) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_EMPRSA);

        ps.setString(1, empresaDifusora.getNombre());
        ps.setDate(2, empresaDifusora.getFechaTerminacion());
        ps.setString(3, empresaDifusora.getStatus());
        ps.setString(4, empresaDifusora.getRutaImagen());
        ps.setInt(5, empresaDifusora.getIdTipoActividad());
        ps.setInt(6, empresaDifusora.getIdContacto());
        ps.setInt(7, empresaDifusora.getIdCostoOperacion());
        ps.setInt(8, empresaDifusora.getIdEmpresaDifusora());
        ps.executeUpdate();
    }

    public int getUltimoIdEmpresaDifusora() throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_ULTIMO_ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idEmpresaDifusora = rs.getInt("CURRVAL");
            return idEmpresaDifusora;
        }
        return -1;
    }

    static {
        SELECT_EMPRESAS = "SELECT ID_EMPRESA_DIFUSORA,NOMBRE,FECHA_CREACION,FECHA_TERMINACION,STATUS,\n"
                + "RUTA_IMAGEN, ID_TIPO_ACTIVIDAD, ID_CONTACTO, ID_COSTO_ACTIVIDAD\n"
                + "FROM EMPRESA_DIFUSORA \n"
                + "ORDER BY ID_EMPRESA_DIFUSORA";

        SELECT_EMPRESA_POOR_ID = "SELECT ID_EMPRESA_DIFUSORA,NOMBRE,FECHA_CREACION,FECHA_TERMINACION,STATUS,\n"
                + "RUTA_IMAGEN, ID_TIPO_ACTIVIDAD, ID_CONTACTO, ID_COSTO_ACTIVIDAD\n"
                + "FROM EMPRESA_DIFUSORA \n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";

        INSERT_EMPRESA = "INSERT INTO EMPRESA_DIFUSORA (NOMBRE,FECHA_CREACION,FECHA_TERMINACION,STATUS,\n"
                + "RUTA_IMAGEN, ID_TIPO_ACTIVIDAD, ID_CONTACTO, ID_COSTO_ACTIVIDAD)\n"
                + "VALUES (?,?,?,?,?,?,?,?)";

        UPDATE_STATUS = "UPDATE EMPRESA_DIFUSORA\n"
                + "SET STATUS=?\n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";

        UPDATE_EMPRSA = "UPDATE EMPRESA_DIFUSORA\n"
                + "SET NOMBRE=?,FECHA_TERMINACION=?,STATUS=?,RUTA_IMAGEN=?,\n"
                + "ID_TIPO_ACTIVIDAD=?, ID_CONTACTO=?, ID_COSTO_ACTIVIDAD=?\n"
                + "WHERE ID_EMPRESA_DIFUSORA=?";

        SELECT_ULTIMO_ID = "SELECT EMPRESA_DIFUSORA_SEQ.CURRVAL\n"
                + "FROM DUAL";
    }
}

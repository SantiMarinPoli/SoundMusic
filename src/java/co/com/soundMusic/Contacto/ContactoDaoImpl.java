package co.com.soundMusic.Contacto;

import co.com.soundMusic.utilidades.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ContactoDaoImpl implements IContactoDao {

    //Conexion a la base de datos
    private final Connection conexion;
    //Constantes con las querys a la base de datos
    private static final String SELECT_CONTACTO_POR_ID;
    private static final String INSERT_CONTACTO;
    private static final String UPDATE_CONTACTO;
    private static final String SELECT_ULTIMO_ID;

    public ContactoDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public Contacto obtenerContacto(int idContacto) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_CONTACTO_POR_ID);
        ps.setInt(1, idContacto);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            String[] datosContacto = {rs.getString("CELULAR"), rs.getString("TELEFONO"), rs.getString("DIRECCION"),
                rs.getString("BARRIO"), rs.getString("EMAIL")};

            Contacto contacto = new Contacto(idContacto, datosContacto, rs.getInt("ID_CIUDAD"));
            return contacto;
        }
        return null;
    }

    @Override
    public void crearContacto(Contacto contacto) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(INSERT_CONTACTO);

        ps.setString(1, contacto.getCelular());
        ps.setString(2, contacto.getTelefono());
        ps.setString(3, contacto.getDireccion());
        ps.setString(4, contacto.getBarrio());
        ps.setString(5, contacto.getEmail());
        ps.setInt(6, contacto.getIdCiudad());
        ps.executeUpdate();
    }

    @Override
    public void actualizarContacto(Contacto contacto) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(UPDATE_CONTACTO);

        ps.setString(1, contacto.getCelular());
        ps.setString(2, contacto.getTelefono());
        ps.setString(3, contacto.getDireccion());
        ps.setString(4, contacto.getBarrio());
        ps.setString(5, contacto.getEmail());
        ps.setInt(6, contacto.getIdCiudad());
        ps.setInt(7, contacto.getIdContacto());
        ps.executeUpdate();
    }

    public int getUltimoIdContacto() throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(SELECT_ULTIMO_ID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idContacto = rs.getInt("CURRVAL");
            return idContacto;
        }
        return -1;
    }

    static {
        SELECT_CONTACTO_POR_ID = "SELECT CELULAR, TELEFONO, DIRECCION, BARRIO, EMAIL, ID_CIUDAD\n"
                + "FROM CONTACTO\n"
                + "WHERE ID_CONTACTO=?";

        INSERT_CONTACTO = "INSERT INTO CONTACTO (CELULAR, TELEFONO, DIRECCION,BARRIO,EMAIL, ID_CIUDAD) \n"
                + "VALUES (?,?,?,?,?,?)";

        UPDATE_CONTACTO = "UPDATE CONTACTO\n"
                + "SET  CELULAR=?, TELEFONO=?, DIRECCION=?, BARRIO=?,  EMAIL=?, ID_CIUDAD=?\n"
                + "WHERE ID_CONTACTO=?";

        SELECT_ULTIMO_ID = "SELECT CONTACTO_SEQ.CURRVAL\n"
                + "FROM DUAL";
    }
}

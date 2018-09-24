package co.com.soundMusic.Contacto;

import co.com.soundMusic.Contacto.Ciudad.CiudadDaoImpl;
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

    private Connection conexion;
    private CiudadDaoImpl ciudad;

    public ContactoDaoImpl() {
        conexion = DBUtil.getConexion();
        ciudad = new CiudadDaoImpl();
    }

    @Override
    public Contacto obtenerContacto(int idContacto) throws SQLException {
        String sql = "SELECT CELULAR, TELEFONO, DIRECCION, BARRIO, EMAIL, ID_CIUDAD\n"
                + "FROM CONTACTO\n"
                + "WHERE ID_CONTACTO=?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idContacto);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            String[] datosContacto = {rs.getString("CELULAR"), rs.getString("TELEFONO"), rs.getString("DIRECCION"),
                rs.getString("BARRIO"), rs.getString("EMAIL")};

            Contacto contacto = new Contacto(idContacto, datosContacto, ciudad.obtenerCiudad(rs.getInt("ID_CIUDAD")));
            return contacto;
        }
        return null;
    }

    @Override
    public void crearContacto(Contacto contacto) throws SQLException {
        String sql = "INSERT INTO CONTACTO (CELULAR, TELEFONO, DIRECCION,BARRIO,EMAIL, ID_CIUDAD) \n"
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, contacto.getCelular());
        ps.setString(2, contacto.getTelefono());
        ps.setString(3, contacto.getDireccion());
        ps.setString(4, contacto.getBarrio());
        ps.setString(5, contacto.getEmail());
        ps.setInt(6, contacto.getCiudad().getIdCiudad());
        ps.executeUpdate();
    }

    @Override
    public void actualizarContacto(Contacto contacto) throws SQLException {
        String sql = "UPDATE CONTACTO\n"
                + "SET  CELULAR=?, TELEFONO=?, DIRECCION=?, BARRIO=?,  EMAIL=?, ID_CIUDAD=?\n"
                + "WHERE ID_CONTACTO=?";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, contacto.getCelular());
        ps.setString(2, contacto.getTelefono());
        ps.setString(3, contacto.getDireccion());
        ps.setString(4, contacto.getBarrio());
        ps.setString(5, contacto.getEmail());
        ps.setInt(6, contacto.getCiudad().getIdCiudad());
        ps.setInt(7, contacto.getIdContacto());
        ps.executeUpdate();
    }

    public int getUltimoIdContacto() throws SQLException {
        String sql = "SELECT CONTACTO_SEQ.CURRVAL\n"
                + "FROM DUAL";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        while (rs.next()) {
            int idContacto = rs.getInt("CURRVAL");
            return idContacto;
        }
        return -1;
    }
    
}

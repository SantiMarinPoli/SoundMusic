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

    private Connection conexion;

    public ContactoDaoImpl() {
        conexion = DBUtil.getConexion();
    }

    @Override
    public Contacto obtenerContacto(int idCont) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idCont);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idContacto = rs.getInt("ID_CONTACTO");
            String direccion = rs.getString("DIRECCION");
            String barrio = rs.getString("BARRIO");
            String telefono = rs.getString("TELEFONO");
            String celular = rs.getString("CELULAR");
            String email = rs.getString("EMAIL");

            Contacto contacto = new Contacto(idContacto, direccion, barrio, telefono,
                    celular, email);
            return contacto;
        }
        return null;
    }

    @Override
    public void crearContacto(Contacto contacto) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, contacto.getDireccion());
        ps.setString(2, contacto.getBarrio());
        ps.setString(3, contacto.getTelefono());
        ps.setString(4, contacto.getCelular());
        ps.setString(5, contacto.getEmail());
        ps.executeUpdate();
    }

    @Override
    public void eliminarContacto(int idContacto) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idContacto);
        ps.executeUpdate();
    }

    @Override
    public void actualizarContacto(Contacto contacto) throws SQLException {
        String sql = "";
        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, contacto.getDireccion());
        ps.setString(2, contacto.getBarrio());
        ps.setString(3, contacto.getTelefono());
        ps.setString(4, contacto.getCelular());
        ps.setString(5, contacto.getEmail());
        ps.executeUpdate();
    }

}

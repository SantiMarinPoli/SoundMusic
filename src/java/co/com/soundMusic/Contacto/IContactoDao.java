package co.com.soundMusic.Contacto;

import java.sql.SQLException;

/**
 *
 * @author Santiago Medina Pelaez
 */
public interface IContactoDao {

    Contacto obtenerContacto(int idContacto) throws SQLException;
    void crearContacto(Contacto contacto) throws SQLException;    
    void actualizarContacto (Contacto contacto) throws SQLException;
}
